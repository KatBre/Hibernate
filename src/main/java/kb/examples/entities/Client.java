package kb.examples.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")                      // mappedBy określa pole wg. którego będzie mapowana relacja (encja Book)
            Set<Book> books = new HashSet<>();                                      // gdyby mappedBy nie występował, Hibernate będzie mapował relację przy pomocy tabeli pośredniczącej

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {                                                // każde dodanie Book do kolekcji books nie zostanie zmapowane jako relacja do bazy danych
        book.setClient(this);                                                       // dlatego właścicel relacji, czyli encja Book musi mieć ustawioną obecną encję Client
        this.books.add(book);
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }
}
