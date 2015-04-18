package com.ab.view.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
// TODO: Auto-generated Javadoc
import android.widget.ImageView;

/**
 * © 2012 amsoft.cn 名称：AbCompassView.java 描述：指南针
 * 
 */
public class AbCompassView extends ImageView {

	/** 上下文. */
	private Context mContext = null;

	/** 指南针图标. */
	private Drawable mCompassDrawable = null;

	/** 方向. */
	private float mDirection = 0.0f;

	/**
	 * Instantiates a new ab compass view.
	 * 
	 * @param context
	 *            the context
	 */
	public AbCompassView(Context context) {
		this(context, null);

	}

	/**
	 * Instantiates a new ab compass view.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 */
	public AbCompassView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.TRANSPARENT);
		int h = getHeight();
		int w = getWidth();
		canvas.rotate(-(90 + this.mDirection), w / 2, h / 2);
		super.onDraw(canvas);
	}

	/**
	 * Gets the direction.
	 * 
	 * @return the direction
	 */
	public float getDirection() {
		return mDirection;
	}

	/**
	 * Sets the direction.
	 * 
	 * @param direction
	 *            the new direction
	 */
	public void setDirection(float direction) {
		this.mDirection = direction;
		this.invalidate();
	}

	/**
	 * 描述：设置指南针图片.
	 * 
	 * @param drawable
	 *            必须设置才能显示
	 */
	public void setCompassDrawable(Drawable drawable) {
		this.mCompassDrawable = drawable;
		this.mCompassDrawable.setBounds(0, 0,
				this.mCompassDrawable.getIntrinsicWidth(),
				this.mCompassDrawable.getIntrinsicHeight());
		this.setImageDrawable(this.mCompassDrawable);
		this.invalidate();
	}

	/**
	 * 描述：设置指南针图片.
	 * 
	 * @param id
	 */
	public void setCompassDrawable(int id) {
		this.mCompassDrawable = mContext.getResources().getDrawable(id);
		this.mCompassDrawable.setBounds(0, 0,
				this.mCompassDrawable.getIntrinsicWidth(),
				this.mCompassDrawable.getIntrinsicHeight());
		this.setImageDrawable(this.mCompassDrawable);
		this.invalidate();
	}

}
