package com.ab.task;



// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn
 * 名称：AbTaskObjectListener.java 
 * 描述：数据执行的接口.
 *
 */
public abstract class AbTaskObjectListener extends AbTaskListener{
	
	/**
	 * Gets the object.
	 *
	 * @param <T> the generic type
	 * @return 返回的结果对象
	 */
    public abstract <T> T getObject();
    
    /**
     * 描述：执行开始后调用.
     *
     * @param <T> the generic type
     * @param obj the obj
     */
    public abstract <T> void update(T obj); 
    
	
}
