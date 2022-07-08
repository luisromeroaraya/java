package daos;

import entities.Director;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class DirectorDAO {
    EntityManager manager;

    // methods
    public List<Director> getAll() {
        return manager.createQuery("SELECT d FROM Director d", Director.class).getResultList();
    }

    public Director get(int id) {
        return manager.find(Director.class, id); // we get an element and find attaches it to the manager
    }

    public Director insert(Director element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Director update(Director element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Director delete(Director element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
