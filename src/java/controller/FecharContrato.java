/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.model.Contrato;
import api.model.Operador;
import api.model.Reserva;
import api.servico.ContratoCaracteristicas;
import core.servico.ContratoServico;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author visita
 */
@WebServlet(name = "FecharContrato", urlPatterns = {"/FecharContrato"})
public class FecharContrato extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        ContratoCaracteristicas contratoImpl;
        
        contratoImpl = new ContratoServico();
        Contrato contrato = new Contrato();
        
        int idContrato = Integer.valueOf(request.getParameter("id_contrato"));
        int kilometragemPercorrida = Integer.valueOf(request.getParameter("kilometragem_percorrida"));
        int estadoConservacao = Integer.valueOf(request.getParameter("estadoConservacao"));
        
        String dataHoraDevolucao = request.getParameter("data_devolucao");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        
        DateTime dataHoraDevolucaoFormatada = formatter.parseDateTime(dataHoraDevolucao);        

        contrato.setDataHoraDevolucao(dataHoraDevolucaoFormatada);
        contrato.setId(idContrato);
        
        boolean status = contratoImpl.fecharContrato(contrato, kilometragemPercorrida, estadoConservacao);
               
    }

}
