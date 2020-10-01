package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dao.conectarBD;
import model.cadastro_cliente;

public class Cadastro3 extends AppCompatActivity implements View.OnClickListener {


    EditText txtCEP, txtNumero, txtData;
    Button btnCad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro3);

        txtCEP = findViewById(R.id.txtCEP);
        txtNumero = findViewById(R.id.txtNumero);
        txtData = findViewById(R.id.txtData);
        btnCad3 = findViewById(R.id.btncad3);

        btnCad3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncad3:
                conectarBD cad = new conectarBD(this);

                cadastro_cliente clienteTela = new cadastro_cliente();

                clienteTela.setCep_cli(txtCEP.getText().toString());
                clienteTela.setNum_cli(txtNumero.getText().toString());
                clienteTela.setDtnasc_cli(txtData.getText().toString());

                cad.setClasseCli(clienteTela);

                cad.execute(0);

                break;
        }
    }
}
