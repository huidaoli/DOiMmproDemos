package com.ab.view.chart;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * A class to encapsulate the definition of a point.
 */
public final class Point implements Serializable {
	/** The X axis coordinate value. */
	private float mX;
	/** The Y axis coordinate value. */
	private float mY;

	/**
	 * Instantiates a new point.
	 */
	public Point() {
	}

	/**
	 * Instantiates a new point.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Point(float x, float y) {
		mX = x;
		mY = y;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public float getX() {
		return mX;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public float getY() {
		return mY;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            the new x
	 */
	public void setX(float x) {
		mX = x;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            the new y
	 */
	public void setY(float y) {
		mY = y;
	}
}
