/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.model;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author liks
 */
public class Contrato extends Identificador{
    
    private String DescricaoAcrescimo;

    private float valorAcrescimo;
    private float valorPagoAntecipadamente;
    private float valorTotalReserva;

    private DateTime dataHoraRetirada;
    private DateTime dataHoraDevolucao;

    private Reserva reserva;
    private Operador operador;

    /**
     * @return the DescricaoAcrescimo
     */
    public String getDescricaoAcrescimo() {
        return DescricaoAcrescimo;
    }

    /**
     * @param DescricaoAcrescimo the DescricaoAcrescimo to set
     */
    public void setDescricaoAcrescimo(String DescricaoAcrescimo) {
        this.DescricaoAcrescimo = DescricaoAcrescimo;
    }

    /**
     * @return the valorAcrescimo
     */
    public float getValorAcrescimo() {
        return valorAcrescimo;
    }

    /**
     * @param valorAcrescimo the valorAcrescimo to set
     */
    public void setValorAcrescimo(float valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    /**
     * @return the valorPagoAntecipadamente
     */
    public float getValorPagoAntecipadamente() {
        return valorPagoAntecipadamente;
    }

    /**
     * @param valorPagoAntecipadamente the valorPagoAntecipadamente to set
     */
    public void setValorPagoAntecipadamente(float valorPagoAntecipadamente) {
        this.valorPagoAntecipadamente = valorPagoAntecipadamente;
    }

    /**
     * @return the valorTotalReserva
     */
    public float getValorTotalReserva() {

        return valorTotalReserva;
    }

    /**
     * @param valorTotalReserva the valorTotalReserva to set
     */
    public void setValorTotalReserva(float valorTotalReserva) {
        this.valorTotalReserva = valorTotalReserva;
    }

    /**
     * @return the dataHoraRetirada
     */
    public DateTime getDataHoraRetirada() {
        return dataHoraRetirada;
    }

    /**
     * @param dataHoraRetirada the dataHoraRetirada to set
     */
    public void setDataHoraRetirada(DateTime dataHoraRetirada) {
        this.dataHoraRetirada = dataHoraRetirada;
    }

    /**
     * @return the dataHoraDevolucao
     */
    public DateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    /**
     * @param dataHoraDevolucao the dataHoraDevolucao to set
     */
    public void setDataHoraDevolucao(DateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * @return the operador
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(Operador operador) {
        this.operador = operador;
    }
}
