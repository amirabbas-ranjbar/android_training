package com.amirranjbar.braintrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGo;

    public void btnGo_onClick(View view) {
        btnGo.setVisibility(View.INVISIBLE);

    }
    public void chooseAnswer(View view) {
        btnGo.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = (Button) findViewById(R.id.btnGo);
    }
}