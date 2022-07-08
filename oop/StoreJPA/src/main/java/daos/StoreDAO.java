package daos;

import entities.Store;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class StoreDAO {
    EntityManager manager;

    // methods
    public List<Store> getAll() {
        return manager.createQuery("SELECT a FROM Store a", Store.class).getResultList();
    }

    public Store get(int id) {
        return manager.find(Store.class, id); // we get an element and find attaches it to the manager
    }

    public Store insert(Store element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Store update(Store element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Store delete(Store element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
