package DAOlar.repository;

import DAOlar.entity.Film;
import DAOlar.entity.Oyuncu;
import DAOlar.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FilmDao {
    public void getAll() {
        List<Object[]> bookList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "use odul_toreni; \n" +
                    "select f.filmAdi,oy.oyuncuFullName,o.odulAdi,y.yonetmenFullName from film as f\n" +
                    "inner join yonetmen as y on  f.yonetmenAdi_id=y.id\n" +
                    "inner join film_oyuncu as foy on foy.Film_id=f.id\n" +
                    "inner join oyuncu as oy on foy.oyuncuAdi_id=oy.id\n" +
                    "inner join film_filmkategorisi as ff on f.id=ff.Film_id\n" +
                    "inner join filmkategorisi as fk on fk.id=ff.filmKategorisi_id\n" +
                    "inner join film_odul as fo on fo.Film_id=f.id\n" +
                    "inner join odul as o on fo.odul_id=o.id\n";
            bookList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : bookList) {
                System.out.println("Film Adi: " + item[0] + " --"
                        + " Oyuncu Full Name: " + item[1] + " --"
                        + " Odul Adi: " + item[2] + " --"
                        + " Yonetmen Full Name: " + item[3]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveF(Film film) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            System.out.println("Film is added");
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateF(Film film) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(film);
            session.getTransaction().commit();
            System.out.println("Film is updated");
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteF(int id){
        Session session = null;
        Film film = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            film = session.load(Film.class, id);
            session.delete(film);
            session.getTransaction().commit();
            System.out.println("Film deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    public void getByName(String name){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql="select o.oyuncuFullName,f.filmAdi,od.odulAdi from oyuncu as o\n" +
                    "inner join oyuncu_film as off on  off.Oyuncu_id=o.id\n" +
                    "inner join film as f on off.oynadıgıFilm_id=f.id\n" +
                    "inner join oyuncu_odul as oo on oo.Oyuncu_id=o.id\n" +
                    "inner join odul as od on oo.odul_id=od.id\n" +
                    "WHERE f.filmAdi = :key\n" +
                    "ORDER BY o.oyuncuFullName;";
            Query query=session.createNativeQuery(hql);
            query.setParameter("key",name);
            List<Object[]> actors=query.getResultList();
            for (Object[] item : actors) {
                System.out.println(" Oyuncu Full Name: " + item[0] + " --"
                        + " Film Adi:" + item[1] + " --"
                        + " Odul Adi: " + item[2]

                );}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    }
