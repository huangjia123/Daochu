package com.example.daochu;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
/**
 * @author Javen
 * @Email zyw205@gmail.com
 */
//Excel表中的数据导入到MySql数据库
public class TestExcelToDb {
	StuService service;
	 Dbhelper dbhelper;
	 public TestExcelToDb(){
		 
	 }
	 
	 public TestExcelToDb(Context context){
		 dbhelper=new Dbhelper(context);
		 service=new StuService(context);
	 }
	 /**
	  * */
	 
	 /**
	  * 获取表格中的数据*/
    @SuppressLint("SdCardPath")
	public  void pao() {    	
        //得到表格中所有的数据
        List<StuEntity> listExcel=StuService.getAllByExcel("/mnt/sdcard/books.xls");
       Log.e("----------------",listExcel+"失败LLLLLLLLLLLLL");
        ContentValues values=new ContentValues();
        for (StuEntity stuEntity : listExcel) {
            String stu_id=stuEntity.getStu_id();
            if (!service.isExist(stu_id)){
                //不存在就添加
            	values.put("stu_id",stuEntity.getStu_id());
            	values.put("stu_name", stuEntity.getStu_name());
            	values.put("macAddress", stuEntity.getMacAddress());
            	values.put("class_name", stuEntity.getClass_name());              
            	dbhelper.AddU(values);
            }else{
            	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS");
                //存在就更新
            	values.put("stu_id",stuEntity.getStu_id());
            	values.put("stu_name", stuEntity.getStu_name());
            	values.put("macAddress", stuEntity.getMacAddress());
            	values.put("class_name", stuEntity.getClass_name());
            	dbhelper.AddU(values);
            }
        }
    }
}