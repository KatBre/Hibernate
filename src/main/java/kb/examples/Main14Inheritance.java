package kb.examples;

import kb.examples.entities.Orange;
import org.hibernate.*;

public class Main14Inheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Apple("Szampion", "red"));
        session.persist(new Apple("Papierówka", "yellow"));
        session.persist(new Orange("Olbrzymia", "big"));
        session.persist(new Orange("Zwyczajna", "medium"));

        transaction.commit();
        session.close();
    }
}
