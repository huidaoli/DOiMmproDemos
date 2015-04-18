package com.ab.http;

import java.io.File;

import android.content.Context;

import com.ab.util.AbFileUtil;

public abstract class AbFileHttpResponseListener extends AbHttpResponseListener{
	
    /** 当前缓存文件. */
    private File mFile;
    
    /**
     * 下载文件的构造,用默认的缓存方式.
     *
     * @param url the url
     */
	public AbFileHttpResponseListener(String url) {
		super();
	}
	
	/**
	 * 默认的构造.
	 */
	public AbFileHttpResponseListener() {
		super();
	}
	
	/**
     * 下载文件的构造,指定缓存文件名称.
     * @param file 缓存文件名称
     */
    public AbFileHttpResponseListener(File file) {
        super();
	    this.mFile = file;
    }
	
	/**
	 * 描述：下载文件成功会调用这里.
	 *
	 * @param statusCode the status code
	 * @param file the file
	 */
    public void onSuccess(int statusCode,File file){};
    
    /**
     * 描述：多文件上传成功调用.
     *
     * @param statusCode the status code
     */
    public void onSuccess(int statusCode){};
    
   
   /**
    * 成功消息.
    *
    * @param statusCode the status code
    */
    public void sendSuccessMessage(int statusCode){
    	sendMessage(obtainMessage(AbHttpClient.SUCCESS_MESSAGE, new Object[]{statusCode}));
    }
    
    /**
     * 失败消息.
     *
     * @param statusCode the status code
     * @param error the error
     */
    public void sendFailureMessage(int statusCode,Throwable error){
    	sendMessage(obtainMessage(AbHttpClient.FAILURE_MESSAGE, new Object[]{statusCode, error}));
    }
    

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public File getFile() {
		return mFile;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the new file
	 */
	public void setFile(File file) {
		this.mFile = file;
		try {
			if(!file.getParentFile().exists()){
			      file.getParentFile().mkdirs();
			}
			if(!file.exists()){
			      file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Sets the file.
	 *
	 * @param context the context
	 * @param name the name
	 */
	public void setFile(Context context,String name) {
		//生成缓存文件
        if(AbFileUtil.isCanUseSD()){
	    	File file = new File(AbFileUtil.getFileDownloadDir(context) + name);
	    	setFile(file);
        }
	}
    
}
