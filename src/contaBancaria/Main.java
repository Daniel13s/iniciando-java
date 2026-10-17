package contaBancaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        ContaBancaria daniel = new ContaBancaria("Daniel", "1234-5");
        ContaBancaria maria = new ContaBancaria("Maria", "2345-6");
        ContaBancaria joao = new ContaCorrente("Joao", "3456-7");

        daniel.depositar(500);
        maria.depositar(1200);
        joao.depositar(300);

        contas.add(daniel);
        contas.add(maria);
        contas.add(joao);

        contas.stream()
                .map(ContaBancaria::getSaldo)
                .forEach(System.out::println);

    }
}
