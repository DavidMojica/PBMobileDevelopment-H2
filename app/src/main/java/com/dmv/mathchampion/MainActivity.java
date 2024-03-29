package com.dmv.mathchampion;

import static com.dmv.mathchampion.R.id.savedText;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private EditText angleInput, numberInput, exponentInput;
    private Button sinButton, cosButton, sqrtButton, powerButton;
    TextView savedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedText = findViewById(R.id.savedText);
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
                getSine();
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCosine();
            }
        });

        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRoot();
            }
        });

        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPower();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSavedData(getApplicationContext(), "data.txt", savedText);
    }

    private void getSine() {
        String angleText = angleInput.getText().toString().trim();
        if (!angleText.isEmpty()) {
            double angle = Double.parseDouble(angleText);
            double result = Math.sin(Math.toRadians(angle));
            openResultsView("Seno de " + angle + " es " + result);
        } else {
            showToast("Ingrese un ángulo");
        }
    }

    private void getCosine() {
        String angleText = angleInput.getText().toString().trim();
        if (!angleText.isEmpty()) {
            double angle = Double.parseDouble(angleText);
            double result = Math.cos(Math.toRadians(angle));
            openResultsView("Coseno de " + angle + " es " + result);
        } else {
            showToast("Ingrese un ángulo");
        }
    }

    private void getRoot() {
        String numberText = numberInput.getText().toString().trim();
        String expoText = exponentInput.getText().toString().trim();
        if (!numberText.isEmpty() && !expoText.isEmpty()) {
            double number = Double.parseDouble(numberText);
            int expo = Integer.parseInt(expoText);
            double result = Math.pow(number, (double) 1 /expo);
            openResultsView("Raiz "+ expo + " de " + number + " es " + result);
        } else {
            showToast("Ingrese un número");
        }
    }

    private void getPower() {
        String numberText = numberInput.getText().toString().trim();
        String expoText = exponentInput.getText().toString().trim();
        if (!numberText.isEmpty() && !expoText.isEmpty()) {
            double number = Double.parseDouble(numberText);
            int expo = Integer.parseInt(expoText);
            double result = Math.pow(number, expo);
            openResultsView("Potencia de " + number + " elevado a "+ expo +" es " + result);
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
    public static void setSavedData(Context context, String filename, TextView textView) {
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(filename);
            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = fis.read()) != -1) {
                stringBuilder.append((char) character);
            }
            textView.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
