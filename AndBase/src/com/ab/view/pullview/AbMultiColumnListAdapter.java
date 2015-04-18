package com.ab.view.pullview;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.ViewGroup;

// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn 名称：AbMultiColumnListAdapter 描述：AbViewInfo的基础类
 * 
 */
public abstract class AbMultiColumnListAdapter {

	/** The m data set observable. */
	private final DataSetObservable mDataSetObservable = new DataSetObservable();

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public abstract int getCount();

	/**
	 * Gets the item.
	 * 
	 * @param position
	 *            the position
	 * @return the item
	 */
	public abstract Object getItem(int position);

	/**
	 * Gets the item id.
	 * 
	 * @param position
	 *            the position
	 * @return the item id
	 */
	public abstract long getItemId(int position);

	/**
	 * Gets the view.
	 * 
	 * @param position
	 *            the position
	 * @param convertView
	 *            the convert view
	 * @param parent
	 *            the parent
	 * @return the view
	 */
	public abstract AbViewInfo getView(int position, AbViewInfo convertView,
			ViewGroup parent);

	/**
	 * Register data set observer.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void registerDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.registerObserver(observer);
	}

	/**
	 * Unregister data set observer.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void unregisterDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.unregisterObserver(observer);
	}

	/**
	 * Notify data set changed.
	 */
	public void notifyDataSetChanged() {
		mDataSetObservable.notifyChanged();
	};
}
