package com.example.daochu;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import jxl.Sheet;
import jxl.Workbook;
//Java实现Excel导入数据核心类 读取Excel表中所有的数据、操作数据（查询、更新）
/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class StuService {
	static Dbhelper db;
	public StuService(){}
	public StuService(Context context){
		db=new Dbhelper(context);
	}
	
	  /**
     * 查询stu表中所有的数据
     * @return 
     */
    public static List<StuEntity> getAllByDb(){
        List<StuEntity> list=new ArrayList<StuEntity>();
            String sql="select * from student_info";
            Cursor rs= db.search();
            while (rs.moveToNext()) {
                String stu_id=rs.getString(0);
                String stu_name=rs.getString(1);
                String macAddress=rs.getString(2);
                String class_name=rs.getString(3);
                list.add(new StuEntity(stu_id, stu_name, macAddress, class_name));
            }
            
         
        return list;
    }
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<StuEntity> getAllByExcel(String file){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
        	//查询所有的咧
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                   String stu_id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String stu_name=rs.getCell(j++, i).getContents();
                    String macAddress=rs.getCell(j++, i).getContents();
                    String class_name=rs.getCell(j++, i).getContents();
                    System.out.println("stu_id:"+stu_id+" stu_name:"+stu_name+" macAddress:"+macAddress+" class_name:"+class_name);
                    list.add(new StuEntity(stu_id, stu_name, macAddress, class_name));
                }
            }
        } catch (Exception e) {
        	Log.i("ww", e+"");
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */
    public  boolean isExist(String stu_id){
        Cursor rs=(Cursor) db.Search("select * from student_info where stu_id=?", new String[]{stu_id});
		if (rs.moveToNext()) {
		    return true;
		}
        return false;
    }
}
