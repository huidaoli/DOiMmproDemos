package com.google.gson.internal;

public interface ObjectConstructor<T> {

	/**
	 * Returns a new instance.
	 */
	public T construct();
}