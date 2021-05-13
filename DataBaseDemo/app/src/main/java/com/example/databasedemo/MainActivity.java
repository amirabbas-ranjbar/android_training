package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // try {

            SQLiteDatabase myDb = this.openOrCreateDatabase("TestDB", MODE_PRIVATE, null);
            myDb.execSQL("CREATE TABLE IF NOT EXISTS test (id INT(3), name VARCHAR, age INT(3))");
            myDb.execSQL("INSERT INTO test (id,name,age) VALUES (1,'amir',26)");
            myDb.execSQL("INSERT INTO test (id,name,age) VALUES (2,'omid',26)");
            Cursor c = myDb.rawQuery("SELECT * FROM test", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToFirst();
            while (c != null) {
                Log.i("age", c.getString(ageIndex));
                Log.i("name", c.getString(nameIndex));
                c.moveToNext();
            }
        /*} catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}