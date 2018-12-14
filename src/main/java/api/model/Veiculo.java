/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.model;

import java.lang.reflect.Constructor;


/**
 *
 * @author liks
 */
public class Veiculo extends Identificador {

    private String modelo;
    private int ano;
    private String fabricante;
    private String combustivel;
    private int kilometragem;
    private int estadoConservervacao;
    private String cor;
    private Categoria categoria;

    public Veiculo() {}
    
    public Veiculo(String modelo, int ano, String fabricante, String combustivel, int kilometragem, int estadoConservervacao, String cor, Categoria categoria) {
        this.setModelo(modelo);
        this.setAno(ano);
        this.setFabricante(fabricante);
        this.setCombustivel(combustivel);
        this.setKilometragem(kilometragem);
        this.setEstadoConservervacao(estadoConservervacao);
        this.setCor(cor);
        this.setCategoria(categoria);
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public int getEstadoConservervacao() {
        return estadoConservervacao;
    }

    public void setEstadoConservervacao(int estadoConservervacao) {
        this.estadoConservervacao = estadoConservervacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}