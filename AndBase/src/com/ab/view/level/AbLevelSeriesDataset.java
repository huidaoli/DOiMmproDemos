package com.ab.view.level;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AbLevelSeriesDataset.
 */
public class AbLevelSeriesDataset implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The m series. */
	private AbLevelSeries mSeries = null;

	/**
	 * Gets the m series.
	 * 
	 * @return the m series
	 */
	public AbLevelSeries getmSeries() {
		return mSeries;
	}

	/**
	 * Sets the m series.
	 * 
	 * @param mSeries
	 *            the new m series
	 */
	public void setmSeries(AbLevelSeries mSeries) {
		this.mSeries = mSeries;
	}

}
