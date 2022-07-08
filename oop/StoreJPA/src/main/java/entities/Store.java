package entities;

import jakarta.persistence.*;
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
public class Store {
    @Id
    @Column(name ="store_id")
    private int storeId;
    @Column(name ="name")
    private String name;
    @Column(name ="street")
    private String street;
    @Column(name ="number")
    private int number;
    @Column(name ="city")
    private String city;
    @OneToOne(mappedBy = "store")
    private Director director;
    @OneToMany(mappedBy = "store")
    private List<Aisle> aisleList;
    @ManyToMany
    @JoinTable(
            name = "store_product",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name= "product_id")
    )
    private List<Product> productList = new ArrayList<>();

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
