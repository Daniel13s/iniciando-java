package contaBancaria;

public class ContaBancaria {
    protected String titular;
    protected String numeroConta;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }
    public void depositar (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor precisa ser maior que 0");
        }

        this.saldo += valor;
    }
    public void sacar (double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo nao suficiente!");
        } else if(valor <= 0) {
            throw new IllegalArgumentException("O valor precisa ser maior que 0");
        }

        this.saldo -= valor;
    }
    public double consultarSaldo () {
        return this.saldo;
    }
    public String getTitular () {
        return this.titular;
    }
    public String getNumeroConta () {
        return this.numeroConta;
    }
    public double getSaldo () { return this.saldo; }
}
