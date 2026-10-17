package BookService;

import BookKeepAPI.StatusLivro;

import java.util.*;

import static BookKeepAPI.StatusLivro.*;

public class BookService {
    private List<Book> livros = new ArrayList<>();
    private Map<String, Book> livrosPorIsbn = new HashMap<>();

    public void cadastrar(Book book) {
        if(livrosPorIsbn.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN existente!");
        }
        livros.add(book);
        livrosPorIsbn.put(book.getIsbn(), book);
        livrosPorIsbn.put(book.getIsbn(), book);
    }
    public Book buscarPorIsbn(String isbn) {
        return Optional.ofNullable(livrosPorIsbn.get(isbn)).orElseThrow(() -> new IllegalArgumentException("ISBN nao encontrado na lista!"));
    }
    public Book buscarPorTitulo(String titulo) {
        return livros.stream().filter(book -> book.getTitulo().equals(titulo)).findFirst().orElseThrow(() -> new IllegalArgumentException("Livro nao existente!"));
    }
    public List<Book> buscarPorStatus(StatusLivro status) {
        return livros.stream().filter(book -> book.getStatus().equals(status)).toList();
    }
    public void removerPorIsbn(String isbn) {
        Book livro = buscarPorIsbn(isbn);

        livros.remove(livro);
        livrosPorIsbn.remove(isbn);
    }
    public List<Book> ordenarPorTitulo() {
        return livros.stream().sorted(Comparator.comparing(Book::getTitulo)).toList();
    }
    public List<Book> ordenarPorAutor() {
        return livros.stream().sorted(Comparator.comparing(Book::getAutor)).toList();
    }
    public List<Book> listarPorStatusOrdenadoPorTitulo(StatusLivro status) {
        return livros.stream().filter(book -> book.getStatus().equals(status)).sorted(Comparator.comparing(Book::getTitulo)).toList();
    }
    public List<Book> ordenarPorStatusETitulo() {
        return livros.stream().sorted(Comparator
                .comparingInt((Book book) -> switch (book.getStatus()) { case QUERO_LER -> 0; case LENDO -> 1; case LIDO -> 2; case ABANDONADO -> 3;})
                .thenComparing(Book :: getTitulo)).toList();
    }
    public List<Book> listarOrdenadosPorAutorETitulo() {
        return livros.stream().sorted(Comparator.comparing(Book::getAutor).thenComparing(Book::getTitulo)).toList();
    }
    public void atualizarStatus(String isbn, StatusLivro novoStatus) {
        Book livro = Optional.ofNullable(livrosPorIsbn.get(isbn)).orElseThrow(() -> new IllegalArgumentException("Livro nao existente!"));

        livro.alterarStatus(novoStatus);
    }
    public void atualizarTitulo(String isbn, String novoTitulo) {
        Book livro = Optional.ofNullable(livrosPorIsbn.get(isbn)).orElseThrow(() -> new IllegalArgumentException("Livro nao encontrado:" + isbn));

        livro.alterarTitulo(novoTitulo);
    }
}
