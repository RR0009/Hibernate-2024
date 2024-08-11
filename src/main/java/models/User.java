package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_User")
@Entity
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name ="User_name")
    private String name;
    private String email;

    @ElementCollection
    private List<String>skills = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="passport_id",referencedColumnName = "id")
    private Passport passport;


    public User(String name, String email, List<String> skills, Gender gender,Passport passport) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.gender = gender;
        this.passport = passport;
    }
}
