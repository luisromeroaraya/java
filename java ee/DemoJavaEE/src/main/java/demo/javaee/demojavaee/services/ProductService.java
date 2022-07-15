package demo.javaee.demojavaee.services;

import demo.javaee.demojavaee.exceptions.ProductNotFoundException;
import demo.javaee.demojavaee.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> list = new ArrayList<>();
    private int lastId;

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
        this.list.add(new Product(1, "Apple", "PomPom", "fruit", 0.90));
        this.list.add(new Product(2, "Sofa", "The Sofa King", "furniture", 199.90));
        this.list.add(new Product(3, "20-inch LED Screen", "LG", "technology", 99.90));
        this.lastId = 3;
    }

    // getters
    public int getLastId() { return lastId; }

    //setters
    public void setLastId(int lastId) { this.lastId = lastId; }

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

    public int addOne(Product product) {
        this.setLastId(this.getLastId() + 1);
        product.setId(this.getLastId());
        this.list.add(product);
        return product.getId();
    }

    public void update(Product product) {
        this.list.get(product.getId()-1).setName(product.getName());
        this.list.get(product.getId()-1).setBrand(product.getBrand());
        this.list.get(product.getId()-1).setCategory(product.getCategory());
        this.list.get(product.getId()-1).setPrice(product.getPrice());
    }

    public void delete(int id) {
        this.list.remove(id-1);
    }
}
