package com.ab.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.ab.util.AbLogUtil;

public class AuthSSLProtocolSocketFactory implements LayeredSocketFactory {

	private URL keystoreUrl = null;
	private String keystorePassword = null;
	private URL truststoreUrl = null;
	private String truststorePassword = null;
	private SSLContext sslcontext = null;

	/***
	 * Constructor for AuthSSLProtocolSocketFactory. Either a keystore or
	 * truststore file must be given. Otherwise SSL context initialization error
	 * will result.
	 * 
	 * @param keystoreUrl
	 *            URL of the keystore file. May be <tt>null</tt> if HTTPS client
	 *            authentication is not to be used.
	 * @param keystorePassword
	 *            Password to unlock the keystore. IMPORTANT: this
	 *            implementation assumes that the same password is used to
	 *            protect the key and the keystore itself.
	 * @param truststoreUrl
	 *            URL of the truststore file. May be <tt>null</tt> if HTTPS
	 *            server authentication is not to be used.
	 * @param truststorePassword
	 *            Password to unlock the truststore.
	 */
	public AuthSSLProtocolSocketFactory(final URL keystoreUrl,
			final String keystorePassword, final URL truststoreUrl,
			final String truststorePassword) {
		super();
		this.keystoreUrl = keystoreUrl;
		this.keystorePassword = keystorePassword;
		this.truststoreUrl = truststoreUrl;
		this.truststorePassword = truststorePassword;
	}

	private static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException {
		if (url == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
				"Initializing key store");
		KeyStore keystore = KeyStore.getInstance("jks");
		InputStream is = null;
		try {
			is = url.openStream();
			keystore.load(is, password != null ? password.toCharArray() : null);
		} finally {
			if (is != null)
				is.close();
		}
		return keystore;
	}

	private static KeyManager[] createKeyManagers(final KeyStore keystore,
			final String password) throws KeyStoreException,
			NoSuchAlgorithmException, UnrecoverableKeyException {
		if (keystore == null) {
			throw new IllegalArgumentException("Keystore may not be null");
		}
		AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
				"Initializing key manager");
		KeyManagerFactory kmfactory = KeyManagerFactory
				.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmfactory.init(keystore, password != null ? password.toCharArray()
				: null);
		return kmfactory.getKeyManagers();
	}

	private static TrustManager[] createTrustManagers(final KeyStore keystore)
			throws KeyStoreException, NoSuchAlgorithmException {
		if (keystore == null) {
			throw new IllegalArgumentException("Keystore may not be null");
		}
		AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
				"Initializing trust manager");
		TrustManagerFactory tmfactory = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmfactory.init(keystore);
		TrustManager[] trustmanagers = tmfactory.getTrustManagers();
		for (int i = 0; i < trustmanagers.length; i++) {
			if (trustmanagers[i] instanceof X509TrustManager) {
				trustmanagers[i] = new AuthSSLX509TrustManager(
						(X509TrustManager) trustmanagers[i]);
			}
		}
		return trustmanagers;
	}

	private SSLContext createSSLContext() {
		try {
			KeyManager[] keymanagers = null;
			TrustManager[] trustmanagers = null;
			if (this.keystoreUrl != null) {
				KeyStore keystore = createKeyStore(this.keystoreUrl,
						this.keystorePassword);
				if (AbLogUtil.D) {
					Enumeration aliases = keystore.aliases();
					while (aliases.hasMoreElements()) {
						String alias = (String) aliases.nextElement();
						Certificate[] certs = keystore
								.getCertificateChain(alias);
						if (certs != null) {
							AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
									"Certificate chain '" + alias + "':");
							for (int c = 0; c < certs.length; c++) {
								if (certs[c] instanceof X509Certificate) {
									X509Certificate cert = (X509Certificate) certs[c];
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											" Certificate " + (c + 1) + ":");
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											"  Subject DN: "
													+ cert.getSubjectDN());
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											"  Signature Algorithm: "
													+ cert.getSigAlgName());
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											"  Valid from: "
													+ cert.getNotBefore());
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											"  Valid until: "
													+ cert.getNotAfter());
									AbLogUtil.d(
											AuthSSLProtocolSocketFactory.class,
											"  Issuer: " + cert.getIssuerDN());
								}
							}
						}
					}
				}
				keymanagers = createKeyManagers(keystore, this.keystorePassword);
			}
			if (this.truststoreUrl != null) {
				KeyStore keystore = createKeyStore(this.truststoreUrl,
						this.truststorePassword);
				if (AbLogUtil.D) {
					Enumeration aliases = keystore.aliases();
					while (aliases.hasMoreElements()) {
						String alias = (String) aliases.nextElement();
						AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
								"Trusted certificate '" + alias + "':");
						Certificate trustedcert = keystore
								.getCertificate(alias);
						if (trustedcert != null
								&& trustedcert instanceof X509Certificate) {
							X509Certificate cert = (X509Certificate) trustedcert;
							AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
									"  Subject DN: " + cert.getSubjectDN());
							AbLogUtil.d(
									AuthSSLProtocolSocketFactory.class,
									"  Signature Algorithm: "
											+ cert.getSigAlgName());
							AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
									"  Valid from: " + cert.getNotBefore());
							AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
									"  Valid until: " + cert.getNotAfter());
							AbLogUtil.d(AuthSSLProtocolSocketFactory.class,
									"  Issuer: " + cert.getIssuerDN());
						}
					}
				}
				trustmanagers = createTrustManagers(keystore);
			}
			SSLContext sslcontext = SSLContext.getInstance("SSL");
			sslcontext.init(keymanagers, trustmanagers, null);
			return sslcontext;
		} catch (NoSuchAlgorithmException e) {
			AbLogUtil.e(AuthSSLProtocolSocketFactory.class, e.getMessage());
			throw new AuthSSLInitializationError(
					"Unsupported algorithm exception: " + e.getMessage());
		} catch (KeyStoreException e) {
			AbLogUtil.e(AuthSSLProtocolSocketFactory.class, e.getMessage());
			throw new AuthSSLInitializationError("Keystore exception: "
					+ e.getMessage());
		} catch (GeneralSecurityException e) {
			AbLogUtil.e(AuthSSLProtocolSocketFactory.class, e.getMessage());
			throw new AuthSSLInitializationError("Key management exception: "
					+ e.getMessage());
		} catch (IOException e) {
			AbLogUtil.e(AuthSSLProtocolSocketFactory.class, e.getMessage());
			throw new AuthSSLInitializationError(
					"I/O error reading keystore/truststore file: "
							+ e.getMessage());
		}
	}

	private SSLContext getSSLContext() {
		if (this.sslcontext == null) {
			this.sslcontext = createSSLContext();
		}
		return this.sslcontext;
	}

	/***
	 * Attempts to get a new socket connection to the given host within the
	 * given time limit.
	 * <p>
	 * To circumvent the limitations of older JREs that do not support connect
	 * timeout a controller thread is executed. The controller thread attempts
	 * to create a new socket within the given limit of time. If socket
	 * constructor does not return until the timeout expires, the controller
	 * terminates and throws an {@link ConnectTimeoutException}
	 * </p>
	 * 
	 * @param host
	 *            the host name/IP
	 * @param port
	 *            the port on the host
	 * @param clientHost
	 *            the local host name/IP to bind the socket to
	 * @param clientPort
	 *            the port on the local machine
	 * @param params
	 *            {@link HttpConnectionParams Http connection parameters}
	 * 
	 * @return Socket a new socket
	 * 
	 * @throws IOException
	 *             if an I/O error occurs while creating the socket
	 * @throws UnknownHostException
	 *             if the IP address of the host cannot be determined
	 */
	public Socket createSocket(final String host, final int port,
			final InetAddress localAddress, final int localPort,
			final HttpConnectionParams params) throws IOException,
			UnknownHostException, ConnectTimeoutException {
		if (params == null) {
			throw new IllegalArgumentException("Parameters may not be null");
		}
		int timeout = AbHttpClient.DEFAULT_SOCKET_TIMEOUT;
		SocketFactory socketfactory = getSSLContext().getSocketFactory();
		if (timeout == 0) {
			return socketfactory.createSocket(host, port, localAddress,
					localPort);
		} else {
			Socket socket = socketfactory.createSocket();
			SocketAddress localaddr = new InetSocketAddress(localAddress,
					localPort);
			SocketAddress remoteaddr = new InetSocketAddress(host, port);
			socket.bind(localaddr);
			socket.connect(remoteaddr, timeout);
			return socket;
		}
	}

	/***
	 * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int,java.net.InetAddress,int)
	 */
	public Socket createSocket(String host, int port, InetAddress clientHost,
			int clientPort) throws IOException, UnknownHostException {
		return getSSLContext().getSocketFactory().createSocket(host, port,
				clientHost, clientPort);
	}

	/***
	 * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int)
	 */
	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
		return getSSLContext().getSocketFactory().createSocket(host, port);
	}

	/***
	 * @see SecureProtocolSocketFactory#createSocket(java.net.Socket,java.lang.String,int,boolean)
	 */
	public Socket createSocket(Socket socket, String host, int port,
			boolean autoClose) throws IOException, UnknownHostException {
		return getSSLContext().getSocketFactory().createSocket(socket, host,
				port, autoClose);
	}

	@Override
	public Socket connectSocket(Socket sock, String host, int port,
			InetAddress localAddress, int localPort, HttpParams params)
			throws IOException, UnknownHostException, ConnectTimeoutException {
		int connTimeout = HttpConnectionParams.getConnectionTimeout(params);
		int soTimeout = HttpConnectionParams.getSoTimeout(params);

		InetSocketAddress remoteAddress = new InetSocketAddress(host, port);
		SSLSocket sslsock = (SSLSocket) ((sock != null) ? sock : createSocket());

		if ((localAddress != null) || (localPort > 0)) {
			// we need to bind explicitly
			if (localPort < 0) {
				localPort = 0; // indicates "any"
			}
			InetSocketAddress isa = new InetSocketAddress(localAddress,
					localPort);
			sslsock.bind(isa);
		}

		sslsock.connect(remoteAddress, connTimeout);
		sslsock.setSoTimeout(soTimeout);
		return sslsock;
	}

	@Override
	public Socket createSocket() throws IOException {
		return getSSLContext().getSocketFactory().createSocket();
	}

	@Override
	public boolean isSecure(Socket arg0) throws IllegalArgumentException {
		return true;
	}

}
