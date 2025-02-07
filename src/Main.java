import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var products = new ArrayList<Product>();

        products.add(new Product("Power Bank",19.99));
        products.add(new Product("Screen Protector", 29.99));
        products.add(new Product("Wireless Charger", 35.99));
        products.add(new Product("Bluetooth Headphones", 199));
        products.add(new Product("Phone Stand", 24.99));
        products.add(new Product("Ring Holder", 39.99));
        products.add(new Product("Car Mount", 29.98));
        products.add(new Product("Selfie Stick", 29.99));
        products.add(new Product("Smartwatch", 399.97));

        ProductDB.add(products);
    }
}
