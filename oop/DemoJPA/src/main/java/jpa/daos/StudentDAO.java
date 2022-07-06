package jpa.daos;

import jakarta.persistence.EntityManager;
import jpa.entities.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDAO {
    EntityManager manager;

    // methods
    public List<Student> getAll() {
        return manager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student get(int id) {
        return manager.find(Student.class, id); // we get a section and find attaches it to the manager
    }

    public Student insert(Student element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Student update(Student element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Student delete(Student element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
