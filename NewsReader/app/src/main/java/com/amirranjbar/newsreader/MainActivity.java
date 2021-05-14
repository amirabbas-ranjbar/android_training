package com.amirranjbar.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    SQLiteDatabase smartDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartDB = this.openOrCreateDatabase("PardikCloud", MODE_PRIVATE, null);
        smartDB.execSQL("CREATE TABLE IF NOT EXISTS smart_types (id INTEGER PRIMARY KEY ,title VARCHAR  ) ");
        DownloadTask task = new DownloadTask();
        try {
            String serviceData = String.valueOf(task.execute("https://srv.pardik.co/MirrorService/SmartHomeTypes").get());
            JSONArray jsonArray = new JSONArray(serviceData);
            int numberItems = 20;
            if (jsonArray.length() < 20) {
                numberItems = jsonArray.length();
            }
            smartDB.execSQL("DELETE FROM smart_types");
            for (int i = 0; i < numberItems; i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                Log.i("TestDebug", String.valueOf(jsonObject));
                String sql = "INSERT INTO  smart_types (id,title) VALUES (?,?)";
                SQLiteStatement statement = smartDB.compileStatement(sql);
                statement.bindString(1, jsonObject.getString("typeId"));
                statement.bindString(2, jsonObject.getString("typeTitle"));
                statement.execute();
            }
        } catch (Exception ex) {
            Log.i("DebugException", ex.getMessage());
        }

        ListView listview = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, titles);
        listview.setAdapter(arrayAdapter);
        updateListView();
    }

    public void updateListView() {
        Cursor cursor = smartDB.rawQuery("SELECT * FROM smart_types", null);
        if (cursor.moveToFirst()) {
            titles.clear();
            ids.clear();
            while (cursor.moveToNext()){
                Log.i("TestDebug", String.valueOf(cursor.getString(cursor.getColumnIndex("title"))));
            ids.add(cursor.getString(cursor.getColumnIndex("id")));
            titles.add(cursor.getString(cursor.getColumnIndex("title")));
        }
        arrayAdapter.notifyDataSetChanged();
    }

}
}