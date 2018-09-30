package core.dao;

import api.dao.OperadorDAOCaracteristicas;
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
public class OperadorDAO extends DAO implements OperadorDAOCaracteristicas {

    public OperadorDAO() throws IOException {
        super();
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

            this.preparedStatement = this.conexao.prepareStatement("SELECT * FROM Koyota.OPERADOR WHERE NOME = ?");

            this.preparedStatement.setString(1, name);

            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println("Conectei..");
            
            while (this.resultSet.next()) {
                operador = new Operador();
                operador.setIdOperador(this.resultSet.getInt("pk_operador"));
                operador.setNome(this.resultSet.getString("nome"));
                operador.setEndereco(this.resultSet.getString("endereco"));
                operador.setEmail(this.resultSet.getString("email"));
                operador.setCpf(this.resultSet.getString("cpf"));
                operador.setSenha(this.resultSet.getString("senha"));
            }
            
            this.fecharConexao();
        
        } catch (SQLException e) {
            this.fecharConexao();
            System.out.print("\nErro de conexão...Find by id usuario ");
        }

        return operador;
    }

}
