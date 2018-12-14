package core.dao;

import api.dao.OperadorDAOCaracteristicas;
import api.model.ConexaoDB;
import api.model.Operador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liks
 */
public class OperadorDAO implements OperadorDAOCaracteristicas {

    private ConexaoDB conexaoDB;
    
    @Override
    public void insert(Operador operador) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findById(Long id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findByNomeCliente(String nomeCliente)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador findByName(String name)  throws SQLException{
        
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Operador operador = null;

        conexaoDB.conectarBD();
        
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.OPERADOR WHERE NOME = ?");

        conexaoDB.preparedStatement.setString(1, name);

        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
        
        while (conexaoDB.resultSet.next()) {
            operador = new Operador();
            operador.setId(conexaoDB.resultSet.getInt("pk_operador"));
            operador.setNome(conexaoDB.resultSet.getString("nome"));
            operador.setEndereco(conexaoDB.resultSet.getString("endereco"));
            operador.setEmail(conexaoDB.resultSet.getString("email"));
            operador.setCpf(conexaoDB.resultSet.getString("cpf"));
            operador.setSenha(conexaoDB.resultSet.getString("senha"));
        }

        conexaoDB.fecharConexao();

        return operador;
    }

}
