package kb.examples;

import kb.examples.entities.Husband;
import kb.examples.entities.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main7OneToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Husband adam = new Husband("Adam");
        Wife ewa = new Wife("Ewa");
        adam.setWife(ewa);
        session.persist(adam);
        session.persist(ewa);


//        Husband mark = new Husband("Mark");
//        Wife anna = new Wife("Anna");
//        session.persist(mark);
//        session.persist(anna);
//        anna.setHusband(mark);                   // Wife nie jest właścicelem relacji, dlatego samo przypisanie Husband do Wife jest niepoprawne
//                                                 // relacja nie zostanie odwzorowana w bazie danych
//                                                 // dlatego implementacja wife.setHusband(husband) wykonuje husband.setWife(this)

        session.persist(new Husband("Damian", new Wife("Sabrina")));
        session.persist(new Husband("Bertek", new Wife("Kinga")));
        session.persist(new Husband("Kacper", new Wife("Natalia")));
        session.persist(new Husband("Piotr", new Wife("Joanna")));
        session.persist(new Husband("Michał", new Wife("Katarzyna")));


        transaction.commit();
        session.close();
    }

}
