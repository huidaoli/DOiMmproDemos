package com.ab.view.chart;

// TODO: Auto-generated Javadoc
/**
 * A zoom listener.
 * 
 * @see ZoomEvent
 */
public interface ZoomListener {

	/**
	 * Called when a zoom change is triggered.
	 * 
	 * @param e
	 *            the zoom event
	 */
	void zoomApplied(ZoomEvent e);

	/**
	 * Called when a zoom reset is done.
	 */
	void zoomReset();
}
