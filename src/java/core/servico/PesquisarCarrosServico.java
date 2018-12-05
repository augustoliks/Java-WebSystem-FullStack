/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.ReservaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import api.model.Reserva;
import core.dao.VeiculoDAO;
import java.util.List;
import api.servico.PesquisarCarrosCaracteristicas;
import core.dao.CategoriaDAO;
import java.sql.SQLException;
import api.model.Veiculo;
import com.google.gson.Gson;
import core.dao.ReservaDAO;
import java.util.ArrayList;



/**
 *
 * @author visita
 */
public class PesquisarCarrosServico implements PesquisarCarrosCaracteristicas{

    VeiculoDAOCaracteristicas veiculoDAOImpl;
    CategoriaDAOCaracteristicas categoriaDAOImpl;
    ReservaDAOCaracteristicas reservaDAOImpl;
    
    @Override
    public String pesquisarCarros(String nomeCategoria) {

        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();
        
        Categoria categoria = null;
        List<Veiculo> veiculos = null;
        List<Reserva> reservas = null;
        
        try {
            categoria = categoriaDAOImpl.findByName(nomeCategoria);
            veiculos = veiculoDAOImpl.findCarsByCategoria(categoria.getId());
            reservas = reservaDAOImpl.findAll();
            
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }
    
        for(Reserva reserva : reservas){
            for(Veiculo veiculo : veiculos){
                if (reserva.getVeiculo().getId() == veiculo.getId()){
                    veiculos.remove(veiculo);
                    break;
                }
            }
            
        }
        
        String jsonCarros = new Gson().toJson(veiculos);
       
        return jsonCarros;
    }

    @Override
    public String carrosNaoDisponiveis() {
   
        
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();
        
        List<Veiculo> veiculos = null;
        List<Reserva> reservas = null;
        
        try {
            veiculos = veiculoDAOImpl.findAll();
            reservas = reservaDAOImpl.findAll();
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }
    
     
        List<Veiculo> veiculosNaoDisponiveis =  new ArrayList<>();
        
        for(Reserva reserva : reservas){
            for(Veiculo veiculo : veiculos){
                if (reserva.getVeiculo().getId() == veiculo.getId()){
                    veiculosNaoDisponiveis.add(veiculo);
                    break;
                }
            }
        }
        
        String jsonCarros = new Gson().toJson(veiculosNaoDisponiveis);
       
        return jsonCarros;
        
    }

    @Override
    public String carrosDisponiveis() {
   
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();
        
        List<Categoria> categorias = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        
        try {
            categorias = categoriaDAOImpl.findAll();
            veiculos = veiculoDAOImpl.findAll();
            reservas = reservaDAOImpl.findAll();
            
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }
    
        for(Reserva reserva : reservas){
            for(Veiculo veiculo : veiculos){
                if (reserva.getVeiculo().getId() == veiculo.getId()){
                    veiculos.remove(veiculo);
                    break;
                }
            }
            
        }
        
        String jsonCarros = new Gson().toJson(veiculos);
       
        return jsonCarros;
    }
    
}