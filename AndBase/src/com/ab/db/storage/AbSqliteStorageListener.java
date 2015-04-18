package com.ab.db.storage;

import java.util.List;

public class AbSqliteStorageListener {

	/**
	 * 描述：插入数据的监听.
	 */
	public static abstract interface AbDataInsertListener {

		/**
		 * On success.
		 * 
		 * @param rowId
		 *            the rowId
		 */
		public abstract void onSuccess(long rowId);

		/**
		 * On failure.
		 * 
		 * @param errorCode
		 *            the error code
		 * @param errorMessage
		 *            the error message
		 */
		public abstract void onFailure(int errorCode, String errorMessage);
	}

	/**
	 * 描述：插入数据的监听.
	 */
	public static abstract interface AbDataInsertListListener {

		/**
		 * On success.
		 * 
		 * @param rowIds
		 *            rowIds
		 */
		public abstract void onSuccess(long[] rowIds);

		/**
		 * On failure.
		 * 
		 * @param errorCode
		 *            the error code
		 * @param errorMessage
		 *            the error message
		 */
		public abstract void onFailure(int errorCode, String errorMessage);
	}

	/**
	 * 描述：查询数据的监听.
	 * 
	 */
	public static abstract interface AbDataSelectListener {

		/**
		 * On success.
		 * 
		 * @param paramList
		 *            the param list
		 */
		public abstract void onSuccess(List<?> paramList);

		/**
		 * On failure.
		 * 
		 * @param errorCode
		 *            the error code
		 * @param errorMessage
		 *            the error message
		 */
		public abstract void onFailure(int errorCode, String errorMessage);
	}

	/**
	 * 描述：修改数据的监听.
	 */
	public static abstract interface AbDataUpdateListener {

		/**
		 * On success.
		 * 
		 * @param rows
		 *            the rows
		 */
		public abstract void onSuccess(int rows);

		/**
		 * On failure.
		 * 
		 * @param errorCode
		 *            the error code
		 * @param errorMessage
		 *            the error message
		 */
		public abstract void onFailure(int errorCode, String errorMessage);
	}

	/**
	 * 描述：删除数据的监听.
	 */
	public static abstract interface AbDataDeleteListener {

		/**
		 * On success.
		 * 
		 * @param rows
		 *            rows
		 */
		public abstract void onSuccess(int rows);

		/**
		 * On failure.
		 * 
		 * @param errorCode
		 *            the error code
		 * @param errorMessage
		 *            the error message
		 */
		public abstract void onFailure(int errorCode, String errorMessage);
	}
}
