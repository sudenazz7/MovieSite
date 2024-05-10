import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

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
            System.out.println();
            return index;
        }

        return -1;
    }
    static int invalidLoginCheck(String email, String password) {
        for (int i = 0; i < UserQuantity; i++) {
            if (users[i][1].equals(email) && users[i][2].equals(password)) {
                System.out.println("Login successful.You may continue your transactions!");
                return i;
            }
        }
        System.out.println("Invalid login! Please check your email or password!");
        return -1;
    }

    static void displayMenu(int loggedInUserIndex) {
        Scanner scanner= new Scanner(System.in);

        while(true){

        System.out.println("\n HOME PAGE: ");
        String userName = users[loggedInUserIndex][0];


            System.out.println("\n1. New Releases");
            System.out.println("2. Popular This Week");
            System.out.println("3. Movies");
            System.out.println("4. Series");
            System.out.println("5. Exit");


            System.out.print("Please Enter Your Transaction: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // new releases
                    displayNewReleases();

                    break;
                case 2://POPULAR THIS WEEK
                    popularThisWeek();
                    System.out.println();
                    break;

                case 3://film

                    break;

                case 4://dizi
                    series();
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

        System.out.println("1.A Man in Full ");
        System.out.println("2.Minions The Rise Of Gru ");
        System.out.println("3.Ölümlü Dünya 2");
        System.out.println("4.Dead Boy Detectiues ");
        System.out.println("5.Love,Divided ");
        System.out.println("6.Thank You,Next ");
        System.out.println("7.As The Crow Flies ");
        System.out.println("8.Parasyte The Grey ");
        System.out.println("9.Barbarian ");
        System.out.println("10.The Final: Attact On Wembley ");
        System.out.println("5.Back to Home Page");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                displayDeatilsForSeries("A Man in Full",
                        "Oscar winner Regina King executive-produced and directed \n" +
                                "three episodes of this drama series about a real estate\n" +
                                "mogul reclaiming his life and empire.",
                        "Jeff Daniels, Diane Lane, Tom Pelphrey",
                        "Regina King",
                        "Season 1 / 6 Episode");
                break;
            case 2:
                displayDeatilsForMovies("Minions The Rise Of Gru",
                        "Academy Award winners Alan Arkin and Julie Andrews lead a\n" +
                                "voice cast of all-stars in this fun and family-friendly supervillain\n" +
                                "origin story.",
                        "Steve Carell, Pierre Coffin, Alan Arkin",
                        "Kyle Balda, Brad Ableson, Jonathan del Val",
                        "1 Hour 27 Min");
                break;
            case 3:
                displayDeatilsForMovies("Ölümlü Dünya 2",
                        "When Zafer falls into the hands of the Organization, the\n" +
                                "Mermer clan of amiable assassins comes out of hiding to\n" +
                                "settle the score once and for all.",
                        "Ahmet Mumtaz Taylan, Alper Kul, Dogu Demirkol,\n" +
                                "Feyyaz Yigit Cakmak, Giray Altinok, irem Sak, Mehmet\n" +
                                "Ozgiir, Ozgiir Emre Yildirim, Sarp Apak, Reha Ozcan",
                        "Ali Atay",
                        "1 Hour 55 Min");
                break;
            case 4:
                displayDeatilsForSeries("Dead Boy Detectiues",
                        "Two teen ghosts work alongside a clairvoyant to solve mysteries\n" +
                                "for their supernatural clientele — until a powerful witch complicates\n" +
                                "their plans.",
                        "George Rexstrew, Jayden Revri, Kassius Nelson",
                        "Lee Toland Krieger",
                        "Season 1 / 8 Episode");
                break;
            case 5:
                displayDeatilsForMovies("Love,Divided",
                        "Valentina is a young pianist starting over. Her neighbor\n" +
                                "David is an inventor who hates noise. And a paper-thin wall\n" +
                                "is about to become their matchmaker.",
                        "Aitana,Fernando Guallar,\n" +
                                "Natalia Rodriguez",
                        "Patricia Font",
                        "1 Hour 38 Min");
                break;
            case 6:
                displayDeatilsForSeries("Thank You,Next",
                        "Newly single lawyer Leyla starts seeing Feyyaz, a chef she\n" +
                                "met while on vacation. At work, she takes on the divorce\n" +
                                "case of entrepreneur Cem Murathan.",
                        "Serenay Sarikaya,\n" +
                                "Metin Akdülger, Hakan Kurtas",
                        "Bertan Basaran",
                        "Season 1 / 8 Episode");
                break;
            case 7:
                displayDeatilsForSeries("As The Crow Flies",
                        "A longtime fan of respected news anchor Lale\n" +
                                "Kiran, Asli bluffs her way into an internship at\n" +
                                "Lale's office, determined to win the game.",
                        "Birce Akalay,\n" +
                                "Miray Daner, ibrahim Celikkol",
                        "Deniz Yorulmazer",
                        "Season 3 / 8 Episode");
                break;
            case 8:
                displayDeatilsForSeries("Parasyte The Grey",
                        "Parasites descend on Earth with a goal: infect \n" +
                                "and eat humans. But when one fails to fully \n" +
                                "infect a woman, the two must team up to stop \n" +
                                "the invaders.",
                        "Jeon So-nee,\n" +
                                "Koo Kyo-hwan, Lee Jung-hyun,",
                        "Yeon Sang-ho, Ryu Yong-jae",
                        "Season 1 / 6 Episode");
                break;
                case 9:
                displayDeatilsForMovies("Barbarian",
                        "A young woman arrives at her Detroit rental\n" +
                                "house to find it already occupied by an\n" +
                                "interloper — and by something far worse below\n" +
                                "the floorboards.",
                        "Georgina Campbell, Bill Skarsgard," +
                                "\nJustin Long",
                        "Zach Cregger",
                        "1 Hour 43 Min");
                break;
            case 10:
                displayDeatilsForMovies("The Final: Attact On Wembley",
                        "11 July, 2021. The Euros final was the biggest day in\n" +
                                "English football for over half a century — and ended in\n" +
                                "disaster, on and off the pitch.",
                        "Darren Lewis,Emma Saunders\n" +
                                "Liam Boylan ,Chris Bryant\n" +
                                "Carolyn Downs,Mike Keegan\n" +
                                "Chris Whyte",
                        "Rob Miller, Kwabena Oppong",
                        "1 Hour 22 Min");
                break;
            case 11:
                return;
            default:;
                System.out.println("Invalid Choice! Please Try Again!");
                break;

        }


    }

    public static void displayDeatilsForMovies(String title,String description,String cast,String director,String hour) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + title);
        System.out.println("\nDescription : " + description);
        System.out.println("\nCast : " + cast);
        System.out.println("\nDirector : " + director);
        System.out.println("\nHour/min : " + hour);


        System.out.println("\nWould you like to comment ? ");
        System.out.println("1-Yes\n2-No");
        int answer = scanner.nextInt();
        scanner.nextLine();


        if (answer == 1) {
            System.out.println("\nPlease write your comment");
            String comment = scanner.nextLine();
            System.out.println("Your comment: " + comment);
        }else {
            System.out.println("Returning to the home page..");
        }

    }
    public static void displayDeatilsForSeries(String title,String description,String cast,String director,String seasonepisode) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + title);
        System.out.println("\nDescription : " + description);
        System.out.println("\nCast : " + cast);
        System.out.println("\nDirector : " + director);
        System.out.println("\nSeason/Episode : " + seasonepisode);


        System.out.println("\nWould you like to comment ? ");
        System.out.println("1-Yes\n2-No");
        int answer = scanner.nextInt();
        scanner.nextLine();


        if (answer == 1) {
            System.out.println("\nPlease write your comment");
            String comment = scanner.nextLine();
            System.out.println("Your comment: " + comment);
        }else {
            System.out.println("Returning to the home page..");
        }

    }


    public static void popularThisWeek(){
        System.out.println("\n POPULAR THIS WEEK");

        System.out.println("1-) Ölümlü Dünya 2 ");
        System.out.println("2-) Honeymoonish");
        System.out.println("3-) Minions-2: Rise of Gru");
        System.out.println("4-) Barbarian");
        System.out.println("5-) Secrets of Neanderthals");
        System.out.println("6-) Fantastic Monsters Secrets of Dumbledore");
        System.out.println("7-) Unfrosted");
        System.out.println("8-) Ölümlü Dünya ");
        System.out.println("9-) Rebel Moon Part-II: The Scargiver");
        System.out.println("10-) The Black Phone");
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForMovies("Ölümlümlü Dünya 2",
                    "After Zafer falls into the hands of the organization, the sympathetic assassins of the Mermer family come out of hiding to settle their accounts with the organization once and for all.",
                    "Ahmet Mümtaz Taylan, Alper Kul, Doğu Deemirkol,Feyyaz Yiğit Çakmak, Giray Altınok, Özgür Emre Yıldırım, Sarp Apak,Reha Özcan.",
                    "Ali Atay","1 Hour 55 min.");
            break;
            case 2: displayDeatilsForMovies("Honeymoonish",
                    "A honeymooning couple in a rush to get married for unusual reasons; They learn that they have very little in common, but a lot to learn about each other.",
                    "Nour Al Ghandour, Mahmoud Boushahri, Faisal Almezel, Ascia, Mahdi Barwiz,Amal Mohammed, Ghorour, Reem Alnajem, Zaman Abdullah,Qahtan Alqahtani.",
                    "Eiad Saleh","1 Hour 40min");
            break;
            case 3: displayDeatilsForMovies("Minions-2: Rise of Gru",
                    "Rejected by his supervillain idols, 12-year-old Gru sets out to prove what a scoundrel he is with the help of his clumsy Minion crew.",
                    "Steve Carrel,Pierre Coffin,Alan Arkin,Taraji P. Henson, Michelle Yeoh, Julie Andrews, Russel Brand,Jean-Claude Van Damme, Dolph Lundgren, Danny Trejo, Lucy Lawless.",
                    "Matthew Fogel, Brian Lynch","1 Hour 27 min.");
            break;
            case 4: displayDeatilsForMovies("Barbarian",
                    "In this chilling horror movie, a woman discovers there's something sinister going on in a house she's renting.",
                    "Georgina Campbell, Bill Skarsgård, Justin Long, Matthew Patric Davis, Richard Brake, Jaymes Butler, Kurt Braunohler.",
                    "Zach Cregger","1 Hour 43 min.");
            break;
            case 5: displayDeatilsForMovies("Secrets of Neanderthals",
                    "In this informative documentary, experts investigate the lives and disappearances of Neanderthals.",
                    "Patric Stewart", "Ashley Gething","1 Hour 20 min.");
            break;
            case 6: displayDeatilsForMovies("Fantastic Monsters Secrets of Dumbledore",
                    "Award-winning actors Eddie Redmayne and Jude Law star as wizards battling evil and fantasy monsters in this \"delightful and magical\" film (The Guardian).",
                    "Eddie Redmayne,Jude Law, Mads Mikkelen, Ezra Miller, Dan Fogler, Alison Sudol, William Nadylam, Callum Turner, Jesica Williams, Victoria Yeates, Poppy Corby-Tuech, Fiona Glascott, Katherine Waterson. ",
                    "J.K. Rowling, Steve Kloves","2 Hour 22min.");
            break;
            case 7: displayDeatilsForMovies("Unfrosted",
                    "Jerry Seinfeld promises plenty of laughs and nostalgia in this screwball comedy about rival cereal companies vying for a game-changing breakfast donut.",
                    "Jerry Seinfeld, Melissa McCarthy, Jim Gaffigan, Hugh Grant, Amy Schumer.",
                    "Jerry Seinfeld, Spike Feresten, Andy Robin, Barry Marder",
                    "1 Hour 36min");
            break;
            case 8: displayDeatilsForMovies("Ölümlü Dünya",
                    "A family of hitmen and restaurant managers gets into big trouble when a mishap exposes their identities and angers their boss.",
                    "Ahmet Mümtaz Taylan, Alper Kul, Sarp Apak,İrem Sak, Feyyaz Yiğit Çakmak, Doğu Demirkol, Meltem Kaptan, Özgür Emre Yıldırım ",
                    "Ali Atay", "1 Hour 47 min");
            break;
            case 9: displayDeatilsForMovies("Rebel Moon Part-II: The Scargiver",
                    "From the director of \"300 Spartans,\" \"Man of Steel\" and \"Army of the Dead,\" a sci-fi action movie about a band of rebel warriors waging an impossible resistance.",
                    "Sofia Boutella, Djimon Hounsou, Ed Skrein, Anthony Hopkins,Michiel Huisman.",
                    "Zack Synder", "2 Hour 3 min");
            break;
            case 10:
                displayDeatilsForMovies("The Black Phone",
                        "A boy is snatched by a masked man in broad daylight. In the soundproof\n" +
                                "basement where he's held, a telephone rings — it's the killer's previous\n" +
                                "victims.",
                        "Mason Thames, Madeleine\n" +
                                "McGraw, Ethan Hawke",
                        "Scott Derrickson",
                        "1 Hour 45 Min");
                break;

        }

    }

    public static void series(){
        System.out.println("\n SERIES: ");
        System.out.println("1-) Display All Series");
        System.out.println("2-) Choose a Catagory");
        System.out.println("3-) Back To Home Page");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        int choice = scanner.nextInt();
        switch(choice){
            case 1: allSeriesArray();break;
            case 2: ;break;
            case 3: return;
            default: System.out.println("Invalid Choice, please try again.");

        }
    }

    public static void allSeriesArray(){
        String[] seriesArray= {"1- Lupin", "2-The Walking Dead", "3- Narcos","4- The Protector", "5- La Casa De Papel\n",
                "6- Stranger Things", "7- Chilling Adventures of Sabrina", "8- Hellbound", "9- Parasyte", "10- Van Helsing\n",
        "11- Bir Erkek Bir Kadın", "12- Emily in Paris", "13- Friends", "14- How I Met Your Mother (HIMYM)", "15- Orange Is The New Black\n",
        "16- Thank You Next", "17- Bridgerton", "18- One Day", "19- Shahmaran", "20- Ginny & Georgia\n",
        "21- Lucifer", "22- The Witcher", "23- One Piece", "24- Wednesday", "25- Locke & Key\n",
        "26- SpongeBob Squarepants", "27- Miraculous: Tales of Ladybug and Cat Noir","28- Ben10", "29- Adventure Time", "30- World of Winx"};

        for(int i=0;i<seriesArray.length;i++){
            System.out.println(seriesArray[i]);
        }
    }

    public static void main(String[] args) {
        userHints();
    }
}