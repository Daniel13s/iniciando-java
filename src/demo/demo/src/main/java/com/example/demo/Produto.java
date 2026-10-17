package com.example.demo;

public class Produto {
    private final String codigo;
    private String nome;
    private double preco;
    public Produto(String codigo, String nome, double preco) {
        if(codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo invalido.");
        }
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome invalido.");
        }
        if(preco < 0) {
            throw new IllegalArgumentException("Preco invalido.");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCodigo() {
        return this.codigo;
    }
    public double getPreco() {
        return this.preco;
    }
}
