package com.can2do.doimmpro.friend;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.can2do.doimmpro.db.DBSDHelper;

/**
 * 
 * © 2012 amsoft.cn 名称：FriendDao.java 描述：用户信息
 * 
 * @version v1.0
 */
public class FriendDao extends AbDBDaoImpl<Friend> {
	public FriendDao(Context context) {
		super(new DBSDHelper(context), Friend.class);
	}
}
