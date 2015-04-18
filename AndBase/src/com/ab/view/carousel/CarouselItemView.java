package com.ab.view.carousel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn 名称：CarouselItemView.java 描述：旋转木马的任意View
 * 
 */
public class CarouselItemView extends LinearLayout implements
		Comparable<CarouselItemView> {

	/** The m image. */
	private ImageView mImage;

	/** The m text. */
	private TextView mText;

	/** The index. */
	private int index;

	/** The current angle. */
	private float currentAngle;

	/** The item x. */
	private float itemX;

	/** The item y. */
	private float itemY;

	/** The item z. */
	private float itemZ;

	/** The drawn. */
	private boolean drawn;

	// It's needed to find screen coordinates
	/** The m ci matrix. */
	private Matrix mCIMatrix;

	/**
	 * Instantiates a new carousel item view.
	 * 
	 * @param context
	 *            the context
	 */
	public CarouselItemView(Context context) {
		super(context);
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return mText.getText().toString();
	}

	/**
	 * Sets the index.
	 * 
	 * @param index
	 *            the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets the index.
	 * 
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the current angle.
	 * 
	 * @param currentAngle
	 *            the new current angle
	 */
	public void setCurrentAngle(float currentAngle) {

		if (index == 0 && currentAngle > 5) {
			Log.d("", "");
		}

		this.currentAngle = currentAngle;
	}

	/**
	 * Gets the current angle.
	 * 
	 * @return the current angle
	 */
	public float getCurrentAngle() {
		return currentAngle;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @param another
	 *            the another
	 * @return the int
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * @author: amsoft.cn
	 * @date：2013-11-28 上午11:14:34
	 */
	public int compareTo(CarouselItemView another) {
		return (int) (another.itemZ - this.itemZ);
	}

	/**
	 * Sets the item x.
	 * 
	 * @param x
	 *            the new item x
	 */
	public void setItemX(float x) {
		this.itemX = x;
	}

	/**
	 * Gets the item x.
	 * 
	 * @return the item x
	 */
	public float getItemX() {
		return itemX;
	}

	/**
	 * Sets the item y.
	 * 
	 * @param y
	 *            the new item y
	 */
	public void setItemY(float y) {
		this.itemY = y;
	}

	/**
	 * Gets the item y.
	 * 
	 * @return the item y
	 */
	public float getItemY() {
		return itemY;
	}

	/**
	 * Sets the item z.
	 * 
	 * @param z
	 *            the new item z
	 */
	public void setItemZ(float z) {
		this.itemZ = z;
	}

	/**
	 * Gets the item z.
	 * 
	 * @return the item z
	 */
	public float getItemZ() {
		return itemZ;
	}

	/**
	 * Sets the drawn.
	 * 
	 * @param drawn
	 *            the new drawn
	 */
	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	/**
	 * Checks if is drawn.
	 * 
	 * @return true, if is drawn
	 */
	public boolean isDrawn() {
		return drawn;
	}

	/**
	 * Sets the image bitmap.
	 * 
	 * @param bitmap
	 *            the new image bitmap
	 */
	public void setImageBitmap(Bitmap bitmap) {
		mImage.setImageBitmap(bitmap);

	}

	/**
	 * Sets the text.
	 * 
	 * @param txt
	 *            the new text
	 */
	public void setText(String txt) {
		mText.setText(txt);
	}

	/**
	 * Gets the cI matrix.
	 * 
	 * @return the cI matrix
	 */
	Matrix getCIMatrix() {
		return mCIMatrix;
	}

	/**
	 * Sets the cI matrix.
	 * 
	 * @param mMatrix
	 *            the new cI matrix
	 */
	void setCIMatrix(Matrix mMatrix) {
		this.mCIMatrix = mMatrix;
	}

}
