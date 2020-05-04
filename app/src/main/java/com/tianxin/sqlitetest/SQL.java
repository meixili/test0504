package com.tianxin.sqlitetest;

/**
 * 作者：created by meixi
 * 邮箱：13164716840@163.com
 * 日期：2018/10/9 11
 */
public class SQL {
    public static final String T_FAVORITE = "favorite";


    public static final String CREATE_TABLE_FAVORITE =
            "CREATE TABLE IF NOT EXISTS " + T_FAVORITE + "(" +
                    "_id integer primary key autoincrement, " +
                    "title VARCHAR, " +
                    "url VARCHAR, " +
                    "createDate VARCHAR " +
                    ")";
}