package com.can2do.doimmpro.demo.dao;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.can2do.doimmpro.db.DBSDHelper;
import com.can2do.doimmpro.demo.model.LocalUser;

/**
 * 
 * © 2012 amsoft.cn 名称：UserDao.java 描述：本地数据库在sd中
 * 
 * @version v1.0
 */
public class UserSDDao extends AbDBDaoImpl<LocalUser> {
	public UserSDDao(Context context) {
		super(new DBSDHelper(context), LocalUser.class);
	}
}
