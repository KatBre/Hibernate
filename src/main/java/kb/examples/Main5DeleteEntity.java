package kb.examples;

import kb.examples.entities.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5DeleteEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = session.find(Dog.class, 6L);
        session.remove(dog);                                                    // session.delete(...)


        transaction.commit();
        session.close();
    }
}