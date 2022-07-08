package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name ="product_id")
    private String productId;
    @Column(name ="name")
    private String name;
    @Column(name ="brand")
    private String brand;
    @Column(name ="price", columnDefinition = "decimal(6,2)")
    private double price;
    @ManyToMany(mappedBy = "productList")
    List<Store> storeList = new ArrayList<>();

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
