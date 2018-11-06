/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface CategoriaDAOCaracteristicas {
    public Categoria findByName(String categoria) throws SQLException;
    public List findAll() throws SQLException;
    public Categoria findById(int idCategoria) throws SQLException;
}
