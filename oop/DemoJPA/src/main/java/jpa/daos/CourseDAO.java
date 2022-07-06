package jpa.daos;

import jakarta.persistence.EntityManager;
import jpa.entities.Course;
import jpa.entities.Section;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDAO {
    EntityManager manager;

    // methods
    public List<Course> getAll() {
        return manager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public Course get(String id) {
        return manager.find(Course.class, id); // we get an element and find attaches it to the manager
    }

    public Course insert(Course element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Course update(Course element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Course delete(Course element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
