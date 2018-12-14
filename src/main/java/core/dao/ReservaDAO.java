/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ReservaDAOCaracteristicas;
import api.model.Cliente;
import api.model.ConexaoDB;
import api.model.Reserva;
import api.model.Veiculo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;


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
        
        conexaoDB.preparedStatement.setDate(3, new java.sql.Date( reserva.getDataHoraInicio().toDate().getTime() ) );
        conexaoDB.preparedStatement.setDate(4, new java.sql.Date( reserva.getDataHoraTermino().toDate().getTime() ) );
        
        conexaoDB.preparedStatement.setFloat(5, reserva.getValorPrevisto());
        
        conexaoDB.preparedStatement.executeQuery();

    }

    @Override
    public void update(Reserva reserva) throws SQLException {
        

    }

    @Override
    public List findAll() throws SQLException {
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
      
        List<Reserva> reservas = new ArrayList<>();
      
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.RESERVA");
        
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
        
        while (conexaoDB.resultSet.next()) {
            Reserva reserva = new Reserva();
            
            reserva.setCliente(new Cliente());
            reserva.setVeiculo(new Veiculo());
            
            reserva.setId(conexaoDB.resultSet.getInt("pk_reserva"));
            
            reserva.getCliente().setId(conexaoDB.resultSet.getInt("fk_cliente"));
            reserva.getVeiculo().setId(conexaoDB.resultSet.getInt("fk_veiculo"));

            reserva.setDataHoraInicio(new DateTime( conexaoDB.resultSet.getDate("data_hora_incio" )));
            reserva.setDataHoraTermino(new DateTime(conexaoDB.resultSet.getDate("data_hora_termino")));

            reserva.setValorPrevisto(conexaoDB.resultSet.getFloat("valor_previsto"));
            
            reservas.add(reserva);
        }
        
        return reservas;
        
    }

    @Override
    public Reserva findById(int idReserva) throws SQLException {
        
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.RESERVA where pk_reserva = ?");
        conexaoDB.preparedStatement.setInt(1, idReserva);
        
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
        
        Reserva reserva = null;
        
        while (conexaoDB.resultSet.next()) {
            reserva = new Reserva();
            
            reserva.setCliente(new Cliente());
            reserva.setVeiculo(new Veiculo());
            
            reserva.setId(conexaoDB.resultSet.getInt("pk_reserva"));
            
            reserva.getCliente().setId(conexaoDB.resultSet.getInt("fk_cliente"));
            reserva.getVeiculo().setId(conexaoDB.resultSet.getInt("fk_veiculo"));

            reserva.setDataHoraInicio(new DateTime(conexaoDB.resultSet.getDate("data_hora_incio")));
            reserva.setDataHoraTermino(new DateTime(conexaoDB.resultSet.getDate("data_hora_termino")));

            reserva.setValorPrevisto(conexaoDB.resultSet.getFloat("valor_previsto"));
            
        }
        
        return reserva;
        
    }

    @Override
    public void deleteById(int idReserva) throws SQLException {
 
        // DELETE FROM RESERVA WHERE Koyota.RESERVA.pk_reserva = ?

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
      
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("DELETE FROM Koyota.RESERVA WHERE pk_reserva = ?");
        conexaoDB.preparedStatement.setInt(1, idReserva);
        
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
   
    }
 
}
