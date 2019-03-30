package io.github.zakawat.learningdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDBHelper extends SQLiteOpenHelper {

        private String arr[] = {"Pakistan", "China", "Iran", "Afghanistan", "Bangladesh", "Yemen", "Uzbekistan", "Russia", "USA", "KSA", "Canada", "Austria", "Netherlands", "Australia"};


    public StudentDBHelper(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  COUNTRY (cid int, cname navarchar(100))");

        try{

            db.beginTransaction();

            for (int i = 0;  i<arr.length; i++) {
                ContentValues values = new ContentValues();
                values.put("cid", (i+1)); //i+1 because it starts from 0
                values.put("cname", arr[i]);
                db.insert("COUNTRY", null, values);
            }

            db.setTransactionSuccessful();
        }
        catch (Exception ex){
            Log.e("ZAKITAG", "Exception: "+ex.getMessage());
        }
        finally {
            db.endTransaction();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS COUNTRY;");
        onCreate(db);
    }
}
