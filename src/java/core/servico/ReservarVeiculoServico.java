/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.ReservaDAOCaracteristicas;
import api.model.Reserva;
import api.servico.ReservarVeiculosCaracacteristicas;
import core.dao.ReservaDAO;
import java.sql.SQLException;

/**
 *
 * @author visita
 */
public class ReservarVeiculoServico implements ReservarVeiculosCaracacteristicas{

    ReservaDAOCaracteristicas reservaDAOImpl;
    
    @Override
    public boolean cadastroVeiculo(Reserva reserva) {
        
        boolean status;
        
        reservaDAOImpl = new ReservaDAO();
        
        try {
            reservaDAOImpl.insert(reserva);
            status = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            status = false;
       
        }
        
        return status;
    
    }
    
}