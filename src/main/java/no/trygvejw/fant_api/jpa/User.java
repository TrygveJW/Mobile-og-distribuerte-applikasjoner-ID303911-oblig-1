package no.trygvejw.fant_api.jpa;



import javax.persistence.*;

@Entity
@Table(name="users", schema = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public int numting;


    public User(int numting) {
        this.numting = numting;
    }

    public User() {

    }
}
