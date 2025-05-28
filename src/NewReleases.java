import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NewReleases {
    static Scanner scanner = new Scanner(System.in);

    public static void displayNewReleases() {
        System.out.println("\n NEW RELEASES");

        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT id, title FROM new_releases ORDER BY id";
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
                displayReleaseDetails(choice);
            } else {
                System.out.println("Invalid Choice! Please Try Again!");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while fetching new releases: " + e.getMessage());
        }
    }

    private static void displayReleaseDetails(int id) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT * FROM new_releases WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Details ---");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Duration: " + rs.getInt("duration") + " minutes");
                System.out.println("Rating: " + rs.getDouble("rating"));
                System.out.println("Age Limit: " + rs.getInt("age_limit") + "+");
                System.out.println("Type: " + rs.getString("type"));
                System.out.println();
            } else {
                System.out.println("No release found with this ID.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching release details: " + e.getMessage());
        }
    }
}
