package kb.examples;

import kb.examples.entities.School;
import kb.examples.entities.Student;
import org.hibernate.*;

import java.util.Set;


public class Main12FetchType {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School school = session.find(School.class, 1L);
        System.out.println(school.getName());
        Set<Student> students = school.getStudents();

        students.stream()
                .map(Student::getName)                                          // w przypadku FetchType.LAZY w tym momencie jest wykonywane dodatkowe zapytanie o popranie informacji o kolekcji
                .forEach(System.out::println);                                  // ustawione FetchType.EAGER powoduje, że te informacje zostaną pobrane 1 zapytaniem podczas session.find()

        transaction.commit();
        session.close();
    }
}
