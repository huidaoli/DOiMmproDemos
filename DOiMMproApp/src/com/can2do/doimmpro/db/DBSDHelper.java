package com.can2do.doimmpro.db;

import android.content.Context;

import com.ab.db.orm.AbSDDBHelper;
import com.ab.util.AbFileUtil;
import com.can2do.doimmpro.demo.model.LocalUser;
import com.can2do.doimmpro.demo.model.Stock;
import com.can2do.doimmpro.friend.Friend;
import com.can2do.doimmpro.im.model.IMMessage;
import com.can2do.doimmpro.model.User;

public class DBSDHelper extends AbSDDBHelper {
	// 数据库名
	private static final String DBNAME = "andbasedemo.db";

	// 当前数据库的版本
	private static final int DBVERSION = 1;
	// 要初始化的表
	private static final Class<?>[] clazz = { User.class, LocalUser.class,
			Stock.class, Friend.class, IMMessage.class };

	public DBSDHelper(Context context) {
		super(context, AbFileUtil.getDbDownloadDir(context), DBNAME, null,
				DBVERSION, clazz);
	}

}
