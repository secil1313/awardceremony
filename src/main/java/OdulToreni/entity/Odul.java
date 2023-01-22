package OdulToreni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class Odul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String odulAdi;

    public Odul(String odulAdi) {
        this.odulAdi = odulAdi;
    }

    public Odul(Integer id, String odulAdi) {
        this.id = id;
        this.odulAdi = odulAdi;
    }
}
