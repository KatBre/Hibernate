package kb.examples;

import kb.examples.entities.School;
import kb.examples.entities.Student;
import org.hibernate.*;

public class Main11ManyToMany {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School school1 = new School("SDA");
        School school2 = new School("A-KOM");

        Student student1 = new Student("Peter");
        Student student2 = new Student("Mike");
        Student student3 = new Student("Vanessa");

        school1.addStudent(student1);
        school1.addStudent(student2);

        school2.addStudent(student2);
        school2.addStudent(student3);

        session.persist(school1);
        session.persist(school2);

        transaction.commit();
        session.close();
    }
}
