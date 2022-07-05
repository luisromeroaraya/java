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

    public Section get(int section_id) {
        return manager.find(Section.class, section_id); // we get a section and find attaches it to the manager
    }

    public Section insert(Section section) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(section); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return section;
    }

    public Section update(Section section) {
        manager.getTransaction().begin();
        manager.merge(section);
        manager.getTransaction().commit();
        return section;
    }

    public Section delete(Section section) {
        manager.getTransaction().begin();
        manager.remove(section);
        manager.getTransaction().commit();
        return section;
    }
}
