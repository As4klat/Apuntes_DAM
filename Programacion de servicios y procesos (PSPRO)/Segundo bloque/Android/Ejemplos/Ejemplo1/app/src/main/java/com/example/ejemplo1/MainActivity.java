package com.example.ejemplo1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnCambiar;
    private TextView tvMsm;
    private TextView textTotal;
    private TextView num1;
    private TextView num2;
    private int cont=0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambiar = findViewById(R.id.btnCambiar);
        tvMsm = findViewById(R.id.msg);
        textTotal = findViewById(R.id.textSol);
        num1 = findViewById(R.id.numberN1);
        num2 = findViewById(R.id.numberN2);
        Button btnSumar = findViewById(R.id.btnSumar);

        btnCambiar.setOnClickListener(view -> {
            if(tvMsm.getText().equals("Hola")){
                tvMsm.setText("Adios");
            }
            else {
                tvMsm.setText("Hola");
            }
            cont++;

            String text = btnCambiar.getText().toString();
            text = text.replace(text.charAt(text.length()-1),Character.forDigit(cont,10));
            btnCambiar.setText(text);
        });

        btnSumar.setOnClickListener(view -> {
            int numero2 = Integer.parseInt(num2.getText().toString());
            int numero1 = Integer.parseInt(num1.getText().toString());
            num2.setText("");
            num1.setText("");
            int total = numero1 + numero2;
            textTotal.setText(String.valueOf(total));

        });
    }
}