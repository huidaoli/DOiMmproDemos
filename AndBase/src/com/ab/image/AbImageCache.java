package com.ab.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import com.ab.image.toolbox.ImageLoader.ImageCache;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class AbImageCache implements ImageCache {

	/** The m cache. */
	private static LruCache<String, Bitmap> mCache;

	/** The m image cache. */
	private static AbImageCache mImageCache;

	/**
	 * Instantiates a new ab image cache.
	 */
	public AbImageCache() {
		super();
		int maxSize = 10 * 1024 * 1024;
		mCache = new LruCache<String, Bitmap>(maxSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	/**
	 * Gets the single instance of AbImageCache.
	 * 
	 * @return single instance of AbImageCache
	 */
	public static AbImageCache getInstance() {
		if (mImageCache == null) {
			mImageCache = new AbImageCache();
		}
		return mImageCache;
	}

	@Override
	public Bitmap getBitmap(String cacheKey) {
		return mCache.get(cacheKey);
	}

	@Override
	public void putBitmap(String cacheKey, Bitmap bitmap) {
		mCache.put(cacheKey, bitmap);
	}

	@Override
	public void removeBitmap(String requestUrl, int maxWidth, int maxHeight) {
		mCache.remove(getCacheKey(requestUrl, maxWidth, maxHeight));
	}

	/**
	 * Creates a cache key for use with the L1 cache.
	 * 
	 * @param url
	 *            The URL of the request.
	 * @param maxWidth
	 *            The max-width of the output.
	 * @param maxHeight
	 *            The max-height of the output.
	 */
	public String getCacheKey(String url, int maxWidth, int maxHeight) {
		return new StringBuilder(url.length() + 12).append("#W")
				.append(maxWidth).append("#H").append(maxHeight).append(url)
				.toString();
	}

	/**
	 * Clear bitmap.
	 */
	public void clearBitmap() {
		mCache.evictAll();
	}

}
