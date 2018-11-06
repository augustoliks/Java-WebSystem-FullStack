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
import controller.GerarContrato;
import core.dao.CategoriaDAO;
import core.dao.ContratoDAO;
import core.dao.ReservaDAO;
import core.dao.VeiculoDAO;
import java.sql.SQLException;
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
            
            contrato.getValorTotalReserva();
            
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
    public boolean fecharContrato(Contrato contrato, DateTime dataDevulacao, String descricao) throws SQLException {
        
        ReservaDAOCaracteristicas reservaDAOImpl;
        ContratoDAOCaracteristicas contratoDAOImpl;
        
        contratoDAOImpl = new ContratoDAO();
        reservaDAOImpl = new ReservaDAO();
        
        Contrato contratoDB = new Contrato();
        Reserva reservaDB = new Reserva();
        
        contratoDB = contratoDAOImpl.findById(contrato.getId());
        reservaDB = reservaDAOImpl.findById(contrato.getReserva().getId());
        
        contrato.setReserva(reservaDB);        
        contrato.setDataHoraDevolucao(dataDevulacao);
        contrato.setDescricaoAcrescimo(descricao);
        
        int dias = Days.daysBetween(contrato.getReserva().getDataHoraTermino(), contrato.getDataHoraDevolucao()).getDays();
        
        if(dias > 0){
            contrato.setValorAcrescimo(dias * 500);
        }
               
        contratoDAOImpl.update(contrato);

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
