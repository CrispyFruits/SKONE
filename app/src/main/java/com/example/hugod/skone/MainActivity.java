package com.example.hugod.skone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton xBtn = findViewById(R.id.xButton);
        xBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //X Button functionality
                return false;
            }
        });

        ImageButton checkBtn = findViewById(R.id.checkButton);
        checkBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Check Button functionality
                return false;
            }
        });

    }

    public String addLetter(String currentScore){
        currentScore = currentScore;


        switch (currentScore){
            case "":
                currentScore = "S";
                break;

            case "S":
                currentScore = "S.K";
                break;

            case "S.K":
                currentScore = "S.K.A";
                break;

            case "S.K.A":
                currentScore = "S.K.A.T";
                break;

            case "S.K.A.T":
                currentScore = "S.K.A.T.E";
                break;
        }
        return currentScore;
    }

}
