package contaBancaria;

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String titular, String numeroConta) {
        super(titular, numeroConta);
    }
    public void renderJuros() {
        double saldo = getSaldo();
        double juros = saldo / 20;

        depositar(juros);
    }
}
