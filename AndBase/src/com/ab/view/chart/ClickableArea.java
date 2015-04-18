package com.ab.view.chart;

import android.graphics.RectF;

// TODO: Auto-generated Javadoc
/**
 * The Class ClickableArea.
 */
public class ClickableArea {

	/** The rect. */
	private RectF rect;

	/** The x. */
	private double x;

	/** The y. */
	private double y;

	/**
	 * Instantiates a new clickable area.
	 * 
	 * @param rect
	 *            the rect
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public ClickableArea(RectF rect, double x, double y) {
		super();
		this.rect = rect;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the rect.
	 * 
	 * @return the rect
	 */
	public RectF getRect() {
		return rect;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public double getY() {
		return y;
	}

}
