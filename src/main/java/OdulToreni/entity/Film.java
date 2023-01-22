package OdulToreni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filmAdi;
    @ManyToOne(cascade = CascadeType.ALL)
    private Yonetmen yonetmenAdi;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<FilmKategorisi> filmKategorisi;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Oyuncu> oyuncuAdi;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> odul;

    public Film(String filmAdi, List<FilmKategorisi> filmKategorisi) {
        this.filmAdi = filmAdi;
        this.filmKategorisi = filmKategorisi;
    }

    public Film(String filmAdi, Yonetmen yonetmenAdi, List<FilmKategorisi> filmKategorisi) {
        this.filmAdi = filmAdi;
        this.yonetmenAdi = yonetmenAdi;
        this.filmKategorisi = filmKategorisi;
    }

    public Film(String filmAdi, Yonetmen yonetmenAdi, List<Oyuncu> oyuncuAdi, List<FilmKategorisi> filmKategorisi, List<Odul> odul) {
        this.filmAdi = filmAdi;
        this.yonetmenAdi = yonetmenAdi;
        this.oyuncuAdi = oyuncuAdi;
        this.filmKategorisi = filmKategorisi;
        this.odul = odul;
    }

    public Film(Integer id, String filmAdi, Yonetmen yonetmenAdi, List<Oyuncu> oyuncuAdi, List<FilmKategorisi> filmKategorisi, List<Odul> odul) {
        this.id = id;
        this.filmAdi = filmAdi;
        this.yonetmenAdi = yonetmenAdi;
        this.oyuncuAdi = oyuncuAdi;
        this.filmKategorisi = filmKategorisi;
        this.odul = odul;
    }


}
