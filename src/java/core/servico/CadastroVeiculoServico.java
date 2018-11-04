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

public class CadastroVeiculoServico implements CadastroVeiculoCaracteristicas {

    VeiculoDAOCaracteristicas veiculoDAOImpl;
    CategoriaDAOCaracteristicas categoriaDAOImpl;
    
    public CadastroVeiculoServico() throws IOException{
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
    }
    
    @Override
    public boolean insercao(Veiculo veiculo){
         
        boolean status = false;
        Categoria categoriaDB = null;
        
        try {
            categoriaDB = categoriaDAOImpl.findByName(veiculo.getCategoria());
            veiculoDAOImpl.insert(veiculo, categoriaDB.getIdCategoria());
            status = true;
        }
        catch (SQLException e){
            
            status = false;
            System.out.println(e.toString());
        }
        
        return status;
    }
    
}