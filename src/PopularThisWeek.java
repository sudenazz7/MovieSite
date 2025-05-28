import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PopularThisWeek {
    static Scanner scanner = new Scanner(System.in);

    public static void displayPopularThisWeek() {
        System.out.println("\n POPULAR THIS WEEK");

        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT pop_id, title FROM popular_this_week ORDER BY pop_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int count = 0;
            while (rs.next()) {
                count++;
                System.out.println(count + ". " + rs.getString("title"));
            }
            System.out.println((count + 1) + ". Back to Home Page");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == count + 1) {
                return;
            } else if (choice >= 1 && choice <= count) {
                displayPopularDetails(choice);
            } else {
                System.out.println("Invalid Choice! Please Try Again!");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while fetching popular content: " + e.getMessage());
        }
    }

    private static void displayPopularDetails(int id) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT * FROM popular_this_week WHERE pop_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Details ---");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Release Date: " + rs.getString("release_date"));
                System.out.println("Duration: " + rs.getInt("duration") + " minutes");
                System.out.println("Rating: " + rs.getDouble("rating"));
                System.out.println("Age Limit: " + rs.getInt("age_limit") + "+");
                System.out.println("Type: " + rs.getString("type"));
                System.out.println();
            } else {
                System.out.println("No popular content found with this ID.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching details: " + e.getMessage());
        }
    }
}
