package com.can2do.doimmpro.demo.dao;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.can2do.doimmpro.db.DBInsideHelper;
import com.can2do.doimmpro.demo.model.LocalUser;

/**
 * 
 * © 2012 amsoft.cn 名称：UserInsideDao.java 描述：本地数据库 在data下面
 * 
 * @version v1.0
 */
public class UserInsideDao extends AbDBDaoImpl<LocalUser> {
	public UserInsideDao(Context context) {
		super(new DBInsideHelper(context), LocalUser.class);
	}
}
