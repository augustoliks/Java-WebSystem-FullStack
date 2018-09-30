/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

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
 * @author liks
 */
public class DAO {

    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    private final LeitorPropiedadesBancoDados bdProp = new LeitorPropiedadesBancoDados();
    private String linkConexao;
    protected Connection conexao;

    public DAO() throws IOException {
        this.montarLinkConexao();
        this.ConectarBD();
    }

    private void montarLinkConexao() throws IOException {
        //jdbc:mysql://150.163.17.237:3306/agenda?" + "user=usuario&password=usuario123
        //jdbc:mariadb://172.16.7.63:3306/agenda","usuario", "usuario123

        StringBuilder link = new StringBuilder();

        link.append(this.bdProp.getModulo());
        link.append(":");
        link.append(this.bdProp.getSGBD());
        link.append("://");
        link.append(this.bdProp.getEndereco());
        link.append("/");
        link.append(this.bdProp.getBaseDados());
       
        this.linkConexao = link.toString();
    }

    private void ConectarBD() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection(this.linkConexao, this.bdProp.getUsuario(), this.bdProp.getSenha());
            System.out.println(">>>\tConectado.. BANCO DE DADOS...");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(">>>\tErro de conexão... BANCO DE DADOS");
        }
    }

    protected void fecharConexao() {
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

        }
    }
}
