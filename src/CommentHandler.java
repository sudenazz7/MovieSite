import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CommentHandler {
    static Scanner scanner = new Scanner(System.in);

    public static void leaveComment(String username, int contentId, String type) {
        System.out.println("\nWould you like to comment?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int answer = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (answer != 1) {
            System.out.println("Returning to the home page...");
            return;
        }

        // Özel mesaj
        if (type.equalsIgnoreCase("movie")) {
            System.out.println("\nHow much did you like the movie?");
        } else if (type.equalsIgnoreCase("series")) {
            System.out.println("\nHow much did you like the series?");
        } else {
            System.out.println("\nInvalid type!");
            return;
        }

        System.out.println("Please write your comment:");
        String comment = scanner.nextLine();

        int userId = getUserIdByUsername(username);
        if (userId == -1) {
            System.out.println("Unable to find user.");
            return;
        }

        try (Connection conn = DatabaseConfig.connect()) {
            String sql;
            if (type.equalsIgnoreCase("movie")) {
                sql = "INSERT INTO movie_comments (user_id, movie_id, content, created_at) VALUES (?, ?, ?, ?)";
            } else {
                sql = "INSERT INTO series_comments (user_id, series_id, content, created_at) VALUES (?, ?, ?, ?)";
            }

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, contentId);
            stmt.setString(3, comment);
            stmt.setObject(4, LocalDateTime.now()); // created_at

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Your comment has been successfully recorded!");
                System.out.println("Your comment: " + comment);
            } else {
                System.out.println("Failed to add comment.");
            }

        } catch (SQLException e) {
            System.out.println("Error while adding comment: " + e.getMessage());
        }
    }

    private static int getUserIdByUsername(String username) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT user_id FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("user_id");
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error fetching user ID: " + e.getMessage());
            return -1;
        }
    }
}
