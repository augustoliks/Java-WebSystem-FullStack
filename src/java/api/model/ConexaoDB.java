/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import toolbox.readers.LeitorPropiedadesBancoDados;

/**
 *
 * @author visita
 */
public class ConexaoDB {
    
    public Connection connect = null;
    public Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    public Connection conexao;
 
    //jdbc:mysql://150.163.17.237:3306/agenda?" + "user=usuario&password=usuario123
    //jdbc:mariadb://172.16.7.63:3306/agenda","usuario", "usuario123
    private final LeitorPropiedadesBancoDados bdProp;

    public ConexaoDB() throws IOException {
        this.bdProp = new LeitorPropiedadesBancoDados();
    }

    public void conectarBD() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection(this.bdProp.getLinkConexao(), this.bdProp.getUsuario(), this.bdProp.getSenha());
            System.out.println(">>>\tConectado.. BANCO DE DADOS...");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(">>>\tErro de conexão... BANCO DE DADOS");
        }
    }

    public void fecharConexao() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.print(">>>\tErro AO FECHAR CONEXAO COM BANCO DE DADOS");
        }
    }
}
