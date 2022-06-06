package com.example.englishpracticer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class mainGame extends AppCompatActivity {

    int NumOfWords;
    int fNumOfWords; // final value of the number of words
    wordsDataBase dataBase = new wordsDataBase();
    List<String> words = new ArrayList<>();
    List<String> solutions = new ArrayList<>();
    TextView txtWord, txtSol, txtKnow;
    Button showSol ;
    ImageButton plusButt,minusButt;
    int grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);


        Bundle extras = getIntent().getExtras();
        String wordsNum = extras.getString("key");
        NumOfWords = Integer.parseInt(wordsNum);
        fNumOfWords = NumOfWords;

        construct();
        setNewWords();
        makeWordsInvise();


        showSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSol.setVisibility(View.VISIBLE);
                plusButt.setVisibility(View.VISIBLE);
                minusButt.setVisibility(View.VISIBLE);
                txtKnow.setVisibility(View.VISIBLE);
                NumOfWords--;
            }
        });

        plusButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade ++;
                gradeCheck();
                if(NumOfWords>0){
                    setNewWords();
                }
                makeWordsInvise();
            }
        });

        minusButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeCheck();
                if(NumOfWords>0){
                    setNewWords();
                }
                makeWordsInvise();
            }
        });

    }

    private void makeWordsInvise() {
        // make all relevant widgets invisible
        txtSol.setVisibility(View.INVISIBLE);
        plusButt.setVisibility(View.INVISIBLE);
        minusButt.setVisibility(View.INVISIBLE);
        txtKnow.setVisibility(View.INVISIBLE);
    }

    private void gradeCheck(){
        if(NumOfWords<=0){
            String sGrade = "" + grade;
            String sNumOfWords = "" + fNumOfWords;
            Intent intent = new Intent(mainGame.this, showGrade.class);
            intent.putExtra("key",sGrade);
            intent.putExtra("key2",sNumOfWords);
            startActivity(intent);
        }

    }

    private void setNewWords() {
        String [] quest = dataBase.getWord(); // first 2 words to pop
        boolean found = false;

        for(String s : words){    // for each loop to make sure words doesn't pop twice
            found = quest[0].equals(s);
            if(found){
                setNewWords();
            }
        }

        words.add(quest[0]);
        solutions.add(quest[1]);

        txtWord= findViewById(R.id.word);
        txtWord.setText(quest[0].toString());
        txtSol = findViewById(R.id.sol);
        txtSol.setText(quest[1].toString());
    }

    private void construct() {

        txtKnow = findViewById(R.id.knowQuest);

        plusButt = findViewById(R.id.plusButt);
        minusButt = findViewById(R.id.minusButt);

        grade = 0;

        showSol = findViewById(R.id.solution);


    }
}