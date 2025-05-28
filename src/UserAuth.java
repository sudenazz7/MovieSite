import db.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuth {
    static Scanner scanner = new Scanner(System.in);
    public static String username;

    public static void Auth() {
        System.out.println("\nWelcome to Our Movie Site!");
        System.out.println("To perform a transaction within the system, please select one of the following transactions!");

        while (true) {
            int choice;

            do {
                System.out.println("\nPlease choose your next step!");
                System.out.println("1. Sign up");
                System.out.println("2. Log in");
                System.out.println("3. Exit");
                System.out.print("Please enter your transaction: ");

                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.print("Invalid input. Please try again! (1, 2 or 3): ");
                }
                choice = scanner.nextInt();
                scanner.nextLine();

            } while (choice < 1 || choice > 3);

            switch (choice) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    String username = login();
                    if (username != null) {
                        DisplayMenu.menu(username);
                    }
                    break;
                case 3:
                    System.out.println("Logging off...");
                    System.exit(0);
            }
        }
    }

    static void createUserAccount() {
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        String email;
        boolean isExistingEmail;
        do {
            System.out.print("E-mail: ");
            email = scanner.nextLine();
            isExistingEmail = checkExistingEmail(email);
            if (isExistingEmail) {
                System.out.println("This email address is already registered. Please enter a different email.");
            }
        } while (isExistingEmail);

        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullName);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            System.out.println("Your account has been created successfully!");
        } catch (SQLException e) {
            System.out.println("An error occurred while creating the account: " + e.getMessage());
        }
    }

    static boolean checkExistingEmail(String email) {
        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error while checking email: " + e.getMessage());
            return true;
        }
    }

    static String login() {
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DatabaseConfig.connect()) {
            String sql = "SELECT username FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful. You may continue your transactions!");
                return rs.getString("username");
            } else {
                System.out.println("Invalid login! Please check your email or password.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return null;
        }
    }
}
