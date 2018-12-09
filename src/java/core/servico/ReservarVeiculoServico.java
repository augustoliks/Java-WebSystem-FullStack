/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.ClienteDAOCaracteristicas;
import api.dao.ContratoDAOCaracteristicas;
import api.dao.ReservaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Reserva;
import api.model.Veiculo;
import api.model.Categoria;
import api.model.Contrato;
import api.servico.ReservarVeiculosCaracacteristicas;
import core.dao.CategoriaDAO;
import core.dao.ContratoDAO;
import core.dao.ReservaDAO;
import core.dao.VeiculoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.joda.time.Days;

/**
 *
 * @author visita
 */
public class ReservarVeiculoServico implements ReservarVeiculosCaracacteristicas {

    CategoriaDAOCaracteristicas categoriaDAOImpl;

    @Override
    public boolean reservar(Reserva reserva) {

        VeiculoDAOCaracteristicas veiculoDAOImpl;
        ReservaDAOCaracteristicas reservaDAOImpl;

        boolean status;

        reservaDAOImpl = new ReservaDAO();
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();

        Veiculo veiculoDB = null;
        Categoria categoriaDB = null;

        try {
            veiculoDB = veiculoDAOImpl.findById(reserva.getVeiculo().getId());
            categoriaDB = categoriaDAOImpl.findById(veiculoDB.getCategoria().getId());
        } catch (SQLException ex) {
            Logger.getLogger(ReservarVeiculoServico.class.getName()).log(Level.SEVERE, null, ex);
        }

        float valor = Days.daysBetween(
                reserva.getDataHoraInicio(),
                reserva.getDataHoraTermino()
        ).getDays() * categoriaDB.getValor();

        reserva.setValorPrevisto(valor);

        try {
            reservaDAOImpl.insert(reserva);
            status = true;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            status = false;

        }

        return status;

    }

    @Override
    public boolean apagarRegistro(int idReserva) {

        boolean status = true;
        boolean flag = true;

        ContratoDAOCaracteristicas contratoDAOImpl;
        VeiculoDAOCaracteristicas veiculoDAOImpl;
        ReservaDAOCaracteristicas reservaDAOImpl;

        contratoDAOImpl = new ContratoDAO();
        reservaDAOImpl = new ReservaDAO();

        List<Contrato> contratosDB = null;

        Reserva reservaDB = new Reserva();

        try {
            contratosDB = contratoDAOImpl.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReservarVeiculoServico.class.getName()).log(Level.SEVERE, null, ex);
        }

 
        for (Contrato contrato : contratosDB) {
            if (contrato.getReserva().getId() == idReserva) {
                if (contrato.getDataHoraDevolucao() == null) {
                    flag = true;
                }
            }

        }

        if (flag) {
            try {
                reservaDAOImpl.deleteById(idReserva);
            } catch (SQLException ex) {
                System.out.println(ex.toString());
                status = false;
            }
        }

        return status;

    }

}
