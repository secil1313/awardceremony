package DAOlar.utils;

import DAOlar.entity.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(FilmKategorisi.class);
                configuration.addAnnotatedClass(Odul.class);
                configuration.addAnnotatedClass(Oyuncu.class);
                configuration.addAnnotatedClass(Yonetmen.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }

}
