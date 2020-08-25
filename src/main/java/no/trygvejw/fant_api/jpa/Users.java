package no.trygvejw.fant_api.jpa;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

@Stateless
public class Users {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager entityManager;

    public void addUser(User user){
        entityManager.persist(user);
    }

    public User getUserById(Long id){
        return entityManager.find(User.class, id);
    }


}
