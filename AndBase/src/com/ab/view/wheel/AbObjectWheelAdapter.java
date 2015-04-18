package com.ab.view.wheel;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbObjectWheelAdapter.java 描述：轮子适配器（对象）
 * 
 */
public class AbObjectWheelAdapter<T> implements AbWheelAdapter {

	/** The default items length. */
	public static final int DEFAULT_LENGTH = -1;

	// items
	/** The items. */
	private T items[];
	// length
	/** The length. */
	private int length;

	/**
	 * Constructor.
	 * 
	 * @param items
	 *            the items
	 * @param length
	 *            the max items length
	 */
	public AbObjectWheelAdapter(T items[], int length) {
		this.items = items;
		this.length = length;
	}

	/**
	 * Contructor.
	 * 
	 * @param items
	 *            the items
	 */
	public AbObjectWheelAdapter(T items[]) {
		this(items, DEFAULT_LENGTH);
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @param index
	 *            the index
	 * @return the item
	 * @see com.ab.view.wheel.AbWheelAdapter#getItem(int)
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:48
	 */
	@Override
	public String getItem(int index) {
		if (index >= 0 && index < items.length) {
			return items[index].toString();
		}
		return null;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @return the items count
	 * @see com.ab.view.wheel.AbWheelAdapter#getItemsCount()
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:48
	 */
	@Override
	public int getItemsCount() {
		return items.length;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @return the maximum length
	 * @see com.ab.view.wheel.AbWheelAdapter#getMaximumLength()
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:48
	 */
	@Override
	public int getMaximumLength() {
		return length;
	}

}
