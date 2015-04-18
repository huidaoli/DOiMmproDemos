package com.ab.view.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

//TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbLinedEditText.java 描述：带下横线的EditText
 * 
 */
public class AbLinedEditText extends EditText {

	/** The m rect. */
	private Rect mRect;

	/** The m paint. */
	private Paint mPaint;

	/**
	 * Instantiates a new ab lined edit text.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 */
	public AbLinedEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mRect = new Rect();
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(0x800000FF);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.TextView#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		int count = getLineCount();
		Rect r = mRect;
		Paint paint = mPaint;

		for (int i = 0; i < count; i++) {
			int baseline = getLineBounds(i, r);
			canvas.drawLine(r.left, baseline + 10, r.right, baseline + 10,
					paint);
		}

		super.onDraw(canvas);
	}
}