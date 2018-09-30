/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.model.Reserva;

/**
 *
 * @author liks
 */
public interface ReservaDAOCaracteristicas {
    public boolean insert(Reserva reserva);
    public Reserva findById(Long id);
}
