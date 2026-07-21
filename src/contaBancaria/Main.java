package contaBancaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ContaBancaria> contas = new HashMap<>();
        ContaBancaria daniel = new ContaBancaria("Daniel", "1234-5");
        ContaBancaria maria = new ContaBancaria("Maria", "2345-6");
        ContaBancaria joao = new ContaCorrente("Joao", "3456-7");

        daniel.depositar(500);
        maria.depositar(1200);
        joao.depositar(300);

        contas.put(daniel.numeroConta, daniel);
        contas.put(maria.numeroConta, maria);
        contas.put(joao.numeroConta, joao);

        System.out.println(contas.get("1234-5").getTitular());
    }
}
