package com.ab.global;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

import com.ab.util.AbStrUtil;

public class AbAppException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1;

	/** 异常消息. */
	private String msg = null;

	/**
	 * 构造异常类.
	 * 
	 * @param e
	 *            异常
	 */
	public AbAppException(Exception e) {
		super();

		try {
			if (e instanceof HttpHostConnectException) {
				msg = AbAppConfig.UNKNOWN_HOST_EXCEPTION;
			} else if (e instanceof ConnectException) {
				msg = AbAppConfig.CONNECT_EXCEPTION;
			} else if (e instanceof ConnectTimeoutException) {
				msg = AbAppConfig.CONNECT_EXCEPTION;
			} else if (e instanceof UnknownHostException) {
				msg = AbAppConfig.UNKNOWN_HOST_EXCEPTION;
			} else if (e instanceof SocketException) {
				msg = AbAppConfig.SOCKET_EXCEPTION;
			} else if (e instanceof SocketTimeoutException) {
				msg = AbAppConfig.SOCKET_TIMEOUT_EXCEPTION;
			} else if (e instanceof NullPointerException) {
				msg = AbAppConfig.NULL_POINTER_EXCEPTION;
			} else if (e instanceof ClientProtocolException) {
				msg = AbAppConfig.CLIENT_PROTOCOL_EXCEPTION;
			} else {
				if (e == null || AbStrUtil.isEmpty(e.getMessage())) {
					msg = AbAppConfig.NULL_MESSAGE_EXCEPTION;
				} else {
					msg = e.getMessage();
				}
			}
		} catch (Exception e1) {
		}

	}

	/**
	 * 用一个消息构造异常类.
	 * 
	 * @param message
	 *            异常的消息
	 */
	public AbAppException(String message) {
		super(message);
		msg = message;
	}

	/**
	 * 描述：获取异常信息.
	 * 
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return msg;
	}

}
