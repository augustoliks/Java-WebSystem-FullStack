/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Veiculo;
import api.servico.CadastroVeiculoCaracteristicas;
import core.dao.VeiculoDAO;
import java.io.IOException;
import java.sql.SQLException;

public class CadastroVeiculoServico implements CadastroVeiculoCaracteristicas {

    VeiculoDAOCaracteristicas veiculoDAOImpl;
    
    public CadastroVeiculoServico() throws IOException{
        veiculoDAOImpl = new VeiculoDAO();
    }
    
    @Override
    public boolean insercao(Veiculo veiculo){
         
        boolean status = false;
        
        try {
            veiculoDAOImpl.insert(veiculo);
            status = true;
        }
        catch (SQLException e){
            status = false;
        }
        
        return status;
    }
    
}