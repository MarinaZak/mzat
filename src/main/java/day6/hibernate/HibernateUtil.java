package day6.hibernate;
//import day_6.model.Address;
//import day_6.model.Student;

import org.hibernate.SessionFactory;

import javax.imageio.spi.ServiceRegistry;
import java.lang.module.Configuration;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

//    public static SessionFactory getSessionFactory() {
//        if(sessionFactory==null){
//            sessionFactory=initSessionFactory();
//        }
//        return sessionFactory;
//    }

//    private static SessionFactory initSessionFactory() {
//
//        Configuration configuration = new Configuration();
//        try {
//            Properties properties=new Properties();
//            properties.load(new FileInputStream(
//                    "src/main/resources/config.properties"));
//            configuration.setProperties(properties);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        configuration.addAnnotatedClass(Address.class);
//        configuration.addAnnotatedClass(Student.class);
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//        System.out.println("Hibernate Java Config serviceRegistry created");
//
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
}