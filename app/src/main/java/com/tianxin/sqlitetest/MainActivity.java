package com.tianxin.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tianxin.sqlitetest.banbensql.DBHelper;
import com.tianxin.sqlitetest.banbensql.DBHelper2;

import java.util.ArrayList;
import java.util.List;
 //测试2
public class MainActivity extends AppCompatActivity {

    private static String CREATE_TABLE ="create table number(_id integer primary key autoincrement ,phone real)";

    int ab  = 0,cd;
    ContentValues mContentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.baocunid);
        Button button2=findViewById(R.id.duquid);
        Button button3=findViewById(R.id.shanchuid);
        Button button4=findViewById(R.id.xiugaiid);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ab++;
                boolean nn = baocun(MainActivity.this, new String[] { "114499title","rullll---htt;s=="+ab,"加入的xxx" });
                Log.i("lgq","sbbbb---"+nn);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBai(MainActivity.this);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String ss= Delete(MainActivity.this,"1");
                Log.i("lgq","shanchu=g==="+ss);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = updata(MainActivity.this,"");
                Log.i("lgq","xiugg=g==="+ss);
            }
        });
    }

    public static boolean baocun(Context context, String[] values) {
        SQLiteDatabase db2=null;
        DBHelper2 dbHelper = null;
        try {
            dbHelper =new DBHelper2(context);
            db2 = dbHelper.getWritableDatabase();
            db2=dbHelper.getWritableDatabase();
            db2.beginTransaction();
            db2.execSQL("insert into favorite (title,url,deleted) values (?,?,?)",values);
            db2.setTransactionSuccessful();
            db2.endTransaction();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{

        }

    }

    public  List<String> getBai(Context context){
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db2=null;
        DBHelper2 dbHelper = null;
        try {

            dbHelper= new DBHelper2(context);
            db2=dbHelper.getWritableDatabase();
            Cursor cursor =db2.rawQuery("select _id,title,deleted from favorite", null);
            while(cursor.moveToNext()){
                cd++;
//                int dbid = cursor.getInt(cursor.getColumnIndex("_id"));
                int id=cursor.getInt(cursor.getColumnIndex("_id"));
                String haoma = cursor.getString(cursor.getColumnIndex("title"))+"";
                String names = cursor.getString(cursor.getColumnIndex("deleted"));
                list.add(haoma);
                System.out.println("lgqs======"+haoma+"......."+names+"     "+cd+"    id===  "+id);
            }
            db2.setTransactionSuccessful();
            db2.endTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public static String Delete(Context context,String string){
        SQLiteDatabase db2=null;
        DBHelper2 dbHelper = null;
        try {
            dbHelper =new DBHelper2(context);
            db2 = dbHelper.getWritableDatabase();
            db2=dbHelper.getWritableDatabase();
            db2.beginTransaction();
            db2.execSQL("delete from favorite where _id=?",new String[] { string });
            db2.setTransactionSuccessful();
            db2.endTransaction();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
    public static String updata(Context context,String string){
        SQLiteDatabase db2=null;
        DBHelper2 dbHelper = null;
        try {
            dbHelper =new DBHelper2(context);
            db2 = dbHelper.getWritableDatabase();
            db2=dbHelper.getWritableDatabase();
            db2.beginTransaction();
            db2.execSQL("update favorite set title ="+"2222999"+" where url =?",new String[]{"rullll---htt;s==3"});
            db2.setTransactionSuccessful();
            db2.endTransaction();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
}
