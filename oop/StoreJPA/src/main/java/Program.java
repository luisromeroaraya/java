import daos.*;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StoreJPA");
        EntityManager manager = emf.createEntityManager();
        AisleDAO aisleDAO = new AisleDAO(manager);
        DirectorDAO directorDAO = new DirectorDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);
        StoreDAO storeDAO = new StoreDAO(manager);


        ////////////////////////////////////////////////////////////
        // Create Store
        System.out.println("-------------------------------------");
        Store store = new Store(1, "Dunder Mifflin", "Slough Avenue", 1725, "Scranton", null, List.of(), List.of());
        System.out.println(storeDAO.insert(store));

        // Create Director
        System.out.println("-------------------------------------");
        Director director = new Director(1, "Michael", "Scott", 3000, storeDAO.get(1));
        System.out.println(directorDAO.insert(director));

        // Create Aisles
        System.out.println("-------------------------------------");
        Aisle aislePaper = new Aisle(1, "Paper", storeDAO.get(1));
        System.out.println(aisleDAO.insert(aislePaper));
        Aisle aisleToner = new Aisle(2, "Toner", storeDAO.get(1));
        System.out.println(aisleDAO.insert(aisleToner));

        // Create Products
        System.out.println("-------------------------------------");
        Product pp38 = new Product("PP38", "38 pound bond", "Dunder Mifflin", 5, List.of(storeDAO.get(1)));
        System.out.println(productDAO.insert(pp38));
        Product pp40 = new Product("PP40", "40 pound Letter stock", "Dunder Mifflin", 6, List.of(storeDAO.get(1)));
        System.out.println(productDAO.insert(pp40));
        Product tt01 = new Product("TT01", "Toner BW Standard", "HP", 20, List.of(storeDAO.get(1)));
        System.out.println(productDAO.insert(tt01));

        // Add Products to Store
        System.out.println("-------------------------------------");
        List<Product> productList = new ArrayList<>();
        productList.add(pp38);
        productList.add(pp40);
        productList.add(tt01);
        store.setProductList(productList); // I can't use List.of because it is immutable, that's why I had to crete an ArrayList instead
        storeDAO.update(store);
        System.out.println(store.getProductList());

        emf.close();
    }
}
