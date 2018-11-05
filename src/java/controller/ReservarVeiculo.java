/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.model.Cliente;
import api.model.Reserva;
import api.model.Veiculo;
import api.servico.ReservarVeiculosCaracacteristicas;
import core.servico.ReservarVeiculoServico;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author visita
 */
@WebServlet(name = "ReservarVeiculo", urlPatterns = {"/ReservarVeiculo"})
public class ReservarVeiculo extends HttpServlet {

    ReservarVeiculosCaracacteristicas reservarVeiculosImpl;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        reservarVeiculosImpl = new ReservarVeiculoServico();
        Reserva reserva = new Reserva();
        DateFormat f = DateFormat.getDateInstance();
        
        String dataHoraInicio = request.getParameter("date_ini");
        String dataHoraFim = request.getParameter("date_fim");
        float valorPrevisto = Float.valueOf(request.getParameter("valor_pre"));
        int idVeiculo = Integer.valueOf(request.getParameter("id_veiculo"));
        int idCliente = Integer.valueOf(request.getParameter("id_cliente"));

        Date dataHoraInicoFormatada = null;
        Date dataHoraFimFormatada = null;
        
        try { 
            dataHoraInicoFormatada = f.parse(dataHoraInicio);        
            dataHoraFimFormatada = f.parse(dataHoraFim);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        
        reserva.setDataHoraInicio(dataHoraInicoFormatada);
        reserva.setDataHoraTermino(dataHoraFimFormatada);
        reserva.setValorPrevisto(valorPrevisto);
    
        reserva.setCliente(new Cliente());
        reserva.setVeiculo(new Veiculo());
        
        reserva.getCliente().setId(idCliente);
        reserva.getVeiculo().setId(idVeiculo);
        
        boolean statusCadastro = reservarVeiculosImpl.cadastroVeiculo(reserva);
/*
        if (statusCadastro){
            request.setAttribute("statusCadastro", statusCadastro);
        }
        else{
            request.setAttribute("statusCadastro", statusCadastro);
            System.out.println("ERRO DE CADASTRO");
        }
  */      
    }

}
