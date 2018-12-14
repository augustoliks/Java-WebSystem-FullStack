
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.model.Cliente;
import api.model.Operador;
import api.model.Pessoa;
import api.servico.LoginCaracteristicas;
import api.servico.PesquisarCarrosCaracteristicas;
import core.servico.LoginServico;
import core.servico.PesquisarCarrosServico;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author gabri
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(">>>\tErro no encode de caracter (Login.class)");
        }

        ServletContext sc = request.getServletContext();

        String nomeUsuario = request.getParameter("usuario");
        String senhaUsuario = request.getParameter("senha");

        LoginCaracteristicas loginServico = new LoginServico();

        Pessoa pessoaBD = loginServico.findByNomeUsuario(nomeUsuario);

        if (pessoaBD != null && pessoaBD.getSenha().equals(senhaUsuario)) {
               
            //CRIANDO SESSION 
            HttpSession session = request.getSession();
            session.setAttribute("Rg", pessoaBD.getId());
            
            if (pessoaBD instanceof Cliente) {
                
                request.setAttribute("nome", pessoaBD.getNome());
                sc.getRequestDispatcher("/jsp/user.jsp").forward(request, response);
                
            } else if (pessoaBD instanceof Operador) {
                
                
                // CARROS DISPONIVEIS
                PesquisarCarrosCaracteristicas pesquisarCarrosImpl;
                pesquisarCarrosImpl = new PesquisarCarrosServico();

                String jsonListaCarrosD = pesquisarCarrosImpl.carrosDisponiveis();
                request.setAttribute("jsonListaCarrosDisponiveis", jsonListaCarrosD);
                
                // CARROS NAO DISPONIVEIS
                String jsonListaCarrosND = pesquisarCarrosImpl.carrosNaoDisponiveis();

                request.setAttribute("jsonListaCarrosNaoDisponiveis", jsonListaCarrosND);
                sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            }
            
        } else {
            request.setAttribute("falhaAutenticacao", true);
            sc.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }

    }

}