package com.ab.view.sample;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbViewPager.java 描述：可设置是否滑动的ViewPager.
 * 
 */
public class AbViewPager extends ViewPager {

	/** The enabled. */
	private boolean enabled;

	/**
	 * Instantiates a new ab un slide view pager.
	 * 
	 * @param context
	 *            the context
	 */
	public AbViewPager(Context context) {
		super(context);
		this.enabled = true;
	}

	/**
	 * Instantiates a new ab un slide view pager.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 */
	public AbViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.enabled = true;
	}

	/**
	 * 描述：触摸没有反应就可以了.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 * @see android.support.v4.view.ViewPager#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (this.enabled) {
			return super.onTouchEvent(event);
		}

		return false;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @param event
	 *            the event
	 * @return true, if successful
	 * @see android.support.v4.view.ViewPager#onInterceptTouchEvent(android.view.MotionEvent)
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:50
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (this.enabled) {
			return super.onInterceptTouchEvent(event);
		}

		return false;
	}

	/**
	 * Sets the paging enabled.
	 * 
	 * @param enabled
	 *            the new paging enabled
	 */
	public void setPagingEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
