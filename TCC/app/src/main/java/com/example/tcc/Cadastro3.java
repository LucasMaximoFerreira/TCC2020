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


    EditText txtCEP, txtNumero, txtComp;
    Button btnCad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro3);

        txtCEP = findViewById(R.id.txtCEP);
        txtNumero = findViewById(R.id.txtNumero);
        txtComp = findViewById(R.id.txtComp);
        btnCad3 = findViewById(R.id.btncad3);

        btnCad3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncad3:
                conectarBD cad3 = new conectarBD(this);

                cadastro_cliente clienteTela = new cadastro_cliente();

                clienteTela.setCep_cli(txtCEP.getText().toString());
                clienteTela.setNum_cli(txtNumero.getText().toString());
                clienteTela.setComp_cli(txtComp.getText().toString());

                cad3.setClasseCli(clienteTela);

                cad3.execute(0);

                Intent telaLogar = new Intent(this, Login.class);
                startActivity(telaLogar);
                break;
        }
    }
}
