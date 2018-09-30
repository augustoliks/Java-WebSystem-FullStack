/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Cliente;

/**
 *
 * @author liks
 */
public interface ClienteDAOCaracteristicas {
    public boolean insert(Cliente cliente);
    public Cliente findById(Long id);
    public Cliente findByNomeCliente(String nomeCliente);
    public Cliente findByName(String name);
}
