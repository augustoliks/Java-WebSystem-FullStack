/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Veiculo;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public interface VeiculoDAOCaracteristicas {    
    public void insert(Veiculo veiculo) throws SQLException;
}