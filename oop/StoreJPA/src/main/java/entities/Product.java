package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name ="product_id", nullable = false, length = 5)
    private String productId;
    @Column(name ="name", nullable = false)
    private String name;
    @Column(name ="brand", nullable = false)
    private String brand;
    @Column(name ="price", nullable = false, columnDefinition = "decimal(6,2)")
    private double price;
    @ManyToMany(mappedBy = "productList")
    List<Store> storeList = new ArrayList<>();

    // constructor
    public Product(String productId, String name, String brand, double price) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    // methods
    @Override
    public String toString() {
        return "Product{" +
                "id='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
