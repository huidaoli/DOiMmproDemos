package com.ab.soap;

import android.content.Context;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 
 * 名称：AbSoapUtil.java 
 * 描述：Soap请求工具类
 * 
 */
public class AbSoapUtil {

	/** 实例话对象. */
	private AbSoapClient mClient = null;

	/** AbSoapUtil实例. */
	private static AbSoapUtil mAbSoapUtil;

	/**
	 * 单例 获取AbSoapUtil实例.
	 * 
	 * @param context
	 *            the context
	 * @return single instance of AbSoapUtil
	 */
	public static AbSoapUtil getInstance(Context context) {
		if (null == mAbSoapUtil) {
			mAbSoapUtil = new AbSoapUtil(context);
		}
		return mAbSoapUtil;
	}

	/**
	 * AbSoapUtil构造方法.
	 * 
	 * @param context
	 *            the context
	 */
	private AbSoapUtil(Context context) {
		super();
		this.mClient = new AbSoapClient(context);
	}

	/**
	 * Call.
	 * 
	 * @param url
	 *            the url
	 * @param nameSpace
	 *            the name space
	 * @param methodName
	 *            the method name
	 * @param params
	 *            the params
	 * @param listener
	 *            the listener
	 */
	public void call(String url, String nameSpace, String methodName,
			AbSoapParams params, AbSoapListener listener) {
		mClient.call(url, nameSpace, methodName, params, listener);
	}

	/**
	 * 描述：设置连接超时时间(第一次请求前设置).
	 * 
	 * @param timeout
	 *            毫秒
	 */
	public void setTimeout(int timeout) {
		mClient.setTimeout(timeout);
	}
	
	/**
	 * Sets the dot net.
	 *
	 * @param dotNet the new dot net
	 */
	public void setDotNet(boolean dotNet) {
		mClient.setDotNet(dotNet);
	}
	
	
}
