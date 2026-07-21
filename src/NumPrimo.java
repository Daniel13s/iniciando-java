public class NumPrimo {
    public static void main(String[] args) {
        int numero = 25;

        boolean primo = true;

        for (int i = 1;i < numero && primo; i++) {
            if (numero % i == 0) {
                if (i != 1 && i != numero) {
                    primo = false;
                    break;
                }
            }
        }

        System.out.println(primo ? numero + " e um numero primo" : numero + " nao e um numero primo");
    }
}
