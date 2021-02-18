package com.amirranjbar.braintrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    ArrayList<Integer> answers = new ArrayList<Integer>();

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
        Button btn0 = (Button) findViewById(R.id.btnAnswer0);
        Button btn1 = (Button) findViewById(R.id.btnAnswer1);
        Button btn2 = (Button) findViewById(R.id.btnAnswer2);
        Button btn3 = (Button) findViewById(R.id.btnAnswer3);
        TextView txtsum = (TextView) findViewById(R.id.txtSum);

        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        txtsum.setText(Integer.toString(a) + " + " + Integer.toString(b));
        int answerLocation = rand.nextInt(4);

        for (int i = 0; i < 4; i++) {
            if (i == answerLocation)
                answers.add(a + b);
            else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a + b)
                    wrongAnswer = rand.nextInt(41);

                answers.add(wrongAnswer);

            }
        }
        btn0.setText(Integer.toString(answers.get(0)));
        btn1.setText(Integer.toString(answers.get(1)));
        btn2.setText(Integer.toString(answers.get(2)));
        btn3.setText(Integer.toString(answers.get(3)));


    }
}