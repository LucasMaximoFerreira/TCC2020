package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import dao.conectarBD;
import model.cadastro_cliente;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText txtLogin, txtSenha;
    Button btnLogar, btnCadastrar;

    cadastro_cliente telaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        telaCliente = new cadastro_cliente();

        btnLogar.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogar:
                try{
                    conectarBD logar = new conectarBD(this);

                    // transferir o LOGIN e a SENHA para a classe da tela
                    telaCliente.setCpf_cli(txtLogin.getText().toString());
                    telaCliente.setSenha_cli(txtSenha.getText().toString());

                    // transferir o objeto TELA para classe conectarBD na classe cadastro_cliente
                    logar.setClasseCli(telaCliente);

                    // executar o comando SELECT para verificar o LOGIN e a SENHA
                    logar.execute(1).get();


                    // verificar através da variável LOGIN se ela é TRUE ou FALSE
                    if(logar.getLogin() == true){
                        Intent telaLogin = new Intent(this, MainActivity.class);
                        startActivity(telaLogin);
                    }else{
                        telaCliente = new cadastro_cliente();
                    }

                }catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }

                break;
            case R.id.btnCadastrar:
                Intent telaCad = new Intent(this, Cadastro.class);
                startActivity(telaCad);
                break;
        }
    }
}