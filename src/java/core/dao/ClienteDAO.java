/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ClienteDAOCaracteristicas;
import api.model.Cliente;
import api.model.ConexaoDB;
import api.model.Operador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liks
 */
public class ClienteDAO implements ClienteDAOCaracteristicas {

    private ConexaoDB conexaoDB;
    
    public ClienteDAO() throws IOException {
        this.conexaoDB = new ConexaoDB();
    }

    @Override
    public boolean insert(Cliente cliente) {
        boolean status;

        try {
            conexaoDB.conectarBD();
            
            conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                    + "INSERT INTO CLIENTE ("
                    + "pk_cliente, "
                    + "nome, "
                    + "endereco, "
                    + "email, "
                    + "cpf, "
                    + "senha) "
                    + "VALUES (?, ?, ?, ?, ?, ?);");

            conexaoDB.preparedStatement.setString(1, cliente.getRg());
            conexaoDB.preparedStatement.setString(2, cliente.getNome());
            conexaoDB.preparedStatement.setString(3, cliente.getEndereco());
            conexaoDB.preparedStatement.setString(4, cliente.getEmail());
            conexaoDB.preparedStatement.setString(5, cliente.getCpf());
            conexaoDB.preparedStatement.setString(6, cliente.getSenha());
            conexaoDB.preparedStatement.executeQuery();

            status = true;

        } catch (Exception e) {
            System.out.println("Erro no insert CadastroCliente");
            status = false;
        }
        return status;
    }

    @Override
    public Cliente findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByNomeCliente(String nomeCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByName(String name) {
        Cliente cliente = null;

        try {
            conexaoDB.conectarBD();
            conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CLIENTE WHERE NOME = ?");

            conexaoDB.preparedStatement.setString(1, name);

            conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
            System.out.println("Conectei..");

            while (conexaoDB.resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(conexaoDB.resultSet.getInt("pk_cliente"));
                cliente.setNome(conexaoDB.resultSet.getString("nome"));
                cliente.setEndereco(conexaoDB.resultSet.getString("endereco"));
                cliente.setEmail(conexaoDB.resultSet.getString("email"));
                cliente.setCpf(conexaoDB.resultSet.getString("cpf"));
                cliente.setSenha(conexaoDB.resultSet.getString("senha"));
            }

            conexaoDB.fecharConexao();

        } catch (Exception e) {
            System.out.print("\nErro de conexão...Find by name Clietne");
            conexaoDB.fecharConexao();
        }

        return cliente;

    }

}
