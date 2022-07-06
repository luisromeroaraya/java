package jpa.daos;

import jakarta.persistence.EntityManager;
import jpa.entities.Professor;
import jpa.entities.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorDAO {
    EntityManager manager;

    // methods
    public List<Professor> getAll() {
        return manager.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
    }

    public Professor get(int id) {
        return manager.find(Professor.class, id); // we get an element and find attaches it to the manager
    }

    public Professor insert(Professor element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Professor update(Professor element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Professor delete(Professor element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
