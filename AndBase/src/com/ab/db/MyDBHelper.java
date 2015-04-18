package com.ab.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

	/** 数据库名. */
	private static final String DBNAME = "andbase.db";

	/** 数据库版本. */
	private static final int VERSION = 1;

	/**
	 * 构造器.
	 * 
	 * @param context
	 *            the context
	 */
	public MyDBHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	/**
	 * 描述：表的创建.
	 * 
	 * @param db
	 *            the db
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS FILEDOWN (_ID INTEGER PRIMARY KEY AUTOINCREMENT,ICON TEXT,NAME TEXT,DESCRIPTION TEXT, PAKAGENAME TEXT ,DOWNURL TEXT,DOWNPATH TEXT,STATE INTEGER,DOWNLENGTH INTEGER,TOTALLENGTH INTEGER,DOWNSUFFIX TEXT)");
	}

	/**
	 * 描述：表的重建.
	 * 
	 * @param db
	 *            the db
	 * @param oldVersion
	 *            the old version
	 * @param newVersion
	 *            the new version
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase,
	 *      int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS FILEDOWN");
		onCreate(db);
	}

}
