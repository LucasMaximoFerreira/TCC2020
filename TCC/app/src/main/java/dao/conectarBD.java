package dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarBD extends AsyncTask<Integer, Object, Boolean> {

    //CONEXAO COM O MYSQL
    Connection conexao;

    //ARMAZENAR A TELA DA CLASSE
    Context tela;

    //CRIAR UMA CAIXA DE MENSAGEM
    ProgressDialog dialogo;

    //ARMAZENAR A OPPÇÃO DO USUARIO
    int op;



    //METODO PARA CRIAR CONEXAO COM O MYSQL
    public Boolean connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection("jdbc:mysql://192.168.0.18:3306/casadoacai;", "root", "lucas4max");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //METODO PARA FECHAR A CONEXAO COM O MYSQL
    public void disconnect(){
        try{
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //CONSTRUTOR DA CLASSE, PARA CONECTAR A TELA COM A CLASSE
    public conectarBD(Context tela){
        super();
        this.tela = tela;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialogo = new ProgressDialog(tela);
        dialogo.setMessage("Aguarde conectando...");
        dialogo.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}

//CRIAR CLASSE DE MODELO - INSERIR, LOGIN ENTRE OUTRAS
//POSTEXECUTE - CRIAR AS MENSAGENS CASO FUNCIONE OU NAO
//BOOLEAN DOINBACKGROUND - CRIAR OS METODOS
