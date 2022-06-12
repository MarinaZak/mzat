package day6.hibernate;
import day6.models.Address;
import day6.models.Student;

import org.hibernate.SessionFactory;

import java.util.Properties;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.io.FileInputStream;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            sessionFactory=initSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory initSessionFactory() {

        Configuration configuration = new Configuration();
        try {
            Properties properties=new Properties();
            properties.load(new FileInputStream(
                    "src/main/resources/config.properties"));
            configuration.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        return configuration.buildSessionFactory(serviceRegistry);
    }
}