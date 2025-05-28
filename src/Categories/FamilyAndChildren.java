package Categories;

import db.DatabaseConfig;
import java.sql.*;
import java.util.Scanner;

public class FamilyAndChildren {
    static Scanner scanner = new Scanner(System.in);

    public static void displayFamilyAndChildrenMovies() {
        displayFromTable("family_children_movies", "Family and Children Movies");
    }

    public static void displayFamilyAndChildrenSeries() {
        displayFromTable("family_children_series", "Family and Children Series");
    }

    private static void displayFromTable(String tableName, String label) {
        try (Connection conn = DatabaseConfig.connect();
              Statement stmt = conn.createStatement()) {

            String sql = "SELECT m.movie_id, m.title, m.description, m.release_date, m.duration, m.rating, m.age_limit, m.director_id " +
                    "FROM " + tableName + " t JOIN movies m ON t.movie_id = m.movie_id";

            ResultSet rs = stmt.executeQuery(sql);

            int index = 1;
            System.out.println("\n-- " + label + " --");
            while (rs.next()) {
                System.out.println(index + "- " + rs.getString("title"));
                index++;
            }
            System.out.println(index + "- Return to previous page...");

            System.out.print("\nEnter Your Choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice < index) {
                rs = stmt.executeQuery(sql);
                for (int i = 1; i <= choice; i++) rs.next();

                System.out.println("\n--- Details ---");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Release Date: " + rs.getString("release_date"));
                System.out.println("Duration: " + rs.getString("duration"));
                System.out.println("Rating: " + rs.getString("rating"));
                System.out.println("Age Limit: " + rs.getString("age_limit"));
                System.out.println("Director ID: " + rs.getString("director_id"));
            } else {
                System.out.println("Returning to previous menu...");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}