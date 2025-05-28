package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Connection connect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Moviesite_db";
            String user = "postgres";
            String password = "12345";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
