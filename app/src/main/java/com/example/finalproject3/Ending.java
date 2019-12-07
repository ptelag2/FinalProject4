package com.example.finalproject3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ending  extends AppCompatActivity {

    Button playAgain;
    TextView scoring;
    TextView correctScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending_screen);

        playAgain = findViewById(R.id.playAgain);
        scoring = findViewById(R.id.wrongAnswers);
        correctScore = findViewById((R.id.correctAnswers));
        Intent intent = getIntent();
        int wrong = intent.getIntExtra("wrong", 0);
        int correct = intent.getIntExtra("correct", 0);
        String val = "" + wrong;
        scoring.setText(val);
        String vals = "" + correct;
        correctScore.setText(vals);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGame();
            }
        });



    }
    public void launchGame() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
