package com.example.mysmartcloset.dao;

import java.io.File;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class DAO extends SQLiteOpenHelper {
	protected static final String DIR = Environment.getExternalStorageDirectory().toString().concat("/Android/data/mysmartcloset/database/msc.sqlite");
	protected static final SQLiteDatabase db = SQLiteDatabase.openDatabase(DIR, null, SQLiteDatabase.CREATE_IF_NECESSARY);
	
	public DAO(Context context) {
	    super(new ContextWrapper(context) {
	        public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
	            // allow database directory to be specified
	            File dir = new File(DIR);
	            if(!dir.exists()) {
	                dir.mkdirs();
	            }
	            return SQLiteDatabase.openDatabase(DIR, null, SQLiteDatabase.CREATE_IF_NECESSARY);
	        }
	    }, "msc.sqlite", null, 1);
	  }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
