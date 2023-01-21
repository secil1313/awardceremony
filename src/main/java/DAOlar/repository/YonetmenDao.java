package DAOlar.repository;

import DAOlar.entity.Yonetmen;
import DAOlar.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class YonetmenDao {
    public void getAll() {
        List<Object[]> bookList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select y.yonetmenFullName,f.filmAdi,od.odulAdi from yonetmen as y\n" +
                    "inner join yonetmen_film as yf on  yf.Yonetmen_id=y.id\n" +
                    "inner join film as f on yf.cektigiFilm_id=f.id\n" +
                    "inner join yonetmen_odul as yo on yo.Yonetmen_id=y.id\n" +
                    "inner join odul as od on yo.odul_id=od.id";
            bookList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : bookList) {
                System.out.println("Yonetmen Full Name: " + item[0] + " --"
                        + " Film Adi: " + item[1] + " --"
                        + " Odul Adi: " + item[2]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveY(Yonetmen yonetmen) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(yonetmen);
            session.getTransaction().commit();
            System.out.println("Yonetmen is added");
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
}
    public void updateY(Yonetmen yonetmen) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(yonetmen);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteY(int id){
        Session session = null;
        Yonetmen yonetmen = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            yonetmen = session.load(Yonetmen.class, id);
            session.delete(yonetmen);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            //rollback kontrolü yapılabilir
        }
    }
}
