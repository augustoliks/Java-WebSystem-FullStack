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
public class Contratro extends Identificador{
    
    private String DescricaoAcrescimo;

    private Double valorAcrescimo;
    private Double valorPagoAntecipadamente;
    private Double valorTotalReserva;

    private Date dataHoraRetirada;
    private Date dataHoraDevolucao;

    private Reserva reserva;
    private Operador operador;
    
    public String getDescricaoAcrescimo() {
        return DescricaoAcrescimo;
    }

    public void setDescricaoAcrescimo(String DescricaoAcrescimo) {
        this.DescricaoAcrescimo = DescricaoAcrescimo;
    }

    public Double getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(Double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public Double getValorPagoAntecipadamente() {
        return valorPagoAntecipadamente;
    }

    public void setValorPagoAntecipadamente(Double valorPagoAntecipadamente) {
        this.valorPagoAntecipadamente = valorPagoAntecipadamente;
    }

    public Double getValorTotalReserva() {
        return valorTotalReserva;
    }

    public void setValorTotalReserva(Double valorTotalReserva) {
        this.valorTotalReserva = valorTotalReserva;
    }

    public Date getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Date dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public Date getDataHoraRetirada() {
        return dataHoraRetirada;
    }

    public void setDataHoraRetirada(Date dataHoraRetirada) {
        this.dataHoraRetirada = dataHoraRetirada;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Double getValorFinal() {
        return this.valorAcrescimo + this.valorTotalReserva - valorPagoAntecipadamente;
    }

}
