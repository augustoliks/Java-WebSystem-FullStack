/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ClienteDAOCaracteristicas;
import api.model.Cliente;
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
public class ClienteDAO extends DAO implements ClienteDAOCaracteristicas {

    public ClienteDAO() throws IOException {
        super();
    }

    @Override
    public boolean insert(Cliente cliente) {
        boolean status;

        PreparedStatement comandoSQLp;

        try {
            comandoSQLp = this.conexao.prepareStatement(""
                    + "INSERT INTO CLIENTE ("
                    + "pk_cliente, "
                    + "nome, "
                    + "endereco, "
                    + "email, "
                    + "cpf, "
                    + "senha) "
                    + "VALUES (?, ?, ?, ?, ?, ?);");

            comandoSQLp.setString(1, cliente.getRg());
            comandoSQLp.setString(2, cliente.getNome());
            comandoSQLp.setString(3, cliente.getEndereco());
            comandoSQLp.setString(4, cliente.getEmail());
            comandoSQLp.setString(5, cliente.getCpf());
            comandoSQLp.setString(6, cliente.getSenha());
            comandoSQLp.executeQuery();
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
            this.preparedStatement = this.conexao.prepareStatement("SELECT * FROM Koyota.CLIENTE WHERE NOME = ?");

            this.preparedStatement.setString(1, name);

            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println("Conectei..");

            while (this.resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(this.resultSet.getInt("pk_cliente"));
                cliente.setNome(this.resultSet.getString("nome"));
                cliente.setEndereco(this.resultSet.getString("endereco"));
                cliente.setEmail(this.resultSet.getString("email"));
                cliente.setCpf(this.resultSet.getString("cpf"));
                cliente.setSenha(this.resultSet.getString("senha"));
            }

            this.fecharConexao();
        } catch (Exception e) {
            System.out.print("\nErro de conexão...Find by name Clietne");
            this.fecharConexao();
        }

        return cliente;

    }

}
