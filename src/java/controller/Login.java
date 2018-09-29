/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
            
            ServletContext sc = request.getServletContext();
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
//            Usuario user = new Usuario(nome, rg, cpf, endereco, email, senha);

            request.setAttribute("nome", nome);
            
            if(nome.equals("carlos") && senha.equals("carlos")){
                sc.getRequestDispatcher("/jsp/user.jsp").forward(request, response);
            }
            else if(nome.equals("admin") && senha.equals("admin")) {
                sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            }
            else{
                request.setAttribute("erroLogin", true);
                sc.getRequestDispatcher("/jsp/user.jsp").forward(request, response);

            }
            
        }catch(Exception e){System.out.print(e);}
    }

}
