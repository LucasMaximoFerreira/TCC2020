package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dao.conectarBD;
import model.cadastro_cliente;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText txtNome, txtSenha, txtEmail, txtComp;
    Button btnCad1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        txtEmail = findViewById(R.id.txtEmail);
        txtComp = findViewById(R.id.txtComp);
        btnCad1 = findViewById(R.id.btnCad1);

        btnCad1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCad1:
                //criar uma instancia da classe conectarBD
                conectarBD cad = new conectarBD(this);

                cadastro_cliente clienteTela = new cadastro_cliente();

                clienteTela.setNome_cli(txtNome.getText().toString());
                clienteTela.setSenha_cli(txtSenha.getText().toString());
                clienteTela.setEmail_cli(txtEmail.getText().toString());
                clienteTela.setComp_cli(txtComp.getText().toString());

                cad.setClasseCli(clienteTela);

                Intent telaCad2 = new Intent(this, Cadastro2.class);
                startActivity(telaCad2);
                break;
        }
    }
}
