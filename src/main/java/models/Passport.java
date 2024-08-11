package models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "passport_series")
    private String series;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "passport",fetch = FetchType.EAGER)
    private User user;

    public Passport(String series) {
        this.series = series;
    }
}
