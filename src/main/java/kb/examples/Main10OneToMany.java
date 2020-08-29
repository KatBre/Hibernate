package kb.examples;


import kb.examples.entities.Book;
import kb.examples.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main10OneToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client("Andrew");
        client.addBook(new Book("By fire and sword"));
        client.addBook(new Book("Alice in Wonderland"));
        client.addBook(new Book("Harry Potter"));


        Client client1 = new Client("Julia");
        client1.addBook(new Book("How to learn Java"));
        client1.addBook(new Book("Lord of rings"));
        client1.addBook(new Book("Paddington Bear"));


        session.persist(client);
        session.persist(client1);

        transaction.commit();
        session.close();
    }
}
