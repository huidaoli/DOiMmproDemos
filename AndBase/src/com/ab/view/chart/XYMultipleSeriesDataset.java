package com.ab.view.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * A series that includes 0 to many XYSeries.
 */
public class XYMultipleSeriesDataset implements Serializable {
	/** The included series. */
	private List<XYSeries> mSeries = new ArrayList<XYSeries>();

	/**
	 * Adds a new XY series to the list.
	 * 
	 * @param series
	 *            the XY series to ass
	 */
	public synchronized void addSeries(XYSeries series) {
		mSeries.add(series);
	}

	/**
	 * Adds a new XY series to the list.
	 * 
	 * @param index
	 *            the index in the series list
	 * @param series
	 *            the XY series to ass
	 */
	public synchronized void addSeries(int index, XYSeries series) {
		mSeries.add(index, series);
	}

	/**
	 * Removes the XY series from the list.
	 * 
	 * @param index
	 *            the index in the series list of the series to remove
	 */
	public synchronized void removeSeries(int index) {
		mSeries.remove(index);
	}

	/**
	 * Removes the XY series from the list.
	 * 
	 * @param series
	 *            the XY series to be removed
	 */
	public synchronized void removeSeries(XYSeries series) {
		mSeries.remove(series);
	}

	/**
	 * Returns the XY series at the specified index.
	 * 
	 * @param index
	 *            the index
	 * @return the XY series at the index
	 */
	public synchronized XYSeries getSeriesAt(int index) {
		return mSeries.get(index);
	}

	/**
	 * Returns the XY series count.
	 * 
	 * @return the XY series count
	 */
	public synchronized int getSeriesCount() {
		return mSeries.size();
	}

	/**
	 * Returns an array of the XY series.
	 * 
	 * @return the XY series array
	 */
	public synchronized XYSeries[] getSeries() {
		return mSeries.toArray(new XYSeries[0]);
	}

}
