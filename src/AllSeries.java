import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AllSeries {
    static Scanner scanner = new Scanner(System.in);

    public static void Series(String username) {
        System.out.println("\nSERIES");
        System.out.println("1 - Display All Series");
        System.out.println("2 - Choose a Category");
        System.out.println("3 - Back to Home Page");
        System.out.println();
        System.out.print("Please Enter your Transaction: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displayAllSeries(username);
                break;
            case 2:
                // chooseCategoryForSeries();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice! Please Try Again!");
        }
    }

    public static void displayAllSeries(String username) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT * FROM series ORDER BY series_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int count = 0;
            System.out.println("\n--- ALL SERIES ---");
            while (rs.next()) {
                count++;
                System.out.println(count + ". " + rs.getString("title"));
            }
            System.out.println((count + 1) + ". Back to Main Menu");

            System.out.print("\nPlease choose a series to see details: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == count + 1) return;

            if (choice >= 1 && choice <= count) {
                rs = stmt.executeQuery(); // Reset cursor
                int current = 0;
                while (rs.next()) {
                    current++;
                    if (current == choice) {
                        int seriesId = rs.getInt("series_id");
                        String title = rs.getString("title");
                        String description = rs.getString("description");
                        String releaseDate = rs.getString("release_date");
                        int duration = rs.getInt("duration");
                        double rating = rs.getDouble("rating");
                        int ageLimit = rs.getInt("age_limit");
                        String actors = rs.getString("actors");

                        displaySeriesDetails(username, seriesId, title, description, releaseDate, duration, rating, ageLimit, actors);
                        break;
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching series: " + e.getMessage());
        }
    }

    private static void displaySeriesDetails(String username, int seriesId, String title, String description, String releaseDate,
                                             int duration, double rating, int ageLimit, String actors) {
        System.out.println("\n--- SERIES DETAILS ---");
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Episode Duration: " + duration + " min");
        System.out.println("Rating: " + rating);
        System.out.println("Age Limit: " + ageLimit + "+");
        System.out.println("Cast: " + actors);

        System.out.println("\nWould you like to comment?");
        System.out.println("1. Yes\n2. No");
        int answer = scanner.nextInt();
        scanner.nextLine();

        if (answer == 1) {
            CommentHandler.leaveComment(username, seriesId, "series");
        } else {
            System.out.println("Returning to main menu...");
        }
    }
}
