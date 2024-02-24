package com.dmv.mathchampion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText angleInput, numberInput, exponentInput;
    private Button sinButton, cosButton, sqrtButton, powerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleInput = findViewById(R.id.angleInput);
        numberInput = findViewById(R.id.numberInput);
        exponentInput = findViewById(R.id.exponentInput);

        sinButton = findViewById(R.id.sinButton);
        cosButton = findViewById(R.id.cosButton);
        sqrtButton = findViewById(R.id.sqrtButton);
        powerButton = findViewById(R.id.powerButton);


        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSine();
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCosine();
            }
        });

        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquareRoot();
            }
        });

        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePower();
            }
        });
    }

    private void calculateSine() {
        String angleText = angleInput.getText().toString().trim();
        if (!angleText.isEmpty()) {
            double angle = Double.parseDouble(angleText);
            double result = Math.sin(Math.toRadians(angle));
            openResultsView("Seno de " + angle + " es " + result);
        } else {
            showToast("Ingrese un ángulo");
        }
    }



    private void calculateCosine() {
        String angleText = angleInput.getText().toString().trim();
        if (!angleText.isEmpty()) {
            double angle = Double.parseDouble(angleText);
            double result = Math.cos(Math.toRadians(angle));
            openResultsView("Coseno de " + angle + " es " + result);
        } else {
            showToast("Ingrese un ángulo");
        }
    }

    private void calculateSquareRoot() {
        String numberText = numberInput.getText().toString().trim();
        String expoText = exponentInput.getText().toString().trim();
        if (!numberText.isEmpty() && !expoText.isEmpty()) {
            double number = Double.parseDouble(numberText);
            int expo = Integer.parseInt(expoText);
            double result = Math.pow(number, (double) 1 /expo);
            openResultsView("Raíz"+ expo + " de " + number + " es " + result);
        } else {
            showToast("Ingrese un número");
        }
    }

    private void calculatePower() {
        String numberText = numberInput.getText().toString().trim();
        String expoText = exponentInput.getText().toString().trim();
        if (!numberText.isEmpty() && !expoText.isEmpty()) {
            double number = Double.parseDouble(numberText);
            int expo = Integer.parseInt(expoText);
            double result = Math.pow(number, expo);
            openResultsView("Potencia de " + number + " elevado a"+ expo +" es " + result);
        } else {
            showToast("Ingrese un número");
        }
    }

    private void openResultsView(String text) {
        Intent i = new Intent(MainActivity.this, results.class);
        i.putExtra("text", text);
        startActivity(i);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
