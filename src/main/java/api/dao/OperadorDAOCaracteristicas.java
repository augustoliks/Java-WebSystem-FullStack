/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Operador;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public interface OperadorDAOCaracteristicas {
    public void insert(Operador operador) throws SQLException;
    public Operador findById(Long id) throws SQLException;
    public Operador findByNomeCliente(String nomeCliente) throws SQLException;
    public Operador findByName(String name) throws SQLException;
}
