package com.example.hugod.skone;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String youScore = "";
    private String phoneScore = "";
    private final String TAG = "Activity";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();

        final TextView trick = (TextView) findViewById(R.id.trick);
        //Sets scores to ""
        final TextView youLetters = (TextView) findViewById(R.id.youSkate);
        youLetters.setText(youScore);

        final TextView phoneLetters = (TextView) findViewById(R.id.phoneSkate);
        phoneLetters.setText(phoneScore);

        if(getString(R.string.trick).equals("Trick")){
            trick.setText(getRandomTrick());
        }

        ImageButton xBtn = findViewById(R.id.xButton);
        xBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //X Button functionality
                youScore = addLetter(youScore);
                youLetters.setText(youScore);
                trick.setText(getRandomTrick());


            }
        });

        ImageButton checkBtn = findViewById(R.id.checkButton);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check Button functionality TODO: Fix score system SKATE, Win and lose screen
                phoneScore = addLetter(phoneScore);
                phoneLetters.setText(phoneScore);
                trick.setText(getRandomTrick());


            }
        });

    }

    public String getRandomTrick(){
        String currentTrick;
        String[] tricks = getResources().getStringArray(R.array.basic_tricks);

        currentTrick = tricks[(int)(Math.random()*tricks.length)];

        return currentTrick;
    }

    public String addLetter(String currentScore){
        String theScore = "";


        switch (currentScore){
            case "":
                theScore = "S";
                break;

            case "S":
                theScore = "S.K";
                break;

            case "S.K":
                theScore = "S.K.A";
                break;

            case "S.K.A":
                theScore = "S.K.A.T";
                break;

            case "S.K.A.T":
                theScore = "S.K.A.T.E";
                break;
        }

        return theScore;
    }

}
