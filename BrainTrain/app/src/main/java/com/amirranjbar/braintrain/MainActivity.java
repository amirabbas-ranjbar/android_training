package com.amirranjbar.braintrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int answerLocation;
    TextView txtAnswer;
    TextView txtResult;
    TextView txtsum;
    TextView txtTimer;
    int score = 0;
    int numberOfQuestion = 0;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnReset;

    public void btnGo_onClick(View view) {
        btnGo.setVisibility(View.INVISIBLE);

    }

    public void btnReset_click(View View) {
        score = 0;
        numberOfQuestion = 0;
        txtTimer.setText("30s");
        txtResult.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        newQuestion();
        btnReset.setVisibility(View.INVISIBLE);
        new CountDownTimer(50100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                txtAnswer.setText("Times Up !");
                btnReset.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void chooseAnswer(View view) {
        Log.i("answer", Integer.toString(answerLocation));
        Log.i("tag", view.getTag().toString());

        if (Integer.toString(answerLocation).equals(view.getTag().toString())) {
            txtAnswer.setText("Correct :) ");
            score++;
        } else {
            txtAnswer.setText("Wrong :( ");
        }
        numberOfQuestion++;
        txtResult.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        newQuestion();
    }

    public void newQuestion() {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        answers.clear();
        txtsum.setText(Integer.toString(a) + " + " + Integer.toString(b));
        answerLocation = rand.nextInt(4);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = (Button) findViewById(R.id.btnGo);
        btn0 = (Button) findViewById(R.id.btnAnswer0);
        btn1 = (Button) findViewById(R.id.btnAnswer1);
        btn2 = (Button) findViewById(R.id.btnAnswer2);
        btn3 = (Button) findViewById(R.id.btnAnswer3);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtsum = (TextView) findViewById(R.id.txtSum);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
        btnReset_click(findViewById(R.id.btnReset));
    }


}