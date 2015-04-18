package com.ab.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

import android.util.Log;

public class AuthSSLX509TrustManager implements X509TrustManager {
	private X509TrustManager defaultTrustManager = null;

	/** 日志标记. */
	private static final String TAG = "AuthSSLX509TrustManager";

	/***
	 * Constructor for AuthSSLX509TrustManager.
	 */
	public AuthSSLX509TrustManager(final X509TrustManager defaultTrustManager) {
		super();
		if (defaultTrustManager == null) {
			throw new IllegalArgumentException("Trust manager may not be null");
		}
		this.defaultTrustManager = defaultTrustManager;
	}

	/***
	 * @see javax.net.ssl.X509TrustManager#checkClientTrusted(X509Certificate[],
	 *      String authType)
	 */
	public void checkClientTrusted(X509Certificate[] certificates,
			String authType) throws CertificateException {
		if (certificates != null) {
			for (int c = 0; c < certificates.length; c++) {
				X509Certificate cert = certificates[c];
				Log.i(TAG, "  Client certificate " + (c + 1) + ":");
				Log.i(TAG, "  Subject DN: " + cert.getSubjectDN());
				Log.i(TAG, "  Signature Algorithm: " + cert.getSigAlgName());
				Log.i(TAG, "  Valid from: " + cert.getNotBefore());
				Log.i(TAG, "  Valid until: " + cert.getNotAfter());
				Log.i(TAG, "  Issuer: " + cert.getIssuerDN());
			}
		}
		defaultTrustManager.checkClientTrusted(certificates, authType);
	}

	/***
	 * @see javax.net.ssl.X509TrustManager#checkServerTrusted(X509Certificate[],
	 *      String authType)
	 */
	public void checkServerTrusted(X509Certificate[] certificates,
			String authType) throws CertificateException {
		if (certificates != null) {
			for (int c = 0; c < certificates.length; c++) {
				X509Certificate cert = certificates[c];
				Log.i(TAG, "  Server certificate " + (c + 1) + ":");
				Log.i(TAG, "  Subject DN: " + cert.getSubjectDN());
				Log.i(TAG, "  Signature Algorithm: " + cert.getSigAlgName());
				Log.i(TAG, "  Valid from: " + cert.getNotBefore());
				Log.i(TAG, "  Valid until: " + cert.getNotAfter());
				Log.i(TAG, "  Issuer: " + cert.getIssuerDN());
			}
		}
		defaultTrustManager.checkServerTrusted(certificates, authType);
	}

	/***
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	public X509Certificate[] getAcceptedIssuers() {
		return this.defaultTrustManager.getAcceptedIssuers();
	}
}
