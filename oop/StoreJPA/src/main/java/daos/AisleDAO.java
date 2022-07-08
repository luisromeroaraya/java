package daos;

import entities.Aisle;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AisleDAO {
    EntityManager manager;

    // methods
    public List<Aisle> getAll() {
        return manager.createQuery("SELECT a FROM Aisle a", Aisle.class).getResultList();
    }

    public Aisle get(int id) {
        return manager.find(Aisle.class, id); // we get an element and find attaches it to the manager
    }

    public Aisle insert(Aisle element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Aisle update(Aisle element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Aisle delete(Aisle element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
