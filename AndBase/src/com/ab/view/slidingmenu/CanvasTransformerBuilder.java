package com.ab.view.slidingmenu;

import android.graphics.Canvas;
import android.view.animation.Interpolator;

import com.ab.view.slidingmenu.SlidingMenu.CanvasTransformer;

// TODO: Auto-generated Javadoc
/**
 * The Class CanvasTransformerBuilder.
 */
public class CanvasTransformerBuilder {

	/** The m trans. */
	private CanvasTransformer mTrans;

	/** The lin. */
	private static Interpolator lin = new Interpolator() {
		public float getInterpolation(float t) {
			return t;
		}
	};

	/**
	 * Inits the transformer.
	 */
	private void initTransformer() {
		if (mTrans == null)
			mTrans = new CanvasTransformer() {
				public void transformCanvas(Canvas canvas, float percentOpen) {
				}
			};
	}

	/**
	 * Zoom.
	 * 
	 * @param openedX
	 *            the opened x
	 * @param closedX
	 *            the closed x
	 * @param openedY
	 *            the opened y
	 * @param closedY
	 *            the closed y
	 * @param px
	 *            the px
	 * @param py
	 *            the py
	 * @return the canvas transformer
	 */
	public CanvasTransformer zoom(final int openedX, final int closedX,
			final int openedY, final int closedY, final int px, final int py) {
		return zoom(openedX, closedX, openedY, closedY, px, py, lin);
	}

	/**
	 * Zoom.
	 * 
	 * @param openedX
	 *            the opened x
	 * @param closedX
	 *            the closed x
	 * @param openedY
	 *            the opened y
	 * @param closedY
	 *            the closed y
	 * @param px
	 *            the px
	 * @param py
	 *            the py
	 * @param interp
	 *            the interp
	 * @return the canvas transformer
	 */
	public CanvasTransformer zoom(final int openedX, final int closedX,
			final int openedY, final int closedY, final int px, final int py,
			final Interpolator interp) {
		initTransformer();
		mTrans = new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				mTrans.transformCanvas(canvas, percentOpen);
				float f = interp.getInterpolation(percentOpen);
				canvas.scale((openedX - closedX) * f + closedX,
						(openedY - closedY) * f + closedY, px, py);
			}
		};
		return mTrans;
	}

	/**
	 * Rotate.
	 * 
	 * @param openedDeg
	 *            the opened deg
	 * @param closedDeg
	 *            the closed deg
	 * @param px
	 *            the px
	 * @param py
	 *            the py
	 * @return the canvas transformer
	 */
	public CanvasTransformer rotate(final int openedDeg, final int closedDeg,
			final int px, final int py) {
		return rotate(openedDeg, closedDeg, px, py, lin);
	}

	/**
	 * Rotate.
	 * 
	 * @param openedDeg
	 *            the opened deg
	 * @param closedDeg
	 *            the closed deg
	 * @param px
	 *            the px
	 * @param py
	 *            the py
	 * @param interp
	 *            the interp
	 * @return the canvas transformer
	 */
	public CanvasTransformer rotate(final int openedDeg, final int closedDeg,
			final int px, final int py, final Interpolator interp) {
		initTransformer();
		mTrans = new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				mTrans.transformCanvas(canvas, percentOpen);
				float f = interp.getInterpolation(percentOpen);
				canvas.rotate((openedDeg - closedDeg) * f + closedDeg, px, py);
			}
		};
		return mTrans;
	}

	/**
	 * Translate.
	 * 
	 * @param openedX
	 *            the opened x
	 * @param closedX
	 *            the closed x
	 * @param openedY
	 *            the opened y
	 * @param closedY
	 *            the closed y
	 * @return the canvas transformer
	 */
	public CanvasTransformer translate(final int openedX, final int closedX,
			final int openedY, final int closedY) {
		return translate(openedX, closedX, openedY, closedY, lin);
	}

	/**
	 * Translate.
	 * 
	 * @param openedX
	 *            the opened x
	 * @param closedX
	 *            the closed x
	 * @param openedY
	 *            the opened y
	 * @param closedY
	 *            the closed y
	 * @param interp
	 *            the interp
	 * @return the canvas transformer
	 */
	public CanvasTransformer translate(final int openedX, final int closedX,
			final int openedY, final int closedY, final Interpolator interp) {
		initTransformer();
		mTrans = new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				mTrans.transformCanvas(canvas, percentOpen);
				float f = interp.getInterpolation(percentOpen);
				canvas.translate((openedX - closedX) * f + closedX,
						(openedY - closedY) * f + closedY);
			}
		};
		return mTrans;
	}

	/**
	 * Concat transformer.
	 * 
	 * @param t
	 *            the t
	 * @return the canvas transformer
	 */
	public CanvasTransformer concatTransformer(final CanvasTransformer t) {
		initTransformer();
		mTrans = new CanvasTransformer() {
			public void transformCanvas(Canvas canvas, float percentOpen) {
				mTrans.transformCanvas(canvas, percentOpen);
				t.transformCanvas(canvas, percentOpen);
			}
		};
		return mTrans;
	}

}
