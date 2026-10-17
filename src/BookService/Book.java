package BookService;

import BookKeepAPI.StatusLivro;

import java.util.Optional;

public class Book {
    private final String isbn;
    private String titulo;
    private String autor;
    private StatusLivro status;

    public Book(String titulo, String autor, String isbn, StatusLivro status) {
        if(titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo nao preenchido");
        }
        if(autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor nao preenchido");
        }
        if(isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN nao preenchido");
        }
        if(status == null) {
            throw new IllegalArgumentException("Status nao pode ser nulo");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.status = status;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public StatusLivro getStatus() {
        return this.status;
    }
    public String getIsbn() {
        return this.isbn;
    }

    public void alterarTitulo(String novoTitulo) {
        if(novoTitulo == null || novoTitulo.isBlank()) {
            throw new IllegalArgumentException("Novo titulo e invalido");
        }
        this.titulo = novoTitulo;
    }
    public void alterarAutor(String novoAutor) {
        if(novoAutor == null || novoAutor.isBlank()) {
            throw new IllegalArgumentException("Novo autor e invalido");
        }
        this.autor = novoAutor;
    }
    public void alterarStatus(StatusLivro novoStatus) {
        if(novoStatus == null) {
            throw new IllegalArgumentException("Status invalido");
        }
        this.status = novoStatus;
    }
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
