import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        var sql = "CREATE TABLE products (" +
                "   id SERIAL PRIMARY KEY," +
                "   name VARCHAR(255) NOT NULL," +
                "   price DECIMAL(10, 2) NOT NULL" +
                ");";

        try(var connection = Database.connect()) {
            assert connection != null;
            try(var stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
