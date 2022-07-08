package daos;

import entities.Product;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ProductDAO {
    EntityManager manager;

    // methods
    public List<Product> getAll() {
        return manager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product get(String id) {
        return manager.find(Product.class, id); // we get an element and find attaches it to the manager
    }

    public Product insert(Product element) {
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(element); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it
        return element;
    }

    public Product update(Product element) {
        manager.getTransaction().begin();
        manager.merge(element);
        manager.getTransaction().commit();
        return element;
    }

    public Product delete(Product element) {
        manager.getTransaction().begin();
        manager.remove(element);
        manager.getTransaction().commit();
        return element;
    }
}
