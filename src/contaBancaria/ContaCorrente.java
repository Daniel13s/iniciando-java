package contaBancaria;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String titular, String numeroConta) {
        super(titular, numeroConta);
    }
    public void cobrarTarifaMensal() {
        sacar(20);
    }
}
