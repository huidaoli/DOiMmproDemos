package com.can2do.doimmpro.db;

import android.content.Context;

import com.ab.db.orm.AbDBHelper;
import com.can2do.doimmpro.demo.model.LocalUser;
import com.can2do.doimmpro.demo.model.Stock;
import com.can2do.doimmpro.friend.Friend;
import com.can2do.doimmpro.im.model.IMMessage;
import com.can2do.doimmpro.model.User;
/**
 * 
 * © 2012 amsoft.cn
 * 名称：DBInsideHelper.java 
 * 描述：手机data/data下面的数据库
 * @author 还如一梦中
 * @date：2013-7-31 下午3:50:18
 * @version v1.0
 */
public class DBInsideHelper extends AbDBHelper {
	// 数据库名
	private static final String DBNAME = "andbasedemo.db";
    
    // 当前数据库的版本
	private static final int DBVERSION = 1;
	// 要初始化的表
	private static final Class<?>[] clazz = { User.class,LocalUser.class,Stock.class,Friend.class,IMMessage.class};

	public DBInsideHelper(Context context) {
		super(context, DBNAME, null, DBVERSION, clazz);
	}

}



