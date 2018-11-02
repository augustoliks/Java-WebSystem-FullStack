package core.dao;

import api.dao.OperadorDAOCaracteristicas;
import api.model.ConexaoDB;
import api.model.Operador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public class OperadorDAO implements OperadorDAOCaracteristicas {

    private ConexaoDB conexaoDB;
    
    public OperadorDAO() throws IOException {
        this.conexaoDB = new ConexaoDB();
    }

    @Override
    public boolean insert(Operador operador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findByNomeCliente(String nomeCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findByName(String name) {
        Operador operador = null;

        try {
            conexaoDB.conectarBD();
            conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.OPERADOR WHERE NOME = ?");
                    
            conexaoDB.preparedStatement.setString(1, name);

            conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
            System.out.println("Conectei..");
            
            while (conexaoDB.resultSet.next()) {
                operador = new Operador();
                operador.setIdOperador(conexaoDB.resultSet.getInt("pk_operador"));
                operador.setNome(conexaoDB.resultSet.getString("nome"));
                operador.setEndereco(conexaoDB.resultSet.getString("endereco"));
                operador.setEmail(conexaoDB.resultSet.getString("email"));
                operador.setCpf(conexaoDB.resultSet.getString("cpf"));
                operador.setSenha(conexaoDB.resultSet.getString("senha"));
            }
            
            conexaoDB.fecharConexao();
        
        } catch (SQLException e) {
            conexaoDB.fecharConexao();
            System.out.print("\nErro de conexão...Find by id usuario ");
        }

        return operador;
    }

}
