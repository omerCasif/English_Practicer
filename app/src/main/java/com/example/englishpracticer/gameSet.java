package com.example.englishpracticer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gameSet extends AppCompatActivity {

    EditText edtNumbers;
    Button start;
    int words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_set);

        construct();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                words = Integer.parseInt(edtNumbers.getText().toString());

                if(words<=0){
                    Toast.makeText(getApplicationContext(), "Invalid number of words", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(gameSet.this, mainGame.class);
                    intent.putExtra("key",edtNumbers.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }



    private void construct() {
        edtNumbers = findViewById(R.id.editTextNumber);
        start = findViewById(R.id.button);
    }
}