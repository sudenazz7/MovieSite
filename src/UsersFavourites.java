import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersFavourites {
    static Scanner scanner = new Scanner(System.in);

    public static void displayUsersFavourites() {
        System.out.println("\n- USER'S FAVOURITES -");

        String[] categories = {
                "Romantic",
                "Action",
                "Horror",
                "Comedy",
                "Sci-fi and Fantasy",
                "Kids and Family"
        };
        int itemsPerCategory = 10;

        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT fav_id, title, duration, age_limit FROM users_favourites ORDER BY fav_id ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int count = 0;
            int categoryIndex = 0;

            while (rs.next()) {
                if (count % itemsPerCategory == 0) {
                    if (categoryIndex < categories.length) {
                        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<< " + categories[categoryIndex] + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        categoryIndex++;
                    }
                    System.out.println("-------------------------------------------------------------------");
                    System.out.printf("%-3s %-25s %-20s %-10s\n", "#", "Title", "Duration", "Age Limit");
                    System.out.println("-------------------------------------------------------------------");
                }

                int favId = rs.getInt("fav_id");
                String title = rs.getString("title");
                int duration = rs.getInt("duration");
                int ageLimit = rs.getInt("age_limit");

                String formattedDuration = formatDuration(duration);
                String age = "+" + ageLimit;

                System.out.printf("%-3d %-25s %-20s %-10s\n", favId, title, formattedDuration, age);

                count++;
            }

            System.out.println("\n" + (count + 1) + ". Back to Home Page");
            System.out.print("\nEnter the ID of the content to view details or " + (count + 1) + " to go back: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == count + 1) {
                return;
            } else {
                displayFavouriteDetails(choice);
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while fetching favorites: " + e.getMessage());
        }
    }

    private static void displayFavouriteDetails(int id) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT * FROM users_favourites WHERE fav_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- DETAILS ---");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Release Date: " + rs.getDate("release_date"));
                System.out.println("Duration: " + formatDuration(rs.getInt("duration")));
                System.out.println("Rating: " + rs.getDouble("rating"));
                System.out.println("Age Limit: " + rs.getInt("age_limit") + "+");
                System.out.println("Type: " + rs.getString("type"));
                System.out.println();
            } else {
                System.out.println("No favorite found with this ID.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while fetching favorite details: " + e.getMessage());
        }
    }

    private static String formatDuration(int minutes) {
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + "h " + remainingMinutes + "m";
    }
}
