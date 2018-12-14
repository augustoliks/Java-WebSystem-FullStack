/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Veiculo;
import api.model.Categoria;
import api.servico.CadastroVeiculoCaracteristicas;
import core.dao.CategoriaDAO;
import core.dao.VeiculoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroVeiculoServico implements CadastroVeiculoCaracteristicas {
    
    @Override
    public boolean insercao(Veiculo veiculo){
        
        VeiculoDAOCaracteristicas veiculoDAOImpl;
        CategoriaDAOCaracteristicas categoriaDAOImpl;
        
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        
        boolean status = false;
        Categoria categoriaDB = null;
        
        try {
            categoriaDB = categoriaDAOImpl.findByName(veiculo.getCategoria().getNome());
            veiculo.setCategoria(categoriaDB); 
            veiculoDAOImpl.insert(veiculo);
            status = true;
        }
        catch (SQLException e){           
            status = false;
            System.out.println(e.toString());
        }
        
        return status;
    }
    
}