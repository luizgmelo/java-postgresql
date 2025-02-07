import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        int id = ProductDB.add(new Product("Phone Case", 19.99));
        System.out.println("Inserted id:" + id);
    }
}
