package lk.D24.util;

import lk.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){

        Configuration configure = new Configuration().configure();
        sessionFactory=configure.configure().
                addAnnotatedClass(Student.class).

                // addAnnotatedClass(OrderDetail.class).
                        buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return factoryConfiguration==null ? (factoryConfiguration=new FactoryConfiguration()): factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
