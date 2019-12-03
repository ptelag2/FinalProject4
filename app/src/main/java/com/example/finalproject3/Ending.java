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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending_screen);

        playAgain = findViewById(R.id.againbtn);
        scoring = findViewById(R.id.scoring);
        scoring.setText("")

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGame();
            }
        });
    }
    public void launchGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
