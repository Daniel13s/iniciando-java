package BookKeepAPI;

public class Main {
    public static void main(String[] args) {
        BookService livros = new BookService();
        Book livro1 = new Book(
                "Alister Vance",
                "Robert Martin",
                "978-85-7522-814-2",
                StatusLivro.LIDO
        );

        Book livro2 = new Book(
                "Clean Code",
                "Robert Martin",
                "978-0132350884",
                StatusLivro.LENDO
        );

        Book livro3 = new Book(
                "Sophie Laurent",
                "Robert Martin",
                "978-3-16-148410-0",
                StatusLivro.LENDO
        );

        livros.cadastrar("978-85-7522-814-2", livro1);
        livros.cadastrar("978-0132350884", livro2);
        livros.cadastrar("978-3-16-148410-0", livro3);

        System.out.println(livros.buscarPorIsbn("978-0132350884").toString());
        System.out.println(livros.buscarPorIsbn("askjdkajskdj"));
    }
}
