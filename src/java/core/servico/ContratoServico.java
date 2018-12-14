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
    public boolean fecharContrato(Contrato contrato, int kilometragemPercorrida, int estadoConservacao){
        
        ReservaDAOCaracteristicas reservaDAOImpl;
        ContratoDAOCaracteristicas contratoDAOImpl;
        VeiculoDAOCaracteristicas veiculoDAOImpl;
        
        contratoDAOImpl = new ContratoDAO();
        reservaDAOImpl = new ReservaDAO();
        veiculoDAOImpl = new VeiculoDAO();
        
        Contrato contratoDB = new Contrato();
        Reserva reservaDB = new Reserva();
        Veiculo veiculoDB = new Veiculo();
        
        String descricaoAcrescimo = "";
        
        boolean statusOperacao = true;
        
        
        try {
            contratoDB = contratoDAOImpl.findById(contrato.getId());
            reservaDB = reservaDAOImpl.findById(contratoDB.getReserva().getId());
            veiculoDB = veiculoDAOImpl.findById(reservaDB.getVeiculo().getId());
        } catch (SQLException ex) {
            Logger.getLogger(ContratoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Multa de KM percorrido
        veiculoDB.setKilometragem(
                veiculoDB.getKilometragem() +
                kilometragemPercorrida
        );
        
        float acrescimoKMPercorrido = (kilometragemPercorrida/100)*10;
        descricaoAcrescimo += " KM percorrido: "+String.valueOf(kilometragemPercorrida);
        descricaoAcrescimo += ", Acrescimo: "+String.valueOf(acrescimoKMPercorrido);
        
        contratoDB.setValorAcrescimo(contratoDB.getValorAcrescimo()+acrescimoKMPercorrido);
        
        //Multa de KM Data excedida
        contratoDB.setDataHoraDevolucao(contrato.getDataHoraDevolucao());
        contratoDB.setDescricaoAcrescimo(contrato.getDescricaoAcrescimo());
        contratoDB.setReserva(reservaDB);
        
        int diasAtraso = Days.daysBetween(contratoDB.getReserva().getDataHoraTermino(), contratoDB.getDataHoraDevolucao()).getDays();

        if(diasAtraso > 0){
            float acrescimoAtrasoEntrega = diasAtraso * 100;
            contratoDB.setValorAcrescimo(contratoDB.getValorAcrescimo()+acrescimoAtrasoEntrega);            
            descricaoAcrescimo += ", Atraso de : "+String.valueOf(diasAtraso)+" dias";
            descricaoAcrescimo += ", Acrescimo: "+String.valueOf(acrescimoAtrasoEntrega);
        }
        
        //Multa estado conservacao
        if(estadoConservacao > 0){
            int estadoConservacaoAtual = veiculoDB.getEstadoConservervacao()-estadoConservacao;
            float acrescimoEstadoConservacao = estadoConservacaoAtual * 50;
            contratoDB.setValorAcrescimo(contratoDB.getValorAcrescimo()+acrescimoEstadoConservacao);            
            descricaoAcrescimo += ", O carro teve uma reducao de estado de conservacao de : "+String.valueOf(estadoConservacao)+" nivel";
            descricaoAcrescimo += ", Acrescimo: "+String.valueOf(acrescimoEstadoConservacao);
            veiculoDB.setEstadoConservervacao(estadoConservacaoAtual);
        }
        
        contratoDB.setDescricaoAcrescimo(descricaoAcrescimo);
        
        try {
            contratoDAOImpl.update(contratoDB);
            veiculoDAOImpl.update(veiculoDB);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(ContratoServico.class.getName()).log(Level.SEVERE, null, ex);
            statusOperacao = false;
        }
        
        return statusOperacao;

    }

}
