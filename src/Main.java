import java.util.Scanner;

public class Main {

    static int INDEX = 100;
    static int MovieQuantity = 0; //film sayısı
    static int SeriesQuantity = 0;//dizi sayısı
    static int transactionQuantity = 0;//işlem sayısı ???
    static int UserQuantity = 0; //kullanıcı sayısı
    static String[][] series = new String[INDEX][6]; // title, topic,cast, director, season+episode , comment
    static String[][]  movies= new String[INDEX][6]; // title, topic,cast, director, time , comment
    static String[][] users = new String[INDEX][3]; // fullName, email, password
    static Scanner scanner = new Scanner(System.in);

    static void userHints(){

        System.out.println("\nWelcome to Our Movive Site!");
        System.out.println("To perform a transaction within the system, please select one of the following transactions!");
        while (true) {
            int choice;

            do {
                System.out.println("Please choose your next step!");
                System.out.println("1. Sign up");
                System.out.println("2. Log in");
                System.out.println("3. Exit");
                System.out.print("Please enter your transaction!: ");

                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.print("Invalid input. Please try again! (1,2 or 3): ");
                }
                choice = scanner.nextInt();
                scanner.nextLine();

            } while (choice < 1 || choice > 3);

            switch (choice) {
                case 1:
                    createUserAccount();
                    break;
                case 2:

                    int loggedInUserIndex = login();
                    if (loggedInUserIndex != -1) {
                        displayMenu(loggedInUserIndex);
                    }
                    break;
                case 3:
                    System.out.println("Loggin off...");
                    System.exit(0);
            }
        }
    }
    static void createUserAccount(){
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        users[UserQuantity][0] = fullName;
        users[UserQuantity][1] = email;
        users[UserQuantity][2] = password;
        UserQuantity++;

        System.out.println("Your account has been created succesfully!");

    }

    static int login(){
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        int index = invalidLoginCheck(email, password);
        if (index!=-1){
            System.out.println("Logged in successfully! You may continue your transactions!");
            return index;
        }

        return -1;
    }
    static int invalidLoginCheck(String email, String password) {
        for (int i = 0; i < UserQuantity; i++) {
            if (users[i][1].equals(email) && users[i][2].equals(password)) {
                System.out.println("Login successful. You can proceed!");
                return i;
            }
        }
        System.out.println("Invalid login! Please check your email or password!");
        return -1;
    }

    static void displayMenu(int loggedInUserIndex) {

        System.out.println("\n HOME PAGE: ");
        String userName = users[loggedInUserIndex][0];

        while (true) {

            System.out.println("\n1. New Releases");
            System.out.println("2. Populer This Week");
            System.out.println("3. Movies");
            System.out.println("4. Series");
            System.out.println("5. Exit");


            System.out.print("Please Enter Your Transaction: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // new releases

                    break;
                case 2://POPULAR THIS WEEK
                    System.out.println();
                    break;

                case 3://film

                    break;

                case 4://dizi

                    break;

                case 5:// exit
                    System.out.println("You Have Exit Moive Site. See You Next Time!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice of Transaction! Please Try Again!");

                    break;


            }

        }
    }

    public static void displayNewReleases(){
        System.out.println("\n NEW RELEAES");

    }

    public static void popularThisWeek(){
        System.out.println("\n POPULAR THIS WEEK");



    }

    public static void main(String[] args) {
        userHints();
    }
}