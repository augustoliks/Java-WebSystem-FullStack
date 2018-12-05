/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.servico.PesquisarCarrosCaracteristicas;
import core.servico.PesquisarCarrosServico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisarVeiculosDisponiveis", urlPatterns = {"/PesquisarVeiculosDisponiveis"})
public class PesquisarVeiculosDisponiveis extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ServletContext sc = request.getServletContext();
        
        PesquisarCarrosCaracteristicas pesquisarCarrosImpl;
        pesquisarCarrosImpl = new PesquisarCarrosServico();
        
        String jsonListaCarros = pesquisarCarrosImpl.carrosDisponiveis();
            
        request.setAttribute("jsonListaCarrosDisponiveis", jsonListaCarros);

        sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);

    }
}

