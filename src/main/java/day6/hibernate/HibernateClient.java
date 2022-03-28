package day6.hibernate;

import day6.models.Address;
import day6.models.Student;

import java.util.Date;

public class HibernateClient {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId_student(1);
        student.setCourse(2);
        student.setName("Marina");
        student.setBd(new Date());
        System.out.println(student);

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        session.beginTransaction();
        session.readStudent(Student.class, 1);
        session.getTransaction().commit();
        System.out.println(readStudent);

        Student updateStudent = new Student();
        updateStudent.setName("NewName");
        session.beginTransaction();
        session.update(student);
        session.sessionGet(Student.class, 1);
        session.getTransaction().commit();
        System.out.println(update);

        Student deleteStudent = new Student();
        session.delete(student);
        session.sessionGet(Student.class, 1);
        session.getTransaction().commit();

        Address address = new Address();
        address.setId_address(1);
        address.setCountry("Ukraine");
        address.setCity("Lviv");
        save(address);

        session.close();
    }
}
