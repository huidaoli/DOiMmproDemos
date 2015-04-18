package com.ab.view.chart;

import java.util.Map.Entry;

// TODO: Auto-generated Javadoc
/**
 * A map entry value encapsulating an XY point.
 * 
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 */
public class XYEntry<K, V> implements Entry<K, V> {

	/** The key. */
	private final K key;

	/** The value. */
	private V value;

	/**
	 * Instantiates a new xY entry.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public XYEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @return the key
	 * @see java.util.Map.Entry#getKey()
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:49
	 */
	public K getKey() {
		return key;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @return the value
	 * @see java.util.Map.Entry#getValue()
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:49
	 */
	public V getValue() {
		return value;
	}

	/**
	 * 描述：TODO.
	 * 
	 * @version v1.0
	 * @param object
	 *            the object
	 * @return the v
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 * @author: amsoft.cn
	 * @date：2013-6-17 上午9:04:49
	 */
	public V setValue(V object) {
		this.value = object;
		return this.value;
	}
}
