package bookKeep;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Book coraline = new Book(1, "Coraline", "suspense");
        Book diarioBanana = new Book(2, "Diario de um banana", "comedia");

        Book bookNull = new Book(5,"Null", "Null");

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarBook(coraline);
        biblioteca.adicionarBook(diarioBanana);

        biblioteca.getBook(1).orElseThrow();
    }
}
