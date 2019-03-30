package io.github.zakawat.learningdb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);


        StudentDBHelper dbHelper = new StudentDBHelper(this);
/*        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("sid", 16);
        values.put("sname","Turkey");

        long row = database.insert("student", null, values);

*/


        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String projection[] = {"cid", "cname"};
        Cursor cursor = database.query("COUNTRY", projection, null, null, null,null,null);



        String output = "";
        while (cursor.moveToNext()){
            output += cursor.getString(1) + "\n";
        }

        txtDisplay.setText(output);
    }
}
