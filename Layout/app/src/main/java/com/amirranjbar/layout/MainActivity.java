package com.amirranjbar.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean bartIsShwoing=true;
    public void imgView_OnClick(View view) {
        Log.i("info","image tap");
        ImageView bartImgView = (ImageView) findViewById((R.id.bartImgView));
        ImageView homerImgView = (ImageView) findViewById((R.id.homerImgView));
        if (bartIsShwoing) {
            bartImgView.animate().alpha(0).setDuration(2000);
            homerImgView.animate().alpha(1).setDuration(2000);
            bartIsShwoing=false;
        }else{
            bartImgView.animate().alpha(1).setDuration(2000);
            homerImgView.animate().alpha(0).setDuration(2000);
            bartIsShwoing=true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}