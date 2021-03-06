package kb.examples;

import kb.examples.entities.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2SaveEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Dog("Ares", "Terier", 10));
        session.persist(new Dog("Burek", "Chihuaua", 3));
        session.persist(new Dog("Maks", "Chart", 5));
        session.persist(new Dog("Lucky", "Chowchow", 12));
        session.persist(new Dog("Dottie", "Mongrel", 2));



        transaction.commit();
        session.close();
    }
}
