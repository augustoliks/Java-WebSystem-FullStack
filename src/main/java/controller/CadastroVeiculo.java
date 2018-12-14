/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import api.model.Veiculo;
import api.servico.CadastroVeiculoCaracteristicas;
import core.dao.VeiculoDAO;
import core.servico.CadastroVeiculoServico;
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
 * @author liks
 */
@WebServlet(name = "CadastroVeiculo", urlPatterns = {"/CadastroVeiculo"})
public class CadastroVeiculo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        CadastroVeiculoCaracteristicas cadVeiculosServicoImpl;
        cadVeiculosServicoImpl = new CadastroVeiculoServico();
   
        Veiculo veiculo = new Veiculo();
        
        boolean status = false;

        ServletContext sc = request.getServletContext();

        int ano = Integer.valueOf(request.getParameter("ano"));
        String placa = request.getParameter("placa");
        String modelo = request.getParameter("modelo");
        String fabricante = request.getParameter("fabricante");
        String cor = request.getParameter("cor");
        int kilometragem = Integer.parseInt(request.getParameter("kilometragem"));
        int conservacao = Integer.valueOf(request.getParameter("conservacao"));
        String combustivel = request.getParameter("combustivel");
        String categoria = request.getParameter("categoria");

        veiculo.setAno(ano);
        veiculo.setCombustivel(combustivel);
        veiculo.setCor(cor);
        veiculo.setEstadoConservervacao(conservacao);
        veiculo.setFabricante(fabricante);
        veiculo.setId(ano);
        veiculo.setKilometragem(kilometragem);
        veiculo.setModelo(modelo);

        veiculo.setCategoria(new Categoria());
        veiculo.getCategoria().setNome(categoria);

        status = cadVeiculosServicoImpl.insercao(veiculo);

        try {
            request.setAttribute("status_cadastro_veiculo", 1);
            sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
        }catch(Exception e){ 
            System.out.println("erro" + e);
            request.setAttribute("status_cadastro_veiculo_err", 1);
            sc.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
        }

    }
}
