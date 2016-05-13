package com.example.daochu;
import java.io.File;
import java.util.List;

import android.content.Context;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
//数据的数据导入到Excel表
public class TestDbToExcel{
	StuService service;
	 Dbhelper dbhelper;
	 public TestDbToExcel(){
		 
	 }
	 public TestDbToExcel(Context context){
		 dbhelper=new Dbhelper(context);
		 service=new StuService(context);
	 }
    public void out() {
    	 try {
             WritableWorkbook wwb = null;            
                // 创建可写入的Excel工作簿
                String fileName = "/mnt/sdcard/books.xls";
                File file=new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                //以fileName为文件名来创建一个Workbook
                wwb = Workbook.createWorkbook(file);
                // 创建工作表
                WritableSheet ws = wwb.createSheet("Test Shee 1", 0);             
                //查询数据库中所有的数据
                List<StuEntity> list= StuService.getAllByDb();
                //要插入到的Excel表格的行号，默认从0开始
                Label labelId= new Label(0, 0, "Stu_id");//表示第
                Label labelName= new Label(1, 0, "Stu_name");
                Label labelSex= new Label(2, 0, "macAddress");
                Label labelNum= new Label(3, 0, "Class_name");
                ws.addCell(labelId);
                ws.addCell(labelName);
                ws.addCell(labelSex);
                ws.addCell(labelNum);
                for (int i = 0; i < list.size(); i++) {
                    Label labelId_i= new Label(0, i+1, list.get(i).getStu_id()+"");
                    Label labelName_i= new Label(1, i+1, list.get(i).getStu_name());
                    Label labelSex_i= new Label(2, i+1, list.get(i).getMacAddress());
                    Label labelNum_i= new Label(3, i+1, list.get(i).getClass_name());
                    ws.addCell(labelId_i);
                    ws.addCell(labelName_i);
                    ws.addCell(labelSex_i);
                    ws.addCell(labelNum_i);
                }             
               //写进文档
                wwb.write();
               // 关闭Excel工作簿对象
                wwb.close();
         } catch (Exception e) {
             e.printStackTrace();
         } 
    }
}
