package jpa.daos;

import jakarta.persistence.EntityManager;
import jpa.entities.Grade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GradeDAO {
    EntityManager manager;

    // methods
    public List<Grade> getAll() {
        return manager.createQuery("SELECT g FROM Grade g", Grade.class).getResultList();
    }

    public Grade get(String id) {
        return manager.find(Grade.class, id); // we get an element and find attaches it to the manager
    }

    public Grade insert(Grade element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Grade update(Grade element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Grade delete(Grade element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
