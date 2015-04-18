package com.ab.task;

import java.util.List;

import android.os.AsyncTask;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 名称：AbAsyncTask.java 描述：下载数据的任务实现，单次下载
 * 
 */
public class AbTask extends AsyncTask<AbTaskItem, Integer, AbTaskItem> {

	/** The listener. */
	private AbTaskListener listener;

	/** The result. */
	private Object result;

	/**
	 * Instantiates a new ab task.
	 */
	public AbTask() {
		super();
	}

	/**
	 * Instantiates a new ab task.
	 */
	public static AbTask newInstance() {
		AbTask mAbTask = new AbTask();
		return mAbTask;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected AbTaskItem doInBackground(AbTaskItem... items) {
		AbTaskItem item = items[0];
		this.listener = item.getListener();
		if (this.listener != null) {
			if (this.listener instanceof AbTaskListListener) {
				result = ((AbTaskListListener) this.listener).getList();
			} else if (this.listener instanceof AbTaskObjectListener) {
				result = ((AbTaskObjectListener) this.listener).getObject();
			} else {
				this.listener.get();
			}
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#onCancelled()
	 */
	@Override
	protected void onCancelled() {
		super.onCancelled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(AbTaskItem item) {
		if (this.listener != null) {
			if (this.listener instanceof AbTaskListListener) {
				((AbTaskListListener) this.listener).update((List<?>) result);
			} else if (this.listener instanceof AbTaskObjectListener) {
				((AbTaskObjectListener) this.listener).update(result);
			} else {
				this.listener.update();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#onProgressUpdate(Progress[])
	 */
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		if (this.listener != null) {
			this.listener.onProgressUpdate(values);
		}
	}

}
