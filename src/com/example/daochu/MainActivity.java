package com.example.daochu;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
public class MainActivity extends Activity {
	Dbhelper dbhelper;
	Button daobuton;
	Button outButton;
	TestExcelToDb tExcelToDb=new TestExcelToDb(MainActivity.this);
	TestDbToExcel ttexcel=new TestDbToExcel();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbhelper=new Dbhelper(this);
		daobuton=(Button) findViewById(R.id.dao);
		outButton=(Button) findViewById(R.id.out);
		daobuton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tExcelToDb.pao();
			}
		});
		outButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ttexcel.out();
				
			}
		});
	}
}
