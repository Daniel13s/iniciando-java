package BookKeepAPI;

import java.util.*;

public class BookService {
    private List<Book> livros = new ArrayList<Book>();
    private Map<String, Book> books = new HashMap<>();

    public void cadastrar(String isbn, Book book) {
        books.put(isbn, book);
    }
    public List<Book> listarTodos() {
        return this.livros;
    }
    public Optional buscarPorTitulo(String titulo) {
        return livros.stream().filter((Book livro) -> livro.getTitulo().equals(titulo)).findFirst();
    }
    public List<Book> listarPorStatus(StatusLivro status) {
        return livros.stream().filter((Book livro) -> livro.getStatus().equals(status)).toList();
    }
    public BookResponse converter(Book book) {
        return new BookResponse(book.getTitulo(), book.getAutor(), book.getStatus());
    }
    public List<BookResponse> listarResponses() {
        return livros.stream().map(this::converter).toList();
    }

    public Book buscarPorIsbn(String isbn) {
        Book livro = Optional.ofNullable(books.get(isbn)).orElseThrow(() -> new IllegalArgumentException("Livro nao encontrado"));

        return livro;
    }
}
