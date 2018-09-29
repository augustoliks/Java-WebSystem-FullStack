/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.*;
import java.util.List;

/**
 *
 * @author liks
 */
public interface ReservaDAOCaracteristicas {
    public boolean insert(Reserva reserva);
    public Reserva findById(Long id);
    public Reserva findByNomeCliente(String nomeCliente);
    public Reserva findByName(String name);
    public List<Cliente> findAll();
    public Cliente update(Cliente clienteAntes, Cliente clienteAtual);
    public boolean delete(Cliente cliente);
}