package com.ab.task;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn
 * 名称：AbTaskListListener.java 
 * 描述：数据执行的接口.
 *
 */
public abstract class AbTaskListListener extends AbTaskListener{

	/**
	 * Gets the list.
	 *
	 * @return 返回的结果列表
	 */
	public abstract List<?> getList();

	/**
	 * 描述：执行完成后回调.
	 * 不管成功与否都会执行
	 * @param paramList 返回的List
	 */
    public abstract void update(List<?> paramList);
	
}
