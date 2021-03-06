package jpa.daos;

import jakarta.persistence.*;
import jpa.entities.Section;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SectionDAO {
    EntityManager manager;

    // methods
    public List<Section> getAll() {
        return manager.createQuery("SELECT s FROM Section s", Section.class).getResultList();
    }

    public Section get(int id) {
        return manager.find(Section.class, id); // we get an element and find attaches it to the manager
    }

    public Section insert(Section element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Section update(Section element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Section delete(Section element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
