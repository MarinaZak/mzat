package day6.hibernate;

import org.hibernate.SessionFactory;

import javax.imageio.spi.ServiceRegistry;
import java.lang.module.Configuration;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            initSessionFactory();
        }
        return sessionFactory;
    }

    private void initSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.getProperties().put('hibernate.connection.driver_class', 'com.mysql.jdbc.Driver');
        configuration.getProperties().put('hibernate.connection.url', 'jdbc:mysql://localhost/3AT_21');
        configuration.getProperties().put('hibernate.connection.username', 'root');
        configuration.getProperties().put('hibernate.connection.password', 'root.password');
        configuration.getProperties().put('hibernate.connection.pull_size', '2');
        configuration.getProperties().put('hibernate.show_sql', 'true');
        configuration.getProperties().put('hibernate.dialect', 'org.hibernate.dialect.MySQLDialect');
        configuration.getProperties().put('hibernate.current_session_context_class', 'thread');
        configuration.getProperties().put('hibernate.archive.autodetection', 'class, hbm');

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration buildSessionFactory(serviceRegistry);
    }
}
