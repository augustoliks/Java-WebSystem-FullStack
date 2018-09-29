/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.model;

import java.util.Date;

/**
 *
 * @author liks
 */
public class Reserva {

    private long idReserva;
    private Date dataHoraInicio;
    private Date dataHoraTermino;
    private Date valorPrevisto;    

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(Date dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
    }

    public Date getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(Date valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }
    
    
}
