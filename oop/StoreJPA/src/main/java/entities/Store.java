package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="store_id", nullable = false)
    private int storeId;
    @Column(name ="name", nullable = false)
    private String name;
    @Column(name ="street", nullable = false)
    private String street;
    @Column(name ="number", nullable = false)
    private int number;
    @Column(name ="city", nullable = false)
    private String city;
    @OneToOne(mappedBy = "store")
    private Director director;
    @OneToMany(mappedBy = "store")
    private List<Aisle> aisleList = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "store_product",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name= "product_id")
    )
    private List<Product> productList = new ArrayList<>();
    // constructor
    public Store(String name, String street, int number, String city) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    // methods
    @Override
    public String toString() {
        return "Store{" +
                "id='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                '}';
    }
}
