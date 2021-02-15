package com.amirranjbar.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lstView;

    public void generateTimesTable ( int timesTableNumber){
        ArrayList<String> tableContent = new ArrayList<String>();
        for (int j = 1; j <= 10; j++) {
            tableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> tableAddapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContent);
        lstView.setAdapter(tableAddapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         lstView = (ListView) findViewById(R.id.lstView);
        SeekBar timesSeekBar = (SeekBar) findViewById(R.id.timesSeekBar);

        timesSeekBar.setMax(20);
        timesSeekBar.setProgress(10);



        timesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min) {
                    timesTableNumber = min;
                    timesSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}