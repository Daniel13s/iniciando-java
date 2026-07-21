package Caixa;

import contaBancaria.ContaBancaria;

public class Main {
    public static void main(String[] args) {
        Caixa<String> caixaTexto = new Caixa<String>();

        caixaTexto.guardar("Daniel");
        System.out.println(caixaTexto.pegar());

        Caixa<ContaBancaria> caixaConta = new Caixa<ContaBancaria>();

        caixaConta.guardar(new ContaBancaria("Daniel", "12345-6"));

        System.out.println(caixaConta.pegar().getTitular() + " - " + caixaConta.pegar().getSaldo());
    }
}
