package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    private String codigo;
    private String cliente;
    private double valor;

    protected Pedido() {

    }
    public Pedido(String codigo, String cliente, double valor) {
        if(codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código não pode ser nulo nem vazio.");
        }
        if(cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente não pode ser nulo nem vazio.");
        }
        if(valor < 0) {
            throw new IllegalArgumentException("Valor nao pode ser negativo.");
        }

        this.codigo = codigo;
        this.cliente = cliente;
        this.valor = valor;
    }

    public String getCodigo() {
        return this.codigo;
    }
    public String getCliente() {
        return this.cliente;
    }
    public double getValor() {
        return this.valor;
    }

    public void atualizarValor(double novoValor) {
        if( novoValor < 0 ) {
            throw new IllegalArgumentException("Valor nao pode ser menor que 0.");
        }

        this.valor = novoValor;
    }
}
