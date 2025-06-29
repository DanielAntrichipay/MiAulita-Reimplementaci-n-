package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crea la SessionFactory desde hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cdg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo en la creación de SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
