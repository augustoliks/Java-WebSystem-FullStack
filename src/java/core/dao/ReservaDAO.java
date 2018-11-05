/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ReservaDAOCaracteristicas;
import api.model.ConexaoDB;
import api.model.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ReservaDAO implements ReservaDAOCaracteristicas{
    
    private ConexaoDB conexaoDB;

    @Override
    public void insert(Reserva reserva) throws SQLException {
 
        try {
            conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            System.out.println(ReservaDAO.class.getName());
        }
        conexaoDB.conectarBD();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                + "INSERT INTO RESERVA("
                    + " fk_cliente, "
                    + " fk_veiculo, "
                    + " data_hora_incio, "
                    + " data_hora_termino, "
                    + " valor_previsto"
                + ")"
                + "VALUES ("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                + ");");

        conexaoDB.preparedStatement.setInt(1, reserva.getCliente().getId());
        conexaoDB.preparedStatement.setInt(2, reserva.getVeiculo().getId());
        
        conexaoDB.preparedStatement.setDate(3, new java.sql.Date( reserva.getDataHoraInicio().getTime() ) );
        conexaoDB.preparedStatement.setDate(4, new java.sql.Date( reserva.getDataHoraTermino().getTime() ) );
        
        conexaoDB.preparedStatement.setFloat(5, reserva.getValorPrevisto());
        
        conexaoDB.preparedStatement.executeQuery();

    }

    @Override
    public void update(Reserva reserva) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Reserva reserva) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
