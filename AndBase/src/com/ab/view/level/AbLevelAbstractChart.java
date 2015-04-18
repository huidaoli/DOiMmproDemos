package com.ab.view.level;

import java.io.Serializable;

import android.graphics.Canvas;
import android.graphics.Paint;

// TODO: Auto-generated Javadoc
/**
 * The Class AbLevelAbstractChart.
 */
public abstract class AbLevelAbstractChart implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Draw.
	 * 
	 * @param canvas
	 *            the canvas
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param measureWidth
	 *            the measure width
	 * @param measureHeight
	 *            the measure height
	 * @param screenWidth
	 *            the screen width
	 * @param screenHeight
	 *            the screen height
	 * @param paint
	 *            the paint
	 */
	public abstract void draw(Canvas canvas, int x, int y, int measureWidth,
			int measureHeight, int screenWidth, int screenHeight, Paint paint);

}
