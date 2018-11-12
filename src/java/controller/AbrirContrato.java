/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.model.Cliente;
import api.servico.ContratoCaracteristicas;

import api.model.Contrato;
import api.model.Operador;
import api.model.Reserva;
import core.servico.ContratoServico;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author visita
 */
@WebServlet(name = "AbrirContrato", urlPatterns = {"/AbrirContrato"})
public class AbrirContrato extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ContratoCaracteristicas contratoImpl;
        contratoImpl = new ContratoServico();
        
        Contrato contrato = new Contrato();
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        ServletContext sc = request.getServletContext();

        int idReserva = Integer.valueOf(request.getParameter("id_reserva"));
        int idOperador = Integer.valueOf(request.getParameter("id_operador"));
       
        float valorPagoAntecipadamente = Float.valueOf(request.getParameter("valor_pag_ant"));
       
        contrato.setReserva(new Reserva());
        contrato.getReserva().setId(idReserva);
        
        contrato.setOperador(new Operador());
        contrato.getOperador().setId(idOperador);
        
        
        contrato.setValorPagoAntecipadamente(valorPagoAntecipadamente);
        
        contratoImpl.abrirContrato(contrato);
    }
}