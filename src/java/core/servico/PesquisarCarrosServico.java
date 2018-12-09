/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.CategoriaDAOCaracteristicas;
import api.dao.ContratoDAOCaracteristicas;
import api.dao.ReservaDAOCaracteristicas;
import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import api.model.Contrato;
import api.model.Reserva;
import core.dao.VeiculoDAO;
import java.util.List;
import api.servico.PesquisarCarrosCaracteristicas;
import core.dao.CategoriaDAO;
import java.sql.SQLException;
import api.model.Veiculo;
import com.google.gson.Gson;
import core.dao.ContratoDAO;
import core.dao.ReservaDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visita
 */
public class PesquisarCarrosServico implements PesquisarCarrosCaracteristicas {

    VeiculoDAOCaracteristicas veiculoDAOImpl;
    CategoriaDAOCaracteristicas categoriaDAOImpl;
    ReservaDAOCaracteristicas reservaDAOImpl;

    @Override
    public String pesquisarCarros(String nomeCategoria) {

        ContratoDAOCaracteristicas contratosDAOImpl;
        contratosDAOImpl = new ContratoDAO();
        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();

        Categoria categoria = null;
        List<Veiculo> veiculos = null;
        List<Contrato> contratos = null;

        try {
            categoria = categoriaDAOImpl.findByName(nomeCategoria);
            veiculos = veiculoDAOImpl.findCarsByCategoria(categoria.getId());
            contratos = contratosDAOImpl.findAll();

        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }

        Reserva reservaBD = null;
        Veiculo veiculoBD = null;
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            for (Contrato contrato : contratos) {
                System.out.println(contrato.getDataHoraDevolucao());
                if (contrato.getDataHoraDevolucao() != null) {
                    try {
                        reservaBD = reservaDAOImpl.findById(contrato.getReserva().getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(PesquisarCarrosServico.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (reservaBD.getVeiculo().getId() == veiculo.getId()) {
                        veiculosDisponiveis.add(veiculo);
                    }
                }
            }
        }

        String jsonCarros = new Gson().toJson(veiculosDisponiveis);

        return jsonCarros;
    }

    @Override
    public String carrosNaoDisponiveis() {

        ContratoDAOCaracteristicas contratosDAOImpl;

        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();
        contratosDAOImpl = new ContratoDAO();

        List<Contrato> contratos = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();

        try {
            contratos = contratosDAOImpl.findAll();
            veiculos = veiculoDAOImpl.findAll();
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }

        Reserva reservaBD = null;
        Veiculo veiculoBD = null;
        List<Veiculo> veiculosNaoDisponiveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            for (Contrato contrato : contratos) {
                System.out.println(contrato.getDataHoraDevolucao());
                if (contrato.getDataHoraDevolucao() != null) {
                    try {
                        reservaBD = reservaDAOImpl.findById(contrato.getReserva().getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(PesquisarCarrosServico.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (reservaBD.getVeiculo().getId() == veiculo.getId()) {
                        veiculosNaoDisponiveis.add(veiculo);
                    }
                }
            }
        }

        String jsonCarros = new Gson().toJson(veiculosNaoDisponiveis);

        return jsonCarros;

    }

    @Override
    public String carrosDisponiveis() {

        ContratoDAOCaracteristicas contratosDAOImpl;

        veiculoDAOImpl = new VeiculoDAO();
        categoriaDAOImpl = new CategoriaDAO();
        reservaDAOImpl = new ReservaDAO();
        contratosDAOImpl = new ContratoDAO();

        List<Contrato> contratos = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        
        try {
            contratos = contratosDAOImpl.findAll();
            veiculos = veiculoDAOImpl.findAll();
        } catch (SQLException ex) {
            System.out.println();
            System.out.println(ex.toString());
        }

        Reserva reservaBD = null;
        Veiculo veiculoBD = null;
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            for (Contrato contrato : contratos) {
                System.out.println(contrato.getDataHoraDevolucao());
                if (contrato.getDataHoraDevolucao() != null) {
                    try {
                        reservaBD = reservaDAOImpl.findById(contrato.getReserva().getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(PesquisarCarrosServico.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (reservaBD.getVeiculo().getId() == veiculo.getId()) {
                        veiculosDisponiveis.add(veiculo);
                    }
                }
            }
        }

        String jsonCarros = new Gson().toJson(veiculosDisponiveis);

        return jsonCarros;
    }

}
