package com.example.englishpracticer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showGrade extends AppCompatActivity {
    int grade;
    int iNumOfWords;
    TextView txtGrade;
    Button restart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grade);

        Bundle extras = getIntent().getExtras();
        String gradeNum = extras.getString("key");
        grade = Integer.parseInt(gradeNum);

        String numOfWords = extras.getString("key2");
        iNumOfWords = Integer.parseInt(numOfWords);

        txtGrade = findViewById(R.id.gradeShow);
        txtGrade.setText("Your Grade is " + ((grade*100)/iNumOfWords));

        restart = findViewById(R.id.restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showGrade.this, gameSet.class);
                startActivity(intent);
            }
        });

    }
}