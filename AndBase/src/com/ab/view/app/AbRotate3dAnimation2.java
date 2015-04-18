package com.ab.view.app;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbRotate3dAnimation2.java 描述：3d旋转
 * 
 */
public class AbRotate3dAnimation2 extends Animation {

	/** The m from degree. */
	private float mFromDegree;

	/** The m to degree. */
	private float mToDegree;

	/** The m center x. */
	private float mCenterX;

	/** The m center y. */
	private float mCenterY;

	/** The m left. */
	private float mLeft;

	/** The m top. */
	private float mTop;

	/** The m camera. */
	private Camera mCamera;

	/** The Constant TAG. */
	private static final String TAG = "Rotate3d";

	/**
	 * Instantiates a new ab rotate3d animation2.
	 * 
	 * @param fromDegree
	 *            the from degree
	 * @param toDegree
	 *            the to degree
	 * @param left
	 *            the left
	 * @param top
	 *            the top
	 * @param centerX
	 *            the center x
	 * @param centerY
	 *            the center y
	 */
	public AbRotate3dAnimation2(float fromDegree, float toDegree, float left,
			float top, float centerX, float centerY) {
		this.mFromDegree = fromDegree;
		this.mToDegree = toDegree;
		this.mLeft = left;
		this.mTop = top;
		this.mCenterX = centerX;
		this.mCenterY = centerY;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.animation.Animation#initialize(int, int, int, int)
	 */
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.animation.Animation#applyTransformation(float,
	 * android.view.animation.Transformation)
	 */
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		final float FromDegree = mFromDegree;
		float degrees = FromDegree + (mToDegree - mFromDegree)
				* interpolatedTime;
		final float centerX = mCenterX;
		final float centerY = mCenterY;
		final Matrix matrix = t.getMatrix();

		if (degrees <= -76.0f) {
			degrees = -90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else if (degrees >= 76.0f) {
			degrees = 90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else {
			mCamera.save();
			mCamera.translate(0, 0, centerX);
			mCamera.rotateY(degrees);
			mCamera.translate(0, 0, -centerX);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		}

		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
	}

}
