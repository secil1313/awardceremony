package DAOlar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class FilmKategorisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filmKategorisi;

    public FilmKategorisi(String filmKategorisi) {
        this.filmKategorisi = filmKategorisi;
    }
}
