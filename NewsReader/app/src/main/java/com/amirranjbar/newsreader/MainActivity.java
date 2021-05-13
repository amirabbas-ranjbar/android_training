package com.amirranjbar.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    SQLiteDatabase smartDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //smartDB = this.openOrCreateDatabase("PardikCloud", MODE_PRIVATE, null);
        //smartDB.execSQL("CREATE TABLE IF NOT EXISTS smart_types (id INTEGER PRIMARY KEY ,title VARCHAR  ) ");


        DownloadTask task = new DownloadTask();
        try {
            String serviceData = String.valueOf(task.execute("https://srv.pardik.co/MirrorService/SmartHomeTypes").get());
            Log.i("TestDebug", String.valueOf(serviceData));
        } catch (Exception ex) {
            Log.i("DebugException", ex.getMessage());
        }

        ListView listview = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, titles);
        listview.setAdapter(arrayAdapter);
    }
}