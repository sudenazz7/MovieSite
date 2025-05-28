import java.util.Scanner;

public class DisplayMenu {
    static int INDEX = 100;
    static String[][] users = new String[INDEX][3]; // fullName, email, password
    static Scanner scanner = new Scanner(System.in);

    public static void menu(String userName) {
        while(true) {

            System.out.println("\nHOME PAGE - Welcome, " + userName + "!");

            System.out.println("\n1. New Releases");
            System.out.println("2. Popular This Week");
            System.out.println("3. Movies");
            System.out.println("4. Series");
            System.out.println("5. User's Favorites");
            System.out.println("6. Exit");


            System.out.print("Please Enter Your Transaction: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // new releases
                    NewReleases.displayNewReleases();
                    break;

                case 2://POPULAR THIS WEEK
                    PopularThisWeek.displayPopularThisWeek();
                    System.out.println();
                    break;

                case 3://film
                    AllMovies.Movie(userName);
                    break;

                case 4://series
                    AllSeries.Series(userName);
                    break;
                case 5:
                    UsersFavourites.displayUsersFavourites();
                    break;

                case 6:// exit
                    System.out.println("You Have Exit Moive Site. See You Next Time!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice of Transaction! Please Try Again!");
                    break;


            }
        }
    }
}