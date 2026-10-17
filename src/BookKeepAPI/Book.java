package BookKeepAPI;

import java.util.Objects;

public class Book {
    private String titulo;
    private String autor;
    private String isbn;
    private StatusLivro status;

    public Book(String titulo, String autor, String ISBN, StatusLivro status) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.status = status;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public StatusLivro getStatus() {
        return this.status;
    }
    public String getAutor() {
        return this.autor;
    }
    public String getIsbn() {return this.isbn;}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Book outro)) {
            return false;
        }
        return isbn.equals(outro.isbn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
