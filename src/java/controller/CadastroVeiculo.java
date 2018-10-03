/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Veiculo;
import core.dao.VeiculoDAO;
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

    VeiculoDAOCaracteristicas veiculoDAO = new VeiculoDAO();
    Veiculo veiculo = new Veiculo();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("carlosdgfdngafjsdngkafnjgakfjgafknjgkagn");
        ServletContext sc = request.getServletContext();

        int ano = Integer.valueOf(request.getParameter("ano"));
        String placa = request.getParameter("placa");
        String modelo = request.getParameter("modelo");
        String fabricante = request.getParameter("fabricante");
        String cor = request.getParameter("cor");
        int kilometragem = Integer.valueOf(request.getParameter("kilometragem"));
        String conservacao = request.getParameter("conservacao");
        String combustivel = request.getParameter("combustivel");
        String categoria = "Esportivo";//request.getParameter("categoria");

        veiculo.setAno(ano);
        veiculo.setCategoria(categoria);        
        veiculo.setCombustivel(combustivel);
        veiculo.setCor(cor);
        veiculo.setEstadoConservervacao(conservacao);
        veiculo.setFabricante(fabricante);
        veiculo.setIdVeiculo(ano);
        veiculo.setKilometragem(kilometragem);
        veiculo.setModelo(modelo);
        
        boolean statusCadastro = veiculoDAO.insert(veiculo);
        
        if (statusCadastro){
            request.setAttribute("statusCadastro", statusCadastro);
        }
        else{
            request.setAttribute("statusCadastro", statusCadastro);
            System.out.println("ERRO DE CADASTRO");
        }
        
    }
}
