package com.ab.view.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbScrollTextView.java 描述：跑马灯一直跑
 * 
 */
public class AbScrollTextView extends TextView {

	/**
	 * Instantiates a new ab scroll text view.
	 * 
	 * @param context
	 *            the context
	 */
	public AbScrollTextView(Context context) {
		super(context);
	}

	/**
	 * Instantiates a new ab scroll text view.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 */
	public AbScrollTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * Instantiates a new ab scroll text view.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 * @param defStyle
	 *            the def style
	 */
	public AbScrollTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * 描述：设置为焦点，能一直滚动.
	 */
	@Override
	public boolean isFocused() {
		return true;
	}

}
