package com.amirranjbar.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lstView = (ListView)findViewById(R.id.lstView);

        ArrayList<String> myFamilly = new ArrayList<String>();
        myFamilly.add("Ali");
        myFamilly.add("Amir");
        myFamilly.add("Reza");
        myFamilly.add("Mamad");
        myFamilly.add("Nick");
        myFamilly.add("Gholi");

        ArrayAdapter<String> famillyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamilly);
        lstView.setAdapter(famillyAdapter);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, myFamilly.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}