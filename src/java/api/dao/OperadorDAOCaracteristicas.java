/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Operador;

/**
 *
 * @author liks
 */
public interface OperadorDAOCaracteristicas {
    public boolean insert(Operador operador);
    public Operador findById(Long id);
    public Operador findByNomeCliente(String nomeCliente);
    public Operador findByName(String name);
}
