/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Operador;
import api.model.Veiculo;

/**
 *
 * @author liks
 */
public interface VeiculoDAOCaracteristicas {    
    public boolean insert(Veiculo veiculo);
    public Veiculo findById(Long id);
    public Veiculo findByNomeCliente(String nomeVeiculo);
    public Veiculo findByName(String name);
}
    