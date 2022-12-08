package com.empresa.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.empresa.alcoolougasolina.R.id;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(id.resultado);
    }

    public void calcularPreco(View view){
        String precoGasolina = editPrecoGasolina.getText().toString();
        String precoAlcool = editPrecoAlcool.getText().toString();
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);

        if(camposValidados){
            double valorGasolina = Double.parseDouble(precoGasolina);
            double valorAlcool = Double.parseDouble(precoAlcool);

            if((valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("É melhor utilizar Gasolina");
            }else{
                textResultado.setText("É melhor utilizar Álcool");
            }

        }else{
            textResultado.setText("preencha os preços primeiro");
        }
    }

    public Boolean validarCampos(String alcool, String gasolina){
        Boolean camposValidados = true;
        boolean validarAlcool = alcool == null || alcool.equals("");
        boolean validargasolina = gasolina == null || gasolina.equals("");
        if(validarAlcool || validargasolina ){
            camposValidados = false;
        }

        return camposValidados;
    }
}