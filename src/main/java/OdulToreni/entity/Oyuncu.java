package OdulToreni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Oyuncu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String oyuncuFullName;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film>oynadıgıFilm;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> odul;


    public Oyuncu(String oyuncuFullName) {
        this.oyuncuFullName = oyuncuFullName;
    }

    public Oyuncu(String oyuncuFullName, List<Film> oynadıgıFilm, List<Odul> odul) {
        this.oyuncuFullName = oyuncuFullName;
        this.oynadıgıFilm = oynadıgıFilm;
        this.odul = odul;
    }

    public Oyuncu(Integer id, String oyuncuFullName, List<Film> oynadıgıFilm, List<Odul> odul) {
        this.id = id;
        this.oyuncuFullName = oyuncuFullName;
        this.oynadıgıFilm = oynadıgıFilm;
        this.odul = odul;
    }
}
