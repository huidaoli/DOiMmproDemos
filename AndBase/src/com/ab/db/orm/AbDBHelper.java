package com.ab.db.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AbDBHelper extends SQLiteOpenHelper {

	/** The model classes. */
	private Class<?>[] modelClasses;

	/**
	 * 初始化一个AbSDDBHelper.
	 * 
	 * @param context
	 *            应用context
	 * @param name
	 *            数据库名
	 * @param factory
	 *            数据库查询的游标工厂
	 * @param version
	 *            数据库的新版本号
	 * @param modelClasses
	 *            要初始化的表的对象
	 */
	public AbDBHelper(Context context, String name, CursorFactory factory,
			int version, Class<?>[] modelClasses) {
		super(context, name, factory, version);
		this.modelClasses = modelClasses;
	}

	/**
	 * 描述：表的创建.
	 * 
	 * @param db
	 *            数据库对象
	 * @see com.ab.db.orm.AbSDSQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	public void onCreate(SQLiteDatabase db) {
		AbTableHelper.createTablesByClasses(db, this.modelClasses);
	}

	/**
	 * 描述：表的重建.
	 * 
	 * @param db
	 *            数据库对象
	 * @param oldVersion
	 *            旧版本号
	 * @param newVersion
	 *            新版本号
	 * @see com.ab.db.orm.AbSDSQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase,
	 *      int, int)
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		AbTableHelper.dropTablesByClasses(db, this.modelClasses);
		onCreate(db);
	}
}
