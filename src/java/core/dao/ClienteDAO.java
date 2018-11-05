/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ClienteDAOCaracteristicas;
import api.model.Cliente;
import api.model.ConexaoDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liks
 */
public class ClienteDAO implements ClienteDAOCaracteristicas {

    private ConexaoDB conexaoDB;
    
    @Override
    public void insert(Cliente cliente) throws SQLException{
       
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean status;

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

    }

    @Override
    public Cliente findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByNomeCliente(String nomeCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByName(String name) throws SQLException{

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cliente cliente = null;

        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CLIENTE WHERE NOME = ?");

        conexaoDB.preparedStatement.setString(1, name);

        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
        System.out.println("Conectei..");

        while (conexaoDB.resultSet.next()) {
            cliente = new Cliente();
            cliente.setId(conexaoDB.resultSet.getInt("pk_cliente"));
            cliente.setNome(conexaoDB.resultSet.getString("nome"));
            cliente.setEndereco(conexaoDB.resultSet.getString("endereco"));
            cliente.setEmail(conexaoDB.resultSet.getString("email"));
            cliente.setCpf(conexaoDB.resultSet.getString("cpf"));
            cliente.setSenha(conexaoDB.resultSet.getString("senha"));
        }
        
        conexaoDB.fecharConexao();
        
        return cliente;
    }
}
