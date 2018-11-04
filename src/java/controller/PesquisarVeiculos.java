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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisarVeiculos", urlPatterns = {"/PesquisarVeiculos"})
public class PesquisarVeiculos extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String categoria = request.getParameter("categoria");
        
        PesquisarCarrosCaracteristicas pesquisarCarrosImpl;
        pesquisarCarrosImpl = new PesquisarCarrosServico();
        
        String jsonListaCarros = pesquisarCarrosImpl.pesquisarCarros(categoria);  
            
            
     try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + jsonListaCarros + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }            
    }
    
    


}
