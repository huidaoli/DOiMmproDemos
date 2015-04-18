package com.ab.db.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AbSDDBHelper extends AbSDSQLiteOpenHelper {

	/** The model classes. */
	private Class<?>[] modelClasses;

	/**
	 * 初始化一个AbSDDBHelper.
	 * 
	 * @param context
	 *            应用context
	 * @param dir
	 *            数据库文件保存文件夹全路径
	 * @param name
	 *            数据库文件名
	 * @param factory
	 *            数据库查询的游标工厂
	 * @param version
	 *            数据库的新版本号
	 * @param modelClasses
	 *            要初始化的表的对象
	 */
	public AbSDDBHelper(Context context, String dir, String name,
			SQLiteDatabase.CursorFactory factory, int version,
			Class<?>[] modelClasses) {
		super(context, dir, name, null, version);
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
