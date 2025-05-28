package db;
import java.sql.Connection;
public class TestConnection {
    public static void main(String[] args) {
        Connection conn = DatabaseConfig.connect();
        if (conn != null) {
            System.out.println("Bağlantı başarılı!");
        } else {
            System.out.println("Bağlantı başarısız!");
        }
    }
}