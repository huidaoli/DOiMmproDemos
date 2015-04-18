package com.ab.view.wheel;

import java.util.List;

import com.ab.util.AbStrUtil;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbStringWheelAdapter.java 描述：轮子适配器（字符串）
 * 
 */

public class AbStringWheelAdapter implements AbWheelAdapter {

	/** The default items length. */
	public static final int DEFAULT_LENGTH = -1;
	// items
	/** The items. */
	private List<String> items;
	// length
	/** The length. */
	private int length = -1;

	/**
	 * Constructor.
	 * 
	 * @param items
	 *            the items
	 * @param length
	 *            the max items length
	 */
	public AbStringWheelAdapter(List<String> items, int length) {
		this.items = items;
		this.length = length;
	}

	/**
	 * Constructor.
	 * 
	 * @param items
	 *            the items
	 */
	public AbStringWheelAdapter(List<String> items) {
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
	 * @date：2013-6-17 上午9:04:49
	 */
	@Override
	public String getItem(int index) {
		if (index >= 0 && index < items.size()) {
			return items.get(index);
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
	 * @date：2013-6-17 上午9:04:49
	 */
	@Override
	public int getItemsCount() {
		return items.size();
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @return the maximum length
	 * @see com.ab.view.wheel.AbWheelAdapter#getMaximumLength()
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:49
	 */
	@Override
	public int getMaximumLength() {
		if (length != -1) {
			return length;
		}
		int maxLength = 0;
		for (int i = 0; i < items.size(); i++) {
			String cur = items.get(i);
			int l = AbStrUtil.strLength(cur);
			if (maxLength < l) {
				maxLength = l;
			}
		}
		return maxLength;
	}

}
