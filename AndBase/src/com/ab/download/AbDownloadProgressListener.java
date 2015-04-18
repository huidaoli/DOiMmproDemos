package com.ab.download;

public interface AbDownloadProgressListener {

	/**
	 * On download size.
	 * 
	 * @param size
	 *            the size
	 */
	public void onDownloadSize(long size);
}
