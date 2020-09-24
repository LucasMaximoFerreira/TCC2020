package dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.cadastro_cliente;

public class conectarBD extends AsyncTask<Integer, Object, Boolean> {

    //CONEXAO COM O MYSQL
    Connection conexao;

    //ARMAZENAR A TELA DA CLASSE
    Context tela;

    //CRIAR UMA CAIXA DE MENSAGEM
    ProgressDialog dialogo;

    //ARMAZENAR A OPPÇÃO DO USUARIO
    int op;


    //variavel para armazenar o status do login
    private Boolean login;

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }
    ////////////////////////////////////////////


    //instancia classe cliente
    private cadastro_cliente classeCli = new cadastro_cliente();

    public cadastro_cliente getClasseCli() {
        return classeCli;
    }

    public void setClasseCli(cadastro_cliente classeCli) {
        this.classeCli = classeCli;

    }
    ////////////////////////////////////////////


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
        Boolean resp = null;

        op = integers[0];

        connect();

        switch (op){
            case 0:
                resp = inserir();
                break;
            case 1:
                resp = logar();
                break;
        }

        return resp;

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

        switch (op) {
            case 0:
                if (aBoolean == true) {
                    Toast.makeText(tela, "cadastro ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(tela, "erro", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if (aBoolean == false) {
                    Toast.makeText(tela, "usuario nao cadastrado", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        dialogo.dismiss();

        disconnect();
    }
    private Boolean logar(){
        try{

            String sql = "select * from cadastro_cliente where cpf_cli=? and senha_cli=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, classeCli.getCpf_cli());
            comando.setString(2, classeCli.getSenha_cli());
            ResultSet tabelamemoria = comando.executeQuery();

            if (tabelamemoria.next()) {
                login = true;
                return true;
            } else {
                login = false;
                return false;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    private Boolean inserir(){
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date dataUtil = formato.parse(classeCli.getDtnasc_cli());
            java.sql.Date dataMYSQL = new java.sql.Date(dataUtil.getTime());

            String sql = "insert into cadastro_cliente values (0,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, classeCli.getNome_cli());
            comando.setString(2, classeCli.getSenha_cli());
            comando.setString(3, classeCli.getCpf_cli());
            comando.setString(4, classeCli.getTel_cli());
            comando.setString(5, classeCli.getCep_cli());
            comando.setString(6, classeCli.getNum_cli());
            comando.setString(7, classeCli.getComp_cli());
            comando.setString(8, classeCli.getEmail_cli());
            comando.setDate(9, dataMYSQL);
            comando.setString(10, classeCli.getGen_cli());

            comando.executeUpdate();

            return true;

        }catch (ParseException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

}

//CRIAR CLASSE DE MODELO - INSERIR, LOGIN ENTRE OUTRAS
//POSTEXECUTE - CRIAR AS MENSAGENS CASO FUNCIONE OU NAO
//BOOLEAN DOINBACKGROUND - CRIAR OS METODOS
