package onetoone;

import javax.persistence.*;
import java.util.List;

@Entity

public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(unique = true,name = "Name")
    private  String name;
    @OneToOne
    @JoinColumn(name = "pid")
    private Passport passport;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
