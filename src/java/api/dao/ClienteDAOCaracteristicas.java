/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Cliente;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public interface ClienteDAOCaracteristicas {
    public void insert(Cliente cliente)  throws SQLException;
    public Cliente findById(int id) throws SQLException;
    public Cliente findByNomeCliente(String nomeCliente)  throws SQLException;
    public Cliente findByName(String name)  throws SQLException;
}
