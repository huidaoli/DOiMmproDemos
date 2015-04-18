package com.can2do.doimmpro.friend;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.can2do.doimmpro.db.DBSDHelper;
import com.can2do.doimmpro.model.User;

/**
 * 
 * © 2012 amsoft.cn 名称：UserDao.java 描述：用户信息
 * 
 * @version v1.0
 */
public class UserDao extends AbDBDaoImpl<User> {
	public UserDao(Context context) {
		super(new DBSDHelper(context), User.class);
	}
}
