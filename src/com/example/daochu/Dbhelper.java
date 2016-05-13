package com.example.daochu;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Dbhelper extends SQLiteOpenHelper {	
	Cursor cursor;
	public Dbhelper(Context context) {
		super(context, "mysql.db",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String table="create table student_info(stu_id INT(15) primary KEy,stu_name varchar(5),macAddress varchar(30),class_name varchar(10))";
		db.execSQL(table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {		
	}
	   // 查询
    public Cursor Search(String sql, String str[]) {
    	Cursor cursor;
    	SQLiteDatabase db=this.getReadableDatabase();
    	db.execSQL(sql);
    	cursor=db.query("student_info", new String[]{"stu_id,stu_name,macAddress,class_name"}, null, null, null, null, null);
    	return cursor;
    }
    //查询biao
    public Cursor search() {
    	Cursor cursor;
    	SQLiteDatabase db=this.getReadableDatabase();
    	cursor=db.query("student_info", new String[]{"stu_id,stu_name,macAddress,class_name"}, null, null, null, null, null);
		return cursor;
    }
    // 增删修改
    public void AddU(ContentValues values) {
    	SQLiteDatabase db=this.getWritableDatabase();
    	db.insert("student_info", null, values); 
    }
}
