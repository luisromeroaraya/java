package demo.javaee.demojavaee.services;

import demo.javaee.demojavaee.exceptions.ProductNotFoundException;
import demo.javaee.demojavaee.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> list = new ArrayList<>();

    // singleton
    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }
    // private constructor protected by singleton
    private ProductService() {
        list.add(new Product(1, "Apple", "PomPom", "fruit", 0.90));
        list.add(new Product(2, "Sofa", "The Sofa King", "furniture", 199.90));
        list.add(new Product(3, "20-inch LED Screen", "LG", "technology", 99.90));
    }

    // methods
    public List<Product> getAll() {
        return new ArrayList<>(this.list);
    }

    public Product getOne(int id) {
        return this.list.stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
