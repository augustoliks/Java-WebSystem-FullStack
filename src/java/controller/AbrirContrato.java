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
import javax.servlet.http.HttpSession;


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
        String Rg = null;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        ServletContext sc = request.getServletContext();
           
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("Rg") != null){
            Rg = String.valueOf(session.getAttribute("Rg"));

            int idReserva = Integer.valueOf(request.getParameter("id_reserva"));
            int idOperador = Integer.valueOf(Rg);

            float valorPagoAntecipadamente = Float.valueOf(request.getParameter("valor_pag_ant"));

            contrato.setReserva(new Reserva());
            contrato.getReserva().setId(idReserva);

            contrato.setOperador(new Operador());
            contrato.getOperador().setId(idOperador);


            contrato.setValorPagoAntecipadamente(valorPagoAntecipadamente);

            contratoImpl.abrirContrato(contrato);
            
            try {
                request.setAttribute("status_abrir_contrato", 1);
                sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            }catch(Exception e){ 
                System.out.println("erro" + e);
                request.setAttribute("status_abrir_contrato_err", 1);
                sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            }
            

        }else{
            
            System.out.print("Voce deve estar logado para reservar um veiculo!");
            
            request.setAttribute("status_abrir_contrato_err", 1);
            sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            
            System.out.println("rg da session ============ " + Rg);
            
        }
    }
}
