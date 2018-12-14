/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.model;

import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author liks
 */
public class Reserva extends Identificador{

    private Cliente cliente;
    private Veiculo veiculo;
    private Reserva reserva;
    private DateTime dataHoraInicio;
    private DateTime dataHoraTermino;
    private float valorPrevisto;    
    
    public DateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(DateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public DateTime getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(DateTime dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
    }

    public float getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(float valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
}
