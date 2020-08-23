package kb.examples;

import kb.examples.entities.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

class Main3PersistentExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Sid", "Husky", 7);
        System.out.println(dog.getId());                        //null
        session.persist(dog);
        System.out.println(dog.getId());                        // jakaś wartość

        dog.setAge(12);

        transaction.commit();                                    // działa mechanizm dirty checking!
        session.close();
    }
}
