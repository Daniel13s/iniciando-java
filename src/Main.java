public class Main {
    public static void main(String[] args) {
        int firstNum = 20;
        int secondNum = 0;

        int soma = somar(firstNum, secondNum);
        int subtracao = subtrair(firstNum, secondNum);
        int multiplicacao = multiplicar(firstNum, secondNum);
        int divisao = dividir(firstNum, secondNum);

        System.out.println("Soma: " + soma);
        System.out.println("Subtracao: " + subtracao);
        System.out.println("Multiplicacao: " + multiplicacao);
        System.out.println("Divisao: " + divisao);
    }
    public static int subtrair(int a, int b) {
        return a - b;
    }
    public static int somar(int a, int b) {
        return a + b;
    }
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisao por 0");
        }

        return a / b;
    }
}