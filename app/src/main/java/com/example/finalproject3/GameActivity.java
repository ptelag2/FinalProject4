package com.example.finalproject3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity{

    String[] textColor = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple"};
    TextView colorView;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    boolean[] correct = {false, false, false, false};
    Button[] answers;
    boolean ans1;
    boolean ans2;
    boolean ans3;
    boolean ans4;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        colorView = findViewById(R.id.colorText);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        answers = populateButtons();
        cancel = findViewById(R.id.cancelBtn);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void nextTurn() {
        setAllFalse();

        int correctIndex = (int) (Math.random() * 6);
        int correctButton = (int) (Math.random() * 4);
        correct[correctButton] = true;
        answers[correctButton].setText(textColor[correctIndex]);

        colorView.setText(textColor[correctIndex]);

        setIncorrectButtons(answers[correctButton], textColor[correctIndex]);


    }

    public void setAllFalse() {
        for (int i = 0; i < correct.length; i++) {
            correct[i] = false;
        }
    }

    public void setIncorrectButtons(Button but, String color) {
        ArrayList<String> previous = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == but) {
                continue;
            }

            String wrong = textColor[(int) (Math.random() * 6)];

            while (!canBeUsed(previous, wrong, color)) {
                wrong = textColor[(int) (Math.random() * 6)];
            }

            previous.add(wrong);
            answers[i].setText(wrong);
        }
    }

    public Button[] populateButtons() {
        Button[] toReturn = new Button[4];

        toReturn[0] = findViewById(R.id.btn1);
        toReturn[1] = findViewById(R.id.btn2);
        toReturn[2] = findViewById(R.id.btn3);
        toReturn[3] = findViewById(R.id.btn4);


        return toReturn;
    }

    public boolean canBeUsed(ArrayList<String> array, String str, String correct) {

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(str) || correct.equals(str)) {
                return false;
            }
        }
        return true;
    }

}
