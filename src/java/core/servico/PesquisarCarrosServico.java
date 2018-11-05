/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import core.dao.VeiculoDAO;
import java.io.IOException;
import java.util.List;
import api.servico.PesquisarCarrosCaracteristicas;
import core.dao.CategoriaDAO;
import java.sql.SQLException;
import api.model.Veiculo;
import com.google.gson.Gson;


/**
 *
 * @author visita
 */
public class PesquisarCarrosServico implements PesquisarCarrosCaracteristicas{

    VeiculoDAOCaracteristicas veiculoDAOImpl;
    CategoriaDAOCaracteristicas categoriaDAOImpl;

    @Override
    public String pesquisarCarros(String nomeCategoria) {

        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        
        Categoria categoria = null;
        List<Veiculo> carros = null;
        
        try {
            categoria = categoriaDAOImpl.findByName(nomeCategoria);
            carros = veiculoDAOImpl.findCarsByCategoria(categoria.getId());
            
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }
    
        String jsonCarros = new Gson().toJson(carros);
       
        return jsonCarros;
    }
    
}
