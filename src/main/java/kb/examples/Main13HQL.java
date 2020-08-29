package kb.examples;

import kb.examples.entities.Husband;
import kb.examples.entities.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Main13HQL {
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query queryOne = session.createQuery("FROM Husband");
        List<Husband> resultOne = queryOne.getResultList();
        resultOne.stream()
                .map(Husband::getWife)
                .filter(Objects::nonNull)
                .map(Wife::getName)
                .forEach(System.out::println);

        Query queryTwo = session.createQuery("SELECT h.name FROM Husband AS h");
        List<String> resultTwo = queryTwo.getResultList();
        resultTwo.forEach(System.out::println);

        System.out.println("<------------------------------>");


//        Query<Husband> queryThree = session.createQuery("FROM Husband AS h WHERE h.id = :id", Husband.class);
//        queryThree.setParameter("id", 4L);
//        Husband singleResult = queryThree.getSingleResult();
//        System.out.println(singleResult.getName());

        Husband husband = session.createQuery("FROM Husband AS h WHERE h.id = :id", Husband.class)
                .setParameter("id", 4L)
                .getSingleResult();

        System.out.println(husband.getName());

        System.out.println("<------------------------------>");

        session.createQuery("SELECT w.name FROM Husband AS h INNER JOIN h.wife AS w")
                .getResultList()
                .stream()
                .forEach(System.out::println);


        transaction.commit();
        session.close();
    }
}
