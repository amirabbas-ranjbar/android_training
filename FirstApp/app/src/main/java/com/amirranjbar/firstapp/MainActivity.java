package com.amirranjbar.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickMeFunction(View view) {
        EditText txtName = (EditText) findViewById(R.id.txtName);
        TextView lblName = (TextView) findViewById(R.id.lblName);
        ImageView imgdog = (ImageView) findViewById((R.id.imgDog));
        String name = txtName.getText().toString();
        switch (name) {
            case "1":
                imgdog.setImageResource(R.drawable.index);
                break;
            case "2":
                imgdog.setImageResource(R.drawable.shiba1);
                break;
            case "3":
                imgdog.setImageResource(R.drawable.shiba3);
                break;
            default:
                imgdog.setImageResource(R.drawable.shiba4);

        }

        Log.i("info", "click me button");
        lblName.setText(txtName.getText());
        Toast.makeText(this, "Hi " + txtName.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}