package com.amirranjbar.storagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstNotes;
    static ArrayList<String> notes = new ArrayList<String>();
    static ArrayAdapter arrayAdapter;

    public void findElements() {
        lstNotes = (ListView) findViewById(R.id.lstNotes);
    }

    public void loadLstnotes(ArrayList<String> _notes) {
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, _notes);
        lstNotes.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findElements();
        notes.add("example note");
        loadLstnotes(notes);
        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
                intent.putExtra("noteId", position);
                startActivity(intent);
            }
        });


    }
}