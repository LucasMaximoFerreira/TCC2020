package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import dao.conectarBD;
import model.cadastro_cliente;

public class Cadastro2 extends AppCompatActivity implements View.OnClickListener {

    EditText txtCPF, txtTelefone;
    Button btnCad2;
    RadioGroup rgGen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);

        txtCPF = findViewById(R.id.txtCPF);
        txtTelefone = findViewById(R.id.txtTelefone);
        rgGen = findViewById(R.id.rgGen);
        btnCad2 = findViewById(R.id.btnCad2);

        btnCad2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCad2:

                conectarBD cad = new conectarBD(this);

                cadastro_cliente clienteTela = new cadastro_cliente();

                clienteTela.setCpf_cli(txtCPF.getText().toString());
                clienteTela.setTel_cli(txtTelefone.getText().toString());

                int opGen = rgGen.getCheckedRadioButtonId();
                switch (opGen){
                    case R.id.rbMasculino:
                        clienteTela.setGen_cli("Masculino");
                        break;
                    case R.id.rbFeminino:
                        clienteTela.setGen_cli("Feminino");
                        break;
                    case R.id.rbPND:
                        clienteTela.setGen_cli("Prefiro não dizer");
                        break;
                }
                cad.setClasseCli(clienteTela);

                Intent telaCad3 = new Intent(this, Cadastro3.class);
                startActivity(telaCad3);
                break;
        }
    }
}
