import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB {

    public static int add(Product product) {
        var sql = "INSERT INTO products(name, price) " +
                "VALUES (?,?)";

        try(var conn = Database.connect();
            var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {

            // bind the values
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());

            // execute the INSERT statement and get the inserted id
            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;


    }


}
