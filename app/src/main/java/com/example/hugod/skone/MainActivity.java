package com.example.hugod.skone;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

        final AlertDialog winDialog = createWinDialog();
        final AlertDialog loseDialog = createLoseDialog();

        if (getString(R.string.trick).equals("Trick")) {
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
                checkWinCondition(winDialog, youScore);

            }
        });

        ImageButton checkBtn = findViewById(R.id.checkButton);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check Button functionality
                phoneScore = addLetter(phoneScore);
                phoneLetters.setText(phoneScore);
                trick.setText(getRandomTrick());
                checkWinCondition(loseDialog, phoneScore);

            }
        });

    }

    private void checkWinCondition(AlertDialog dialog, String score) {
        if (score.equals("S.K.A.T.E")) {
            dialog.show();
        }

    }

    public String getRandomTrick() {
        String currentTrick;
        String[] tricks = getResources().getStringArray(R.array.basic_tricks);

        currentTrick = tricks[(int) (Math.random() * tricks.length)];

        return currentTrick;
    }

    public String addLetter(String currentScore) {
        String theScore = "";


        switch (currentScore) {
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
                //TODO: output who wins and loses!
                break;
        }

        return theScore;
    }

    public AlertDialog createLoseDialog(){
        AlertDialog dialog;

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this, 2);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title_win);
        builder.setCancelable(false);


        builder.setPositiveButton(R.string.dialog_play_again_btn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                recreate();
            }
        });
        builder.setNegativeButton(R.string.quit_btn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        return  dialog = builder.create();
    }

    public AlertDialog createWinDialog(){
        AlertDialog dialog;

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this, 2);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title_lose);
        builder.setCancelable(false);


        builder.setPositiveButton(R.string.dialog_play_again_btn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                recreate();
            }
        });
        builder.setNegativeButton(R.string.quit_btn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        return  dialog = builder.create();
    }


}
