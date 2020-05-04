package com.tianxin.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者：created by meixi
 * 邮箱：13164716840@163.com
 * 日期：2018/10/9 10
 */
public class CreateDB extends SQLiteOpenHelper {
    private String sql;
    public CreateDB(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, String sql) {
        super(context, name, factory, version);
        this.sql= sql;
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        arg0.execSQL(sql);
        System.out.println("lg===111111======CreateDB.onCreate()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        System.out.println("lgp0-000---222-----------CreateDB.onUpgrade()");
        if (arg2==2) {
            System.out.println("lg版本==2222222");
        }
        if (arg1!=arg2) {
            System.out.println("lg版本不相等");
        }
    }

}
