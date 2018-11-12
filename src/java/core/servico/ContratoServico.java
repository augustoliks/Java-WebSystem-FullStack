/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.ContratoDAOCaracteristicas;
import api.dao.ReservaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import api.model.Contrato;
import api.model.Operador;
import api.model.Reserva;
import api.model.Veiculo;
import api.servico.ContratoCaracteristicas;
import controller.AbrirContrato;
import core.dao.CategoriaDAO;
import core.dao.ContratoDAO;
import core.dao.ReservaDAO;
import core.dao.VeiculoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author visita
 */
public class ContratoServico implements ContratoCaracteristicas{

    @Override
    public boolean abrirContrato(Contrato contrato) {
        
        ContratoDAOCaracteristicas contratoDAOImpl;
        ReservaDAOCaracteristicas reservaDAOImpl;
        VeiculoDAOCaracteristicas veiculoDAOImpl;
        CategoriaDAOCaracteristicas categoriaDAOImpl;
        
        contratoDAOImpl = new ContratoDAO();
        reservaDAOImpl = new ReservaDAO();
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        
        boolean status = false;
        
        Reserva reservaDB = null;
        Operador operadorDB = null;
        Veiculo veiculoDB = null;
        Categoria categoriaDB = null;
        
        try {
            
            reservaDB = reservaDAOImpl.findById(contrato.getReserva().getId());
            veiculoDB = veiculoDAOImpl.findById(reservaDB.getVeiculo().getId());
           
            categoriaDB = categoriaDAOImpl.findById(veiculoDB.getCategoria().getId());
            
            contrato.setReserva(reservaDB);
            contrato.getReserva().setVeiculo(veiculoDB);
            contrato.getReserva().getVeiculo().setCategoria(categoriaDB);
            
            contrato.setReserva(reservaDB);
            
            contrato.setDataHoraRetirada(contrato.getReserva().getDataHoraInicio());
            contrato.setDataHoraDevolucao(null);
            
            contratoDAOImpl.insert(contrato);
            status = true;
        }
        catch (SQLException e){           
            status = false;
            System.out.println(e.toString());
        }
        
        return status;   
        
    }

    @Override
    public boolean fecharContrato(Contrato contrato){
        
        ReservaDAOCaracteristicas reservaDAOImpl;
        ContratoDAOCaracteristicas contratoDAOImpl;
        
        contratoDAOImpl = new ContratoDAO();
        reservaDAOImpl = new ReservaDAO();
        
        Contrato contratoDB = new Contrato();
        Reserva reservaDB = new Reserva();
        
        try {
            
            contratoDB = contratoDAOImpl.findById(contrato.getId());
            reservaDB = reservaDAOImpl.findById(contratoDB.getReserva().getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ContratoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        contratoDB.setDataHoraDevolucao(contrato.getDataHoraDevolucao());
        contratoDB.setDescricaoAcrescimo(contrato.getDescricaoAcrescimo());
        contratoDB.setReserva(reservaDB);
        
        int diasAcrescimo = Days.daysBetween(contratoDB.getReserva().getDataHoraTermino(), contratoDB.getDataHoraDevolucao()).getDays();
        
        if(diasAcrescimo > 0){
            contratoDB.setValorAcrescimo(diasAcrescimo * 500);
        }

        contratoDB.setValorTotalReserva(
                contratoDB.getValorAcrescimo() + 
                contratoDB.getReserva().getValorPrevisto()
        );
        
        try {
            contratoDAOImpl.update(contratoDB);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(ContratoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;

    }
}