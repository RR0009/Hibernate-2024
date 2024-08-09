package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "my_user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    private String email;
    @ElementCollection
    private List<String> skills = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(String name, String email, List<String> skills, Gender gender) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.gender = gender;
    }
}
