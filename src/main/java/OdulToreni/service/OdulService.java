package OdulToreni.service;

import OdulToreni.entity.*;

import OdulToreni.repository.FilmDao;
import OdulToreni.repository.OyuncuDao;
import OdulToreni.repository.YonetmenDao;

import java.util.Arrays;

public class OdulService {
    static FilmDao filmDao=new FilmDao();
    static OyuncuDao oyuncuDao=new OyuncuDao();
    static YonetmenDao yonetmenDao=new YonetmenDao();

    public static void main(String[] args) {
        //saveF();
        //saveO();
       //saveY();
        //updateF();
       //deleteByIdF();
        //getAllO();
        //getAllY();
        //updateO();
        //updateY();
        //deleteByIdO();
        //deleteByIdY();
        getAllF();
       // getByName("The Father");

    }
    public static void saveF(){
        Yonetmen yonetmen=new Yonetmen("Chloé Zhao");
        Oyuncu oyuncu1=new Oyuncu("Frances McDormand");
        FilmKategorisi filmKategorisi=new FilmKategorisi("Dram");
        Odul odul=new Odul("En İyi Film");
       Film film=new Film("Nomadland",
               yonetmen,
               Arrays.asList(oyuncu1),
               Arrays.asList(filmKategorisi),
               Arrays.asList(odul));
        filmDao.saveF(film);

    }
    public static void updateF(){
        Yonetmen yonetmen=new Yonetmen("Sian Heder");
        Oyuncu oyuncu1=new Oyuncu("Frances McDormand");
        FilmKategorisi filmKategorisi1=new FilmKategorisi("Komedi");
        FilmKategorisi filmKategorisi2=new FilmKategorisi("Drama");
        Odul odul=new Odul("En İyi Film");
        Film film=new Film(1,"CODA",yonetmen, Arrays.asList(oyuncu1),Arrays.asList(filmKategorisi1,filmKategorisi2),Arrays.asList(odul));
        filmDao.updateF(film);
    }
    public static void deleteByIdF(){

        filmDao.deleteF(1);
    }
    public static void getByName(String name){
        filmDao.getByName(name);
    }
    public static void getAllF() {

        filmDao.getAll();
    }

    public static void saveO(){
        Yonetmen yonetmen=new Yonetmen("Florian Zeller");
        FilmKategorisi filmKategorisi=new FilmKategorisi("Dram");
        Film film=new Film("The Father",yonetmen,Arrays.asList(filmKategorisi));
        Odul odul=new Odul("En İyi Erkek Oyuncu");
        Oyuncu oyuncu=new Oyuncu("Anthony Hopkins",Arrays.asList(film),Arrays.asList(odul));
        oyuncuDao.saveO(oyuncu);

    }
    public static void getAllO() {

        oyuncuDao.getAllO();
    }
    public static void updateO(){
        Yonetmen yonetmen=new Yonetmen("Gus Van Sant");
        FilmKategorisi filmKategorisi=new FilmKategorisi("Dram");
        Film film=new Film("Milk",yonetmen,Arrays.asList(filmKategorisi));
        Odul odul=new Odul("En İyi Erkek Oyuncu");
        Oyuncu oyuncu=new Oyuncu(1,"Sean Penn",Arrays.asList(film),Arrays.asList(odul));
        oyuncuDao.updateO(oyuncu);
    }
    public static void deleteByIdO(){

        oyuncuDao.deleteO(1);
    }
    public static void saveY(){

        FilmKategorisi filmKategorisi=new FilmKategorisi("Dram");
        Film film=new Film("Nomadland",Arrays.asList(filmKategorisi));
        Odul odul=new Odul("En İyi Yönetmen ve En İyi Özgün Senaryo");
        Yonetmen yonetmen=new Yonetmen("Chloé Zhao",Arrays.asList(film),Arrays.asList(odul));
        yonetmenDao.saveY(yonetmen);
    }
    public static void updateY(){
        FilmKategorisi filmKategorisi=new FilmKategorisi("Dram");
        Film film=new Film("Parazit",Arrays.asList(filmKategorisi));
        Odul odul=new Odul("En İyi Yönetmen");
        Yonetmen yonetmen=new Yonetmen(1,"Bong Joon-ho",Arrays.asList(film),Arrays.asList(odul));
        yonetmenDao.updateY(yonetmen);
    }
    public static void deleteByIdY(){

        yonetmenDao.deleteY(1);
    }
    public static void getAllY() {

        yonetmenDao.getAll();
    }

    }

