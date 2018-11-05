/*}
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Veiculo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author liks
 */
public interface VeiculoDAOCaracteristicas {    
    public void insert(Veiculo veiculo) throws SQLException;
    public List findCarsByCategoria(int categoriaID) throws SQLException;
    public Veiculo findById(int idVeiculo) throws SQLException;
    public List findAll() throws SQLException;
}