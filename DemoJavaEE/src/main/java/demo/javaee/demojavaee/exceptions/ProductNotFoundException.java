package demo.javaee.demojavaee.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private final int id;

    // constructor
    public ProductNotFoundException(int id) {
        super("The product id "+ id + " wasn't found.");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
