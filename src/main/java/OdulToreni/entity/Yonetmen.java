package OdulToreni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Yonetmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String yonetmenFullName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> cektigiFilm;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> odul;

    public Yonetmen(String yonetmenFullName) {
        this.yonetmenFullName = yonetmenFullName;
    }

    public Yonetmen(String yonetmenFullName, List<Film> cektigiFilm, List<Odul> odul) {
        this.yonetmenFullName = yonetmenFullName;
        this.cektigiFilm = cektigiFilm;
        this.odul = odul;
    }

    public Yonetmen(Integer id, String yonetmenFullName, List<Film> cektigiFilm, List<Odul> odul) {
        this.id = id;
        this.yonetmenFullName = yonetmenFullName;
        this.cektigiFilm = cektigiFilm;
        this.odul = odul;
    }
}
