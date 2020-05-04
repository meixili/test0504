package com.tianxin.sqlitetest.banbensql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tianxin.sqlitetest.SQL;

/**
 * 作者：created by meixi
 * 邮箱：13164716840@163.com
 * 日期：2018/10/9 14
 */
public class DBHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mall.db";
    private static final int DATABASE_VERSION = 1001;

    private static DBHelper2 instance = null;


    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public synchronized static DBHelper2 getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper2(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL.CREATE_TABLE_FAVORITE);

        // 若不是第一个版本安装，直接执行数据库升级
        // 请不要修改FIRST_DATABASE_VERSION的值，其为第一个数据库版本大小
        final int FIRST_DATABASE_VERSION = 1000;
        onUpgrade(db, FIRST_DATABASE_VERSION, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 使用for实现跨版本升级数据库
        for (int i = oldVersion; i < newVersion; i++) {
            switch (i) {
                case 1000:
                    upgradeToVersion1001(db);
                    break;
                default:
                    break;
            }
        }
    }

    private void upgradeToVersion1001(SQLiteDatabase db){
        // favorite表新增1个字段
        String sql1 = "ALTER TABLE "+SQL.T_FAVORITE+" ADD COLUMN deleted VARCHAR";
        db.execSQL(sql1);
    }
}
