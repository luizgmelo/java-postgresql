import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProductDB {

    public static void add(List<Product> products) {
        var sql = "INSERT INTO products(name, price) " +
                "VALUES (?,?)";

        try(var conn = Database.connect();
            var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            for (var product : products) {
                pstmt.setString(1, product.getName());
                pstmt.setDouble(2, product.getPrice());
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
