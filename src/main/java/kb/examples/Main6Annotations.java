package kb.examples;


import kb.examples.entities.Address;
import kb.examples.entities.Employee;
import kb.examples.entities.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class Main6Annotations {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee("Mary", "password1", "36547895", 35, new Date(), Gender.FEMALE, "nxkwhbcueoihcioewjnocjoijcie");
        employee.setAddress(new Address("Warsaw", "Main"));
        session.persist(employee);


        transaction.commit();
        session.close();
    }
}
