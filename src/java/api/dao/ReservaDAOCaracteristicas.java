/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Cliente;
import api.model.Reserva;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author liks
 */
public interface ReservaDAOCaracteristicas {
    public void insert(Reserva reserva) throws SQLException;
    public void update(Reserva reserva) throws SQLException;
    public List findAll() throws SQLException;
    public void delete(Reserva reserva) throws SQLException;
    
}
