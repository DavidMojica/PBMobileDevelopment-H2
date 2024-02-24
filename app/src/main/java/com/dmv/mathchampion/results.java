package com.dmv.mathchampion;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class results extends AppCompatActivity{
    TextView resultText;
    Button backButton;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        resultText= findViewById(R.id.result);
        backButton = findViewById(R.id.returnBtn);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(results.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        msg = getIntent().getStringExtra("text");
        resultText.setText(msg);
    }
}