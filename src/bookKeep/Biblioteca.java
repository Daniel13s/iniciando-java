package bookKeep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    public List<Book> livros = new ArrayList<>();

    public void adicionarBook(Book livro) {
        this.livros.add(livro);
    }
    public Optional<Book> getBook(int index) {
       for(Book livro : livros) {
           if(livro.ID == index) {
               return Optional.of(livro);
           }
       }
       return Optional.empty();
    }
}
