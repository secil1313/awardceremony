package DAOlar.repository;

import DAOlar.entity.Oyuncu;
import DAOlar.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class OyuncuDao {
    public void getAllO() {
        List<Object[]> bookList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.oyuncuFullName,f.filmAdi,od.odulAdi from oyuncu as o\n" +
                    "inner join oyuncu_film as off on  off.Oyuncu_id=o.id\n" +
                    "inner join film as f on off.oynadıgıFilm_id=f.id\n" +
                    "inner join oyuncu_odul as oo on oo.Oyuncu_id=o.id\n" +
                    "inner join odul as od on oo.odul_id=od.id";
            bookList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : bookList) {
                System.out.println("Oyuncu Full Name: " + item[0] + " --"
                        + "Film Adi : " + item[1] + " --"
                        + " Odul Adi: " + item[2]

                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveO(Oyuncu oyuncu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(oyuncu);
            session.getTransaction().commit();
            System.out.println("Oyuncu is added");
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
}
    public void updateO(Oyuncu oyuncu) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(oyuncu);
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
    public void deleteO(int id){
        Session session = null;
        Oyuncu oyuncu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            oyuncu = session.load(Oyuncu.class, id);
            session.delete(oyuncu);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            //rollback kontrolü yapılabilir
        }
    }
}
