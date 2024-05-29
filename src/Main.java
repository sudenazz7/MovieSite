import java.util.Scanner;

public class Main {

    static int INDEX = 100;
    static int UserQuantity = 0; //kullanıcı sayısı
    static String[][] users = new String[INDEX][3]; // fullName, email, password
    static Scanner scanner = new Scanner(System.in);

    static void userHints(){

        System.out.println("\nWelcome to Our Movie Site!");
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

        }while(isExistingEmail);

        System.out.print("Password: ");
        String password = scanner.nextLine();

        users[UserQuantity][0] = fullName;
        users[UserQuantity][1] = email;
        users[UserQuantity][2] = password;
        UserQuantity++;

        System.out.println("Your account has been created succesfully!");

    }

    static boolean checkExistingEmail(String email){
        for(int i=0 ;i<UserQuantity ; i++){
            if(users[i][1].equals(email)){
                return true;
            }
        }
        return false;
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
            System.out.println("5. User's Favorites");
            System.out.println("6. Exit");


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
                    Movie();

                    break;

                case 4://series
                    series();
                    break;
                case 5://usersfavorites
                    usersFavorites();
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
        System.out.println("11.Back to Home Page");
        System.out.println();
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


        System.out.println("\nHow much did you like the movie?");
        System.out.println("1-I didn't like 😔\n2-I liked 🙂\n3-I loved 😍");
        int userRating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Thank you for your answer :) ");


        System.out.println("\nWould you like to comment ? ");
        System.out.println("1-Yes\n2-No");
        int answer = scanner.nextInt();
        scanner.nextLine();

        if (answer == 1) {
            System.out.println("\nPlease write your comment");
            String comment = scanner.nextLine();
            System.out.println("Your comment has received successfully! Your comment: " + comment);
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


        System.out.println("\nHow much did you like the movie?");
        System.out.println("1-I didn't like 😔\n2-I liked 🙂\n3-I loved 😍");
        int userRating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Thank you for your answer :) ");



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
        System.out.println("11-) Back to Home Page");
        System.out.println();
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

    public static void Movie(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("\nMOVIES");
        System.out.println("1-Display All Movies");
        System.out.println("2-Choose a Category");
        System.out.println("3-");
        System.out.println("3-Back to Home Page");
        System.out.println();
        System.out.print("Please Enter your Transaction : ");



        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1: //Tüm filmleri yaz
                AllMovieArray();
                break;
            case 2: // Katogorileri yaz
                chooseCatagoryForMovie();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice! Please Try Again!");

        }

    }

    public static void AllMovieArray() {

        Scanner scanner = new Scanner(System.in);

        String[] movieArray = {"1-Heart Parade ", "2-In Good Hands ", "3-Love Tactics ", "4-Last Call For Istanbul ", "5-Ashes\n",
                "6-Red Notice ", "7-Extraction ", "8-Fast and Furious 7 ", "9-The Maze Runner ", "10-Now You See Me\n",
                "11-Countdown ", "12-Bird Box ", "13-Blood Red Sky ", "14-Ghost Lab ", "15-Mirrors\n",
                "16-My Travel Buddy ", "17-Recep Ivedik ", "18-Hababam Class ", "19-We Can Be Herdes ", "20-Little Man\n",
                "21-I Am Mother ", "22-Mirage ", "23-Paradise ", "24-After Earth ", "25-Extinction\n",
                "26-Boss Baby ", "27-Madagascar ", "28-Alvin And The Chipmunks (Chipwrecked) ", "29-My Little Pony ", "30-Barbie Dolphin Magic\n"};


        String[][] movieDetails = {
                {"-Heart Parade-", "The promotion, the engagement — she has her life all planned out.\n" +
                        "An unexpected trip to Krakow and a romance with a charming\n" +
                        "widower? Not on the agenda.",
                        "Anna Prochniak, Michal\n" +
                                "Czernecki, lwo Rajski",
                        "Filip Zylber",
                        "1 Hour 48 Min"},
                {"-In Good Hands-", "Melisa, a single mother, is sick and has very little time left to live.\n" +
                        " Will she be able to have a whirlwind \n" +
                        "love affair and find a man to whom she can entrust her son \n" +
                        "Can in this short time?",
                        "Asli Enver, Kaan\n" +
                                "Urgancioglu, Mert Ege Ak",
                        "Ketche Hakan Kirvavag",
                        "1 Hour 45 Min"},
                {"-Love Tactics-", "She's a blogging fashionista who doesn't believe in love.\n" +
                        "He's a serial dater with clear attachment issues. A romantic\n" +
                        "airport scene lies in store.",
                        "Demet Ozdemir, Şükrü\n" +
                                "Özyılmaz, Atakan Çelik",
                        "Emre Kabakuşak",
                        "1 Hour 48 Min"},
                {"-Last Call For Istanbul-", "Beren Saat and Kivang Tatlitug stumble into a forbidden\n" +
                        "romance when they meet as two married people with\n" +
                        "magnetic chemistry in New York City.",
                        "Kıvanç Tatlıtuğ,Beren Saat",
                        "Gönenç Uyanık",
                        "1 Hour 31 Min"},
                {"-Ashes-",
                        "A married and wealthy woman starts reading an unpublished novel. \n" +
                                "However, dizzying fantasies turn into a dangerous\n" +
                                " forbidden love and destroy the woman's life.",
                        "Funda Eryiğit, Alperen Duymaz, Mehmet Günsür",
                        "Erdem Tepegöz",
                        "1 Hour 40 Min"},
                {"-Red Notice-", "In this globe-trotting action adventure, a daring heist brings\n" +
                        "together the FBI's top profiler and two rival art thieves.",
                        "Dwayne Johnson,\n" +
                                "Ryan Reynolds, Gal Gadot",
                        "Rawson Marshall Thurber",
                        "1 Hour 58 Min"},
                {"-Extraction-", "In this gritty action thriller, an elite soldier-for-hire sets out\n" +
                        "to rescue the kidnapped son of a drug lord.",
                        "Chris Hemsworth,\n" +
                                "Rudhraksh Jaiswal,\n" +
                                "Randeep Hooda",
                        "Sam Hargrave",
                        "1 Hour 58 Min"},
                {"-Fast and Furious 7-", "Haunted by his past and driven by loyalty, a street racer- \n" +
                        "turned-vigilante must team up with an unlikely ally to take \n" +
                        "down an elusive assassin.",
                        "Vin Diesel, Paul\n" +
                                "Walker, Dwayne Johnson",
                        "James Wan",
                        "2 Hour 17 Min"},
                {"-The Maze Runner-", "Trapped in a maze without memory of the outside world,\n" +
                        "they fight to survive. But a mysterious newcomer could\n" +
                        "hold the key to their escape.",
                        "Dylan O'Brien, Kaya\n" +
                                "Scodelario, Thomas Brodie-Sangster",
                        "Wes Ball",
                        "1 Hour 54 Min"},
                {"-Now You See Me-", "A troupe of brainy illusionists specialize in stealing from\n" +
                        "banks and giving the cash to their audiences, all while\n" +
                        "outwitting a team of FBI agents.",
                        "Jesse Eisenberg, Mark \n" +
                                "Ruffalo, Woody Harrelson",
                        "Louis Leterrier",
                        "1 Hour 55 Min"},
                {"-Countdown-", "When a nurse downloads an app that predicts the user's\n" +
                        "exact time of death, she discovers she has three days to\n" +
                        "beat the clock and change her fate.",
                        "Jordan Calloway,\n" +
                                "Peter Facinelli, Tichina Arnold",
                        "Justin Dec",
                        "1 Hour 30 Min"},
                {"-Bird Box-", "A mother hell-bent on saving her kids from a terrifying\n" +
                        "unseen force sets out on a dangerous journey in this\n" +
                        "dystopian thriller starring Sandra Bullock.",
                        "Sandra Bullock,\n" +
                                "Trevante Rhodes, John Malkovich",
                        "Susanne Bier",
                        "2 Hour 4 Min"},
                {"-Blood Red Sky-", "They had a perfect plan: hijack a plane and hold the\n" +
                        "passengers ransom. But there’s another threat on board...\n" +
                        "and she’s far more deadly.",
                        "Peri Baumeister,\n" +
                                "Alexander Scheer, Kais Setti",
                        "Peter Thorwarth",
                        "2 Hour 3 Min"},
                {"-Ghost Lab-", "After witnessing a haunting in their hospital, two doctors\n" +
                        "become dangerously obsessed with obtaining scientific\n" +
                        "proof that ghosts exist.",
                        "Thanapob Leeratanakachorn,\n" +
                                "Paris Intarakomalyasut, Nuttanicha\n" +
                                "Dungwattanawanich",
                        "Paween Purijitpanya",
                        "1 Hour 57 Min"},
                {"-Mirrors-", "A troubled ex-cop working as a night security " +
                        "guard discovers malevolent\n" +
                        "spirits haunting the mirrors of a fire-ravaged " +
                        "department store.",
                        "Kiefer Sutherland, Paula\n" +
                                "Patton, Cameron Boyce",
                        "Alexandre Aja",
                        "1 Hour 51 Min"},
                {"-My Travel Buddy-", "Days before Eid, a salesman fired from his job drives to Ayvalik to meet his\n" +
                        "girlfriend's family, but the trip goes astray due to his zany travel buddy.",
                        "Oguzhan Koç, İbrahim\n" +
                                "Büyükak, Emre Kınay",
                        "Bedran Güzel",
                        "1 Hour 57 Min"},
                {"-Recep Ivedik-", "A man finds the wallet of a rich man and takes a rigorous trip in an old car to\n" +
                        "return it, finding an old love and a new life of luxury awaiting.",
                        "Şahan Gökbakar, Fatma Toptaş, Tuluğ Çizgen",
                        "Togan Gokbakar",
                        "1 Hour 41 Min"},
                {"-Hababam Class-", "When Private Camlica High School turns co-ed, chaos and a heated rivalry\n" +
                        "between the girls and boys ensue.",
                        "Altan Erkekli, Toygan Avanoğlu,\n Hande Katipoğlu",
                        "Doğa Can Anafarta",
                        "1 Hour 46 Min"},
                {"-We Can Be Herdes-", "This 2020 action-adventure family film based on \"The Adventures of\n" +
                        "Sharkboy and Lavagirl\" features Pedro Pascal and Priyanka Chopra.",
                        "YaYa Gosselin, Pedro Pascal,\n" +
                                "Priyanka Chopra Jonas",
                        "Robert Rodrigue",
                        "1 Hour 40 Min"},
                {"-Little Man-", "A man is so eager to become a dad that he'll believe anything, including the\n" +
                        "notion that a baby-faced thief on the lam is really an abandoned toddler.",
                        "Marlon Wayans, Shawn Wayans, Kerry Washington",
                        "Keenen Ivory Wayans",
                        "1 Hour 37 Min"},
                {"-I Am Mother-", "Following humanity's mass extinction, a teen raised alone by a maternal\n" +
                        "droid finds her entire world shaken when she encounters another human.",
                        "Clara Rugaard, Rose Byrne,\n" +
                                "Hilary Swank",
                        "Grant Sputore",
                        "1 Hour 53 Min"},
                {"-Mirage-", "When a caring nurse alters the past to save a life, her present reality shifts to\n" +
                        "a new timeline — one without her beloved daughter.",
                        "Adriana Ugarte, Chino Darin,\n" +
                                "Javier Gutiérrez",
                        "Oriol Paulo",
                        "2 Hour 9 Min"},
                {"-Paradise-", "In the future, new technology lets people sell years of their lives to\n" +
                        "others — with terrifying consequences for those who have no\n" +
                        "other options left.",
                        "Kostja Ullmann, Corinna\n" +
                                "Kirchhoff, Marlene Tanczik ",
                        "Boris Kunz",
                        "1 Hour 58 Min"},
                {"-After Earth-", "After crash-landing on the long-abandoned planet Earth, a young\n" +
                        "boy sets out to find a beacon that will save him -- and his dying\n" +
                        "father -- from doom.",
                        "Jaden Smith, Will Smith,\n" +
                                "Sophie Okonedo",
                        "M. Night Shyamalan",
                        "1 Hour 40 Min"},
                {"-Extinction-", "Plagued by dreams of an alien invasion, a family man faces his\n" +
                        "worst nightmare when an extraterrestrial force begins\n" +
                        "exterminating Earth's inhabitants.",
                        "Michael Pefia, Lizzy Caplan,\n" +
                                "Israel Broussard",
                        "Ben Young",
                        "1 Hour 45 Min"},
                {"-Boss Baby-", "A kid finds himself at the center of a sinister corporate plot when\n" +
                        "his parents bring home a baby who only talks business when\n" +
                        "they're not around.",
                        "Alec Baldwin, Lisa Kudrow,\n" +
                                "Jimmy Kimmel",
                        "Tom McGrath",
                        "1 Hour 37 Min"},
                {"-Madagascar-", "Four animal friends get a taste of the wild life when they break out \n" +
                        "of captivity at the Central Park Zoo and wash ashore on the island \n" +
                        "of Madagascar.",
                        "Ben Stiller, Chris Rock,\n " +
                                "David Schwimmer",
                        "Eric Darnell, Tom McGrath",
                        "1 Hour 26 Min"},
                {"-Alvin And The Chipmunks (Chipwrecked)", "After boarding a cruise liner for a family vacation, the Chipmunks\n" +
                        "and the Chipettes end up castaways on a deserted island... but\n" +
                        "they're not alone!",
                        "Jason Lee, David Cross, \n" +
                                "Jenny Slate",
                        "Mike Mitchell",
                        "1 Hour 27 Min"},
                {"-My Little Pony-", "Equestria's divided. But a bright-eyed hero believes Earth Ponies,\n" +
                        "Pegasi and Unicorns should be pals — and, hoof to heart, she's \n" +
                        "determined to prove it.",
                        "Vanessa Hudgens, Kimiko Glenn, \n James Marsden",
                        "Robert Cullen, José Luis Ucha",
                        "1 Hour 31 Min"},
                {"-Barbie Dolphin Magic-", "While visiting Ken and exploring a coral reef, Barbie and her sisters\n" +
                        "make an amazing discovery and meet a mysterious new friend.",
                        "Erica Lindbeck, Shannon\n" +
                                "Chan-Kent, Kazumi Evans",
                        "Conrad Helten",
                        "1 Hour 4 Min"}
        };


        for (int i = 0; i < movieArray.length; i++) {
            System.out.println(movieArray[i]);
        }

        int choice = -1;

        while (choice<1 || choice> movieArray.length){
            System.out.print("Choose a movie between 1-30 :");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice<1 || choice> movieArray.length){
                    System.out.println("Invalid Choice! Please choose a number between 1-30. ");
                }
            }else {
                System.out.println("Invalid choice!Please enter a number.");
                scanner.next();
            }
        }

        scanner.nextLine();

        if (choice >= 1 && choice <= movieDetails.length) {
            String[] details = movieDetails[choice - 1];
            System.out.println("\n" + details[0]);
            System.out.println("\nDescription: " + details[1]);
            System.out.println("\nCast: " + details[2]);
            System.out.println("\nDirector: " + details[3]);
            System.out.println("\nTime: " + details[4]);
        } else
            System.out.println("Invalid Choice");


        System.out.println("\nHow much did you like the movie?");
        System.out.println("1-I didn't like 😔\n2-I liked 🙂\n3-I loved 😍");
        int userRating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Thank you for your answer :) ");

        System.out.println("\nWould you like to comment ? ");
        System.out.println("1-Yes\n2-No");
        int answer = scanner.nextInt();
        scanner.nextLine();


        if (answer == 1) {
            System.out.println("\nPlease write your comment");
            String comment = scanner.nextLine();
            System.out.println("Your comment: " + comment);
        } else {
            System.out.println("Returning to the home page..");

        }

    }
    public static void chooseCatagoryForMovie(){

        System.out.println("Choose a Catagory");
        System.out.println("1-Romantic");
        System.out.println("2-Action");
        System.out.println("3-Horror and Thriller");
        System.out.println("4-Sci-Fi and Fantasy");
        System.out.println("5-Comedy");
        System.out.println("6-Family and Kids" + "\n" );

        int choice = scanner.nextInt();

        switch(choice){

            case 1:displayRomanticMovies(); break;
            case 2:displayActionMovie(); break;
            case 3:displayHorrorMovies(); break;
            case 4:displayFantasyMovies(); break;
            case 5:displayComedyMovies(); break;
            case 6:displayKidsMovies(); break;


        }
    }

    public static void displayRomanticMovies(){
        String [] romanticMovies = {"-- Romantic Movies --\n","1-Heart Parade ", "2-In Good Hands ", "3-Love Tactics ",
                "4-Last Call For Istanbul ", "5-Ashes","6-Return to previos page..."};

        for(int i=0;i<romanticMovies.length;i++){
            System.out.println(romanticMovies[i]);
        }
        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();


        switch(choice){
            case 1: displayDeatilsForMovies("-Heart Parade-",
                    "The promotion, the engagement — she has her life all planned out.\n" +
                            "An unexpected trip to Krakow and a romance with a charming\n" +
                            "widower? Not on the agenda.",
                    "Anna Prochniak, Michal\n" +
                            "Czernecki, lwo Rajski",
                    "Filip Zylber",
                    "1 Hour 48 Min");
                break;
            case 2:displayDeatilsForMovies("-In Good Hands-","Melisa, a single mother, is sick and has very little time left to live.\n" +
                            " Will she be able to have a whirlwind \n" +
                            "love affair and find a man to whom she can entrust her son \n" +
                            "Can in this short time?",
                    "Aslı Enver, Kaan\n" +
                            "Urgancıoğlu, Mert Ege Ak",
                    "Ketche Hakan Kırvavaç",
                    "1 Hour 45 Min");
                break;
            case 3:displayDeatilsForMovies("-Love Tactics-", "She's a blogging fashionista who doesn't believe in love.\n" +
                            "He's a serial dater with clear attachment issues. A romantic\n" +
                            "airport scene lies in store.",
                    "Demet Ozdemir, Şükrü\n" +
                            "Özyılmaz, Atakan Çelik",
                    "Emre Kabakuşak",
                    "1 Hour 48 Min");
                break;
            case 4:displayDeatilsForMovies("-Last Call For Istanbul-", "Beren Saat and Kivang Tatlitug stumble into a forbidden\n" +
                            "romance when they meet as two married people with\n" +
                            "magnetic chemistry in New York City.",
                    "Kıvanç Tatlıtuğ,Beren Saat",
                    "Gönenç Uyanık",
                    "1 Hour 31 Min");
                break;
            case 5:displayDeatilsForMovies("-Ashes-",
                    "A married and wealthy woman starts reading an unpublished novel. \n" +
                            "However, dizzying fantasies turn into a dangerous\n" +
                            " forbidden love and destroy the woman's life.",
                    "Funda Eryiğit, Alperen Duymaz, Mehmet Günsür",
                    "Erdem Tepegöz",
                    "1 Hour 40 Min");
                break;
            case 6: return;
            default:
                System.out.println("Invalid choice.Please try again!");
        }


    }
    public static void displayActionMovie(){
        String [] actionMovie = { "-- Action Movies --\n","1-Red Notice-", "2-Extraction ", "3-Fast and Furious 7 ", "4-The Maze Runner ", "5-Now You See Me","6-Return to previous page"};
        for(int i=0;i<actionMovie.length;i++){
            System.out.println(actionMovie[i]);
        }

        System.out.print("\nEnter Your Choice:");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:displayDeatilsForMovies("-Red Notice-", "In this globe-trotting action adventure, a daring heist brings\n" +
                            "together the FBI's top profiler and two rival art thieves.",
                    "Dwayne Johnson,\n" +
                            "Ryan Reynolds, Gal Gadot",
                    "Rawson Marshall Thurber",
                    "1 Hour 58 Min");
            break;
            case 2:displayDeatilsForMovies("-Extraction-", "In this gritty action thriller, an elite soldier-for-hire sets out\n" +
                            "to rescue the kidnapped son of a drug lord.",
                    "Chris Hemsworth,\n" +
                            "Rudhraksh Jaiswal,\n" +
                            "Randeep Hooda",
                    "Sam Hargrave",
                    "1 Hour 58 Min");
            break;
            case 3:displayDeatilsForMovies("-Fast and Furious 7-", "Haunted by his past and driven by loyalty, a street racer- \n" +
                            "turned-vigilante must team up with an unlikely ally to take \n" +
                            "down an elusive assassin.",
                    "Vin Diesel, Paul\n" +
                            "Walker, Dwayne Johnson",
                    "James Wan",
                    "2 Hour 17 Min");
            break;
            case 4:displayDeatilsForMovies("-The Maze Runner-", "Trapped in a maze without memory of the outside world,\n" +
                            "they fight to survive. But a mysterious newcomer could\n" +
                            "hold the key to their escape.",
                    "Dylan O'Brien, Kaya\n" +
                            "Scodelario, Thomas Brodie-Sangster",
                    "Wes Ball",
                    "1 Hour 54 Min");
            case 5:displayDeatilsForMovies("-Now You See Me-", "A troupe of brainy illusionists specialize in stealing from\n" +
                            "banks and giving the cash to their audiences, all while\n" +
                            "outwitting a team of FBI agents.",
                    "Jesse Eisenberg, Mark \n" +
                            "Ruffalo, Woody Harrelson",
                    "Louis Leterrier",
                    "1 Hour 55 Min");
            break;
            case 6: return;
            default:
                System.out.println("Invalid choice.Please try again!");
        }

    }

    public static void displayHorrorMovies(){
        String [] horrorMovie = {"-- Horror and Thriller Movies --\n","1-Countdown", "2-Bird Box ", "3-Blood Red Sky ", "4-Ghost Lab ", "5-Mirrors","6-Return to pervious page..."};
        for(int i=0;i<horrorMovie.length;i++){
            System.out.println(horrorMovie[i]);
        }

        System.out.print("\nEnter a Choice: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:displayDeatilsForMovies("-Countdown-", "When a nurse downloads an app that predicts the user's\n" +
                            "exact time of death, she discovers she has three days to\n" +
                            "beat the clock and change her fate.",
                    "Jordan Calloway,\n" +
                            "Peter Facinelli, Tichina Arnold",
                    "Justin Dec",
                    "1 Hour 30 Min");
                break;
            case 2:displayDeatilsForMovies("-Bird Box-", "A mother hell-bent on saving her kids from a terrifying\n" +
                            "unseen force sets out on a dangerous journey in this\n" +
                            "dystopian thriller starring Sandra Bullock.",
                    "Sandra Bullock,\n" +
                            "Trevante Rhodes, John Malkovich",
                    "Susanne Bier",
                    "2 Hour 4 Min");
                break;
            case 3:displayDeatilsForMovies("-Blood Red Sky-", "They had a perfect plan: hijack a plane and hold the\n" +
                            "passengers ransom. But there’s another threat on board...\n" +
                            "and she’s far more deadly.",
                    "Peri Baumeister,\n" +
                            "Alexander Scheer, Kais Setti",
                    "Peter Thorwarth",
                    "2 Hour 3 Min");
                break;
            case 4:displayDeatilsForMovies("-Ghost Lab-", "After witnessing a haunting in their hospital, two doctors\n" +
                            "become dangerously obsessed with obtaining scientific\n" +
                            "proof that ghosts exist.",
                    "Thanapob Leeratanakachorn,\n" +
                            "Paris Intarakomalyasut, Nuttanicha\n" +
                            "Dungwattanawanich",
                    "Paween Purijitpanya",
                    "1 Hour 57 Min");
                break;
            case 5:displayDeatilsForMovies("-Mirrors-", "A troubled ex-cop working as a night security " +
                            "guard discovers malevolent\n" +
                            "spirits haunting the mirrors of a fire-ravaged " +
                            "department store.",
                    "Kiefer Sutherland, Paula\n" +
                            "Patton, Cameron Boyce",
                    "Alexandre Aja",
                    "1 Hour 51 Min");
                break;
            case 6: return;
            default:
                System.out.println("Invalid choice.Please try again.");
        }


    }
    public static void displayComedyMovies(){
        String [] comedyMovie = {"-- Comedy Movies --\n","1-My Travel Buddy ", "2-Recep Ivedik ", "3-Hababam Class ", "4-We Can Be Herdes ", "5-Little Man","Return to previous page..."};
        for(int i=0;i<comedyMovie.length;i++){
            System.out.println(comedyMovie[i]);
        }

        System.out.print("\nEnter a Choice:");
        int choice= scanner.nextInt();;

        switch (choice){
            case 1:displayDeatilsForMovies("-My Travel Buddy-", "Days before Eid, a salesman fired from his job drives to Ayvalik to meet his\n" +
                            "girlfriend's family, but the trip goes astray due to his zany travel buddy.",
                    "Oguzhan Koç, İbrahim\n" +
                            "Büyükak, Emre Kınay",
                    "Bedran Güzel",
                    "1 Hour 57 Min");
                break;
            case 2:displayDeatilsForMovies("-Recep Ivedik-", "A man finds the wallet of a rich man and takes a rigorous trip in an old car to\n" +
                            "return it, finding an old love and a new life of luxury awaiting.",
                    "Şahan Gökbakar, Fatma Toptaş, Tuluğ Çizgen",
                    "Togan Gokbakar",
                    "1 Hour 41 Min");
                break;
            case 3:displayDeatilsForMovies("-Hababam Class-", "When Private Camlica High School turns co-ed, chaos and a heated rivalry\n" +
                            "between the girls and boys ensue.",
                    "Altan Erkekli, Toygan Avanoğlu,\n Hande Katipoğlu",
                    "Doğa Can Anafarta",
                    "1 Hour 46 Min");
                break;
            case 4:displayDeatilsForMovies("-We Can Be Herdes-", "This 2020 action-adventure family film based on \"The Adventures of\n" +
                            "Sharkboy and Lavagirl\" features Pedro Pascal and Priyanka Chopra.",
                    "YaYa Gosselin, Pedro Pascal,\n" +
                            "Priyanka Chopra Jonas",
                    "Robert Rodrigue",
                    "1 Hour 40 Min");
                break;
            case 5:displayDeatilsForMovies("-Little Man-", "A man is so eager to become a dad that he'll believe anything, including the\n" +
                            "notion that a baby-faced thief on the lam is really an abandoned toddler.",
                    "Marlon Wayans, Shawn Wayans, Kerry Washington",
                    "Keenen Ivory Wayans",
                    "1 Hour 37 Min");
                break;
            case 6: return;
            default:
                System.out.println("Invalid choice.Please try again.");
        }


    }
    public static void displayFantasyMovies(){
        String [] fantasyMovie = {"-- Sci-Fi and Fantasy Movies --\n","1-I Am Mother ", "2-Mirage ", "3-Paradise ", "4-After Earth ", "5-Extinction","6-Return to previous page..."};
        for(int i=0;i< fantasyMovie.length;i++){
            System.out.println(fantasyMovie[i]);
        }
        System.out.print("\nEnter a Choice: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1: displayDeatilsForMovies("-I Am Mother-", "Following humanity's mass extinction, a teen raised alone by a maternal\n" +
                            "droid finds her entire world shaken when she encounters another human.",
                    "Clara Rugaard, Rose Byrne,\n" +
                            "Hilary Swank",
                    "Grant Sputore",
                    "1 Hour 53 Min");
                break;
            case 2:displayDeatilsForMovies("-Mirage-", "When a caring nurse alters the past to save a life, her present reality shifts to\n" +
                            "a new timeline — one without her beloved daughter.",
                    "Adriana Ugarte, Chino Darin,\n" +
                            "Javier Gutiérrez",
                    "Oriol Paulo",
                    "2 Hour 9 Min");
                break;
            case 3:displayDeatilsForMovies("-Paradise-", "In the future, new technology lets people sell years of their lives to\n" +
                            "others — with terrifying consequences for those who have no\n" +
                            "other options left.",
                    "Kostja Ullmann, Corinna\n" +
                            "Kirchhoff, Marlene Tanczik ",
                    "Boris Kunz",
                    "1 Hour 58 Min");
                break;
            case 4:displayDeatilsForMovies("-After Earth-", "After crash-landing on the long-abandoned planet Earth, a young\n" +
                            "boy sets out to find a beacon that will save him -- and his dying\n" +
                            "father -- from doom.",
                    "Jaden Smith, Will Smith,\n" +
                            "Sophie Okonedo",
                    "M. Night Shyamalan",
                    "1 Hour 40 Min");
                break;
            case 5:displayDeatilsForMovies("-Extinction-", "Plagued by dreams of an alien invasion, a family man faces his\n" +
                            "worst nightmare when an extraterrestrial force begins\n" +
                            "exterminating Earth's inhabitants.",
                    "Michael Pefia, Lizzy Caplan,\n" +
                            "Israel Broussard",
                    "Ben Young",
                    "1 Hour 45 Min");
                break;
            case 6: return;
            default:
                System.out.println("Invalid choice.Please try again.");

        }
    }

    public static void displayKidsMovies(){
        String [] kidsMovie ={"-- Family and Kids --\n","-Kids Movie-\n","1-Boss Baby ", "2-Madagascar ", "3-Alvin And The Chipmunks (Chipwrecked) ", "4-My Little Pony ", "5-Barbie Dolphin Magic","6-Return to previous page..."};
        for(int i=0;i<kidsMovie.length;i++){
            System.out.println(kidsMovie[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:displayDeatilsForMovies("-Boss Baby-", "A kid finds himself at the center of a sinister corporate plot when\n" +
                            "his parents bring home a baby who only talks business when\n" +
                            "they're not around.",
                    "Alec Baldwin, Lisa Kudrow,\n" +
                            "Jimmy Kimmel",
                    "Tom McGrath",
                    "1 Hour 37 Min");
                break;
            case 2:displayDeatilsForMovies("-Madagascar-", "Four animal friends get a taste of the wild life when they break out \n" +
                            "of captivity at the Central Park Zoo and wash ashore on the island \n" +
                            "of Madagascar.",
                    "Ben Stiller, Chris Rock,\n " +
                            "David Schwimmer",
                    "Eric Darnell, Tom McGrath",
                    "1 Hour 26 Min");
                break;
            case 3:displayDeatilsForMovies("-Alvin And The Chipmunks (Chipwrecked)", "After boarding a cruise liner for a family vacation, the Chipmunks\n" +
                            "and the Chipettes end up castaways on a deserted island... but\n" +
                            "they're not alone!",
                    "Jason Lee, David Cross, \n" +
                            "Jenny Slate",
                    "Mike Mitchell",
                    "1 Hour 27 Min");
                break;
            case 4:displayDeatilsForMovies("-My Little Pony-", "Equestria's divided. But a bright-eyed hero believes Earth Ponies,\n" +
                            "Pegasi and Unicorns should be pals — and, hoof to heart, she's \n" +
                            "determined to prove it.",
                    "Vanessa Hudgens, Kimiko Glenn, \n James Marsden",
                    "Robert Cullen, José Luis Ucha",
                    "1 Hour 31 Min");
                break;
            case 5:displayDeatilsForMovies("-Barbie Dolphin Magic-", "While visiting Ken and exploring a coral reef, Barbie and her sisters\n" +
                            "make an amazing discovery and meet a mysterious new friend.",
                    "Erica Lindbeck, Shannon\n" +
                            "Chan-Kent, Kazumi Evans",
                    "Conrad Helten",
                    "1 Hour 4 Min");
                break;
            case 6:return;
            default:
                System.out.println("Invalid choice.Please try again.");
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
            case 1: displaySeries();break;
            case 2: chooseCatagoryForSeries();;break;
            case 3: return;
            default: System.out.println("Invalid Choice, please try again.");

        }
    }

    public static void displaySeries() {
        String[] seriesArray = {"1- Lupin", "2-The Walking Dead", "3- Narcos", "4- The Protector", "5- La Casa De Papel\n",
                "6- Stranger Things", "7- Chilling Adventures of Sabrina", "8- Hellbound", "9- Parasyte: The Grey", "10- Van Helsing\n",
                "11- Bir Erkek Bir Kadın", "12- Emily in Paris", "13- Friends", "14- How I Met Your Mother (HIMYM)", "15- Orange Is The New Black\n",
                "16- Thank You Next", "17- Bridgerton", "18- One Day", "19- Shahmaran", "20- Ginny & Georgia\n",
                "21- Lucifer", "22- The Witcher", "23- One Piece", "24- Wednesday", "25- Locke & Key\n",
                "26- SpongeBob Squarepants", "27- Miraculous: Tales of Ladybug and Cat Noir", "28- Ben10", "29- Adventure Time", "30- World of Winx", "\n31- Back to Homepage"};

        while (true) {

            for (int i = 0; i < seriesArray.length; i++) {
                System.out.println(seriesArray[i]);
            }

            System.out.println("\nEnter Your Choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 31) {
                switch (choice) {
                    case 1:
                        displayDeatilsForSeries("Lupin",
                                "Acclaimed French actor Omar Sy plays a winsome thief who outwits the rich and powerful in this hit series," +
                                        " with Ludivine Sagnier and Clotilde Hesme.",
                                "Omar Sy, Ludivine Sagnier, Clotilde Hesme, Nicole Garcia, Hervé Pierre, Soufiane Guerrab, Antoine Gouy," +
                                        "Fargass Assandé, Vincent Londez, Shirine Boutella, Mamadou Haidara, Etan Simon, Ludmilla Makowski",
                                "Georger Kay", "3 season 17 episodes");
                        break;
                    case 2:
                        displayDeatilsForSeries("The Walking Dead",
                                "In the wake of a zombie apocalypse, survivors hold on to the hope of humanity by banding together to wage a fight for their own.",
                                "Andrew Lincoln, Steven Yeun, Norman Reedus, Chandler Riggs, Melissa McBride, Lauren Cohan, Danai Gurira",
                                "Frank Árpád Darabont", "11 season 177 episodes");
                        break;
                    case 3:
                        displayDeatilsForSeries("Narcos",
                                "In this gangster series, you will watch the true story of Colombia's violent and powerful drug cartels." +
                                        "Thousands of options, unlimited fun. It won Best Drama Series and Best TV Ensemble at the 2017 Fénix Awards held in Mexico.",
                                "Wagner Moura, Pedro Pascal, Boyd Holbrook, Damién Alcazar, Alberto Ammann, Francisco Denis, Pepé Rapazote, Matias Varela",
                                "Chris Brancato. Carlo Bernard. Doua Miro", "3 season 30 episodes");
                        break;
                    case 4:
                        displayDeatilsForSeries("The Protector",
                                "A young man living in modern-day Istanbul, who discovers his connection to an ancient secret society, " +
                                        "embarks on an adventure to save the city from an immortal enemy.",
                                "Çağatay Ulusoy, Ayça Ayşin Turan, Hazar Ergüçlü, Okan Yalabık, Funda Eryiğit, Mehmet Kurtuluş, Engin Öztük,Bige Onal,İlayda Alişan",
                                "Umut Aral Gönenç, Uyanık Can Evrenol, Burcu Alptekin, Gökhan Tiryaki.", "4 Season, 32 episodes");
                        break;
                    case 5:
                        displayDeatilsForSeries("La Casa De Papel",
                                "Eight thieves take hostages and lock themselves in the Royal Mint of Spain as a criminal " +
                                        "mastermind manipulates the police to carry out his plan.",
                                "Ursula Corbero, Alvaro Morte, Itziar Itufio, Pedro Alonso, Miguel Herran, Jaime Lorente, Esther Acebo, Darko Peri¢, Hovik Keuchkerian, Luka Pero$",
                                "Alex Pina", "5 Season 48 episodes");
                        break;
                    case 6:
                        displayDeatilsForSeries("Stranger Things",
                                "In 1983, a boy vanishes from a sleepy town. To find him, his friends put their board game skills to the test — but a dark force lurks under the surface.",
                                "Winona Ryder, David Harbour, Millie Bobby Brown, Finn Wolfhard, Gaten Matarazzo, Caleb McLaughlin, Noah Schnapp. Sadie Sink, Natalia Dyer, Charlie Heaton",
                                "The Duffer Brothers", "4 season 34 episodes");
                        break;
                    case 7:
                        displayDeatilsForSeries("Chilling Adventures of Sabrina",
                                "Sabrina's hometown is spooky, her house is a mortuary, and her favorite teacher is possessed. But when the Dark Lord arrives, life turns really sinister.",
                                "Kiernan Shipka, Ross Lynch, Miranda Otto, Lucy Davis, Chance Perdomo, Michelle Gomez, Jaz Sinclair, Lachlan Watson, Gavin Leatherwood, Tati Gabrielle, Adeline Rudolph, Richard Coyle, Abigail Cowen",
                                "Sydney Pollack", "4 season 36 episodes");
                        break;
                    case 8:
                        displayDeatilsForSeries("Hellbound",
                                "This horror thriller from Yeon Sang-ho (“Train to Busan\"), based on a webtoon he wrote, shows humanity's dark sides in the face of otherworldly threats.",
                                "Yoo Ah-in, Kim Hyun-joo, Park Jeong-min, Won Jin-a, Yang Ik-june, Kim Do-yoon, Kim Shin-rock, Ryu Kyung-soo, Lee Re",
                                "Yeon Sang-ho, Choi Gyu-seok", "1 season 6 episodes");
                        break;
                    case 9:
                        displayDeatilsForSeries("Parasyte: The Grey",
                                "When a human-eating alien parasite inadvertently becomes one with a woman, the two embark on an unexpected journey to save humanity from extinction.",
                                "Jeon So-nee, Koo Kyo-hwan, Lee Jung-hyun, Kwon Hae-hyo, Kim In-kwon", "Yeon Sang-ho, Ryu Yong-jae",
                                "1 Seaon 6 episodes");
                        break;
                    case 10:
                        displayDeatilsForSeries("Van Helsing",
                                "After three years in a coma, Vanessa awakens to a world ravaged by vampires. Now, she and a motley band of fellow survivors fight to stay alive.",
                                "Kelly Overton, Jonathan Scarfe, Christopher Heyerdahl, Missy Peregrym, Paul Johansson, Rukiya Bernard, Vincent Gale, Aleks Paunovic, Trezzo Mahoro",
                                "Neil Labute", "5 season 65 episodes");
                        break;
                    case 11:
                        displayDeatilsForSeries("Bir Erkek Bir Kadın", "Two very different people — a cynic and a hopeless romantic — navigate all of life's comic situations and adventures together.",
                                "Demet Evgar, Emre Karayel", "Müge Turalı", "1 season 20 episodes");
                        break;
                    case 12:
                        displayDeatilsForSeries("Emily in Paris",
                                "Marketing executive Emily Cooper from Chicago is in Paris\n" +
                                        "After securing the positions of their dreams, business, friendship and\n" +
                                        "While dealing with love, she embraces his new life full of adventure.",
                                "Lily Collins, Philippine Leroy-Beaulieu, Ashley Park, Lucas Bravo, Kate Walsh, Samuel Arnold, Bruno Gouery,Camille Razat, Lucien Laviscount, Paul Forman, Melia Kreiling, Kevin Dias",
                                "Darren Star", "3 season 30 episodes");
                        break;
                    case 13:
                        displayDeatilsForSeries("Friends",
                                "This popular sitcom tells the story of business, love and life in 1990s Manhattan.It tells the funny adventures of six friends in their 20s who are dealing with the difficulties of daily life.",
                                "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc, Matthew Perry, David Schwimmer",
                                "David Crane, Marta Kauffman", "10 season 235 episodes");
                        break;
                    case 14:
                        displayDeatilsForSeries("How I Met Your Mother (HIMYM)", "We are in 2030; Ted Mosby tells his children the 'long' story of how he met their mother, " +
                                        "and suddenly we go back to America in 2005, where five best friends live their fun lives in their 20s. Ted is a 27-year-old architect from Manhattan.",
                                "Josh Radnor,Cobie Smulders,Jason Segel,Alyson Hannigan,Neil Patrick Harris,Joe Manganiello,Suzie Plakson,Bob Saget", "Pamela Fryman",
                                "9 season 208 episodes");
                        break;
                    case 15:
                        displayDeatilsForSeries("Orange is The New Black",
                                "In this darkly comic drama series, an affluent woman adapts to life in prison.",
                                "Taylor Schilling, Kate Mulgrew, Laura Prepon, Jason Biggs, Natasha Lyonne, Michael Harney, Uzo Aduba,Danielle Brooks, Samira Wiley, Dascha Polanco, Selenis Leyva, Nick Sandow, Yael Stone, Taryn Manning, Lea DelLaria",
                                "Jenji Kohan", "7 season 91 episodes");
                        break;
                    case 16:
                        displayDeatilsForSeries("Thank You Next",
                                "Focusing on the lives of 30-year-old Lawyer Leyla and her friends with whom she works at the same law firm," +
                                        "Thank You Next is about the modern-day pains they go through, sometimes on the 'bench', sometimes in the 'ghost'," +
                                        "sometimes in a 'relationship', and mostly in a 'situationship'.",
                                "Serenay Sarıkaya, Metin Akdülger, Hakan Kurtaş, Boran Kuzum, Ahmet Rıfat Şungar, Bade İşçil, Esra Rusan,Meriç Aral, Efe Tunçer, Kamil Güler, Cem Güler.",
                                "Bertan Başaran", "1 Season 8 episode");
                        break;
                    case 17:
                        displayDeatilsForSeries("Bridgerton",
                                "Eight close-knit siblings from the Bridgerton family search for love and happiness in London high society. " +
                                        "Inspired by Julia Quinn's bestselling novels.",
                                "Adjoa Andoh, Julie Andrews, Lorraine Ashbourne, Jonathan Bailey, Ruby Barker, Sabrina Bartlett, Harriet Cains,Bessie Carter, Nicola Coughlan, Phoebe Dynevor",
                                "Chris Van Dusen", "2 Season 16 episodes");
                        break;
                    case 18:
                        displayDeatilsForSeries("One Day",
                                "Adapted from David Nicholls' bestselling 2009 novel, One Day is about the lives of Emma Morley and Dexter Mayhew," +
                                        " who met on the last day of their studies at the University of Edinburgh in 1988.",
                                "Ambika Mod, Leo Woodall, Essie Davis, Tim McInnerny, Amber Grappy, Jonny Weldon, Eleanor Tomlinson,Brendan Quinn",
                                "Nicole Taylor", "1 Season 14 episodes");
                        break;
                    case 19:
                        displayDeatilsForSeries("Shahmaran",
                                "In this fantasy drama series, a lonely young woman finds her soulmate and discovers they are both part of an ancient legend.",
                                "Serenay Sarıkaya, Burak Deniz, Mustafa Uğurlu, Mahir Günşiray, Ebru Özkan, Mert Ramazan Demir, Hakan Karahan, Elif Nur Kerkük, Mehmet Bilge Aslan",
                                "Umur Turagay", "1 Season 8 episodes");
                        break;
                    case 20:
                        displayDeatilsForSeries("Ginny & Georgia",
                                "It begins after Georgia Miller becomes pregnant at a young age and gives birth to Ginny. " +
                                        "Georgia is raising Ginny as a mother with a turbulent past. Georgia looks close to Ginny's age " +
                                        "and is trying to provide her with a better life by making a fresh start.",
                                "Brianne Howey, Antonia Gentry, Diesel La Torraca, Jennifer Robertson, Felix Mallard, Sara Waisglass, Scott Porter, Raymond Ablack, Aaron Ashmore, Nathan Mitchell.",
                                "Sarah Lampert", "2 Season 20 episodes");
                        break;
                    case 21:
                        displayDeatilsForSeries("Lucifer",
                                "The series focuses on Lucifer Morningstar, a powerful angel who was expelled from Heaven for his rebellion and was forced to punish humans as the lord of Hell for thousands of years.",
                                "Tom Ellis, Lauren German, Kevin Alejandro, D.B. Woodside, Lesley-Ann Brandt, Aimee Garcia, Scarlett Estevez,Rachael Harris, Inbar Lavi, Tricia Helfer, Tom Welling, Jeremiah W. Birkett, Pej Vahdat, Michael Gladis, Dennis Haysbert,Brianna Hildebrand",
                                "Neil Gaiman", "6 season 93 episodes");
                        break;
                    case 22:
                        displayDeatilsForSeries("The Witcher",
                                "A massive hit across the globe, this epic tale of monsters, magic and destiny is \"incredibly fun to watch and easy to become immersed in,\" says Paste.",
                                "Henry Cavill, Anya Chalotra, Freya Allan, Joey Batey, Eamon Farren, MyAnna Buring, Mimi M Khayisa, Mahesh Jadu, Anna Shaffer, Royce Pierreson, Tom Canton",
                                "Lauren Schmidt Hissrich", "3 season 24 episodes");
                        break;
                    case 23:
                        displayDeatilsForSeries("One Piece", "Stranded on a sinking boat, carefree Luffy begins his journey in search of a pirate king's lost treasure. But first, he'll need a crew, a ship and a map.",
                                "Iñaki Godoy, Emily Rudd, Mackenyu, Jacob Romero Gibson, Taz Skylar, Vincent Regan, Jeff Ward, Morgan Davies",
                                "Steven Maeda, Matt Owens", "1 season 8 episodes");
                        break;
                    case 24:
                        displayDeatilsForSeries("Wednesday",
                                "Wednesday Addams, a smart, sarcastic and slightly depressed girl, meets new friends and friends at Nevermore Academy.murders that occur one after the other while making enemies investigates.",
                                "Jenna Ortega, Gwendoline Christie, Riki Lindhome, Christina Ricci, Jamie McShane, Hunter Doohan, Percy Hynes White, Emma Myers, Joy Sunday",
                                "Alfred Gough, Miles Millar", "1 season 8 episodes");
                        break;
                    case 25:
                        displayDeatilsForSeries("Locke & Key", "After their dad's murder, three siblings move with their mom to his ancestral estate, where they discover magical keys that unlock powers — and secrets.",
                                "Darby Stanchfield, Connor Jessup, Emilia Jones, Jackson Robert Scott, Petrice Jones, Laysla De Oliveira, Griffin Gluck, Aaron Ashmore",
                                "Mark Romanek", "3 season 28 episodes");
                        break;
                    case 26:
                        displayDeatilsForSeries("SpongeBob Squarepants",
                                "From his pineapple home base under the sea, SpongeBob and his friends, including his meowing pet snail Gary, get into memorable misadventures.",
                                "Tom Kenny, Rodger Bumpass, Bill Fagerbakke, Clancy Brown, Dee Bradley Baker, Mr. Lawrence, Carolyn Lawrence, Sirena Irwin, Marcelo Pissardini, Wendel Bezerra, Luis PérezPons",
                                "Vincent Waller", "7 season 144 episodes");
                        break;
                    case 27:
                        displayDeatilsForSeries("Miraculous: Tales of Ladybug and Cat Noir",
                                "When Paris encounters danger, Marinette transforms into Ladybug. However, she is unaware that her school sweetheart, Adrien, is also the Black Cat, a city-saving superhero.",
                                "Cristina Valenzuela, Bryce Papenbrook, Keith Silverstein, Mela Lee, Max Mittelman, Barbara Harris", "Thomas Astruc", "4 season 104 episodes");
                        break;
                    case 28:
                        displayDeatilsForSeries("Ben10",
                                "Thanks to a mysterious device known as the Omnitrix, mischievo youngster Ben Tennyson has the power to morph into an array of alien superheroes.",
                                "Tara Strong, Paul Eiding, Meagan Smith, Dee Bradley Baker, Jim Ward, Steve Blum, Richard McGonagle, Fred Tatasciore", "Duncan Rouleau, Joe Casey, Joe Kelly, Steven T. Seagle",
                                "3 season 39 episodes");
                        break;
                    case 29:
                        displayDeatilsForSeries("Adventure Time",
                                "Young Finn and his shape-shifting dog buddy, Jake, go on a series of surreal adventures as they journey through the postapocalyptic Land of Ooo.",
                                "Jeremy Shada, John DiMaggio, Hynden Walch, Tom Kenny, Pendleton Ward, Dee Bradley Baker, Niki Yang, Maria Bamford, Steve Little, Olivia Olson",
                                "Pendleton Ward", "4 season 52 episodes");
                        break;
                    case 30:
                        displayDeatilsForSeries("World of Winx",
                                "Five young fairies attend a magical boarding school called Alfea in the Afterlife. Fairies," +
                                        " who are approaching adulthood step by step, learn how to control their magical powers while trying to cope with the monsters, love and competition they encounter.",
                                "Haven Paschall, Alysha Deslorieux, Jessica Paquet, Eileen Stevens, Kate Bristol, Saskia Maarleveld, Brittany Pressley, Billy Bob Thompson", "Igınio Straffi",
                                "2 season 26 episodes");
                        break;
                    case 31:
                        return;
                    default:
                        System.out.println("Invalid choice, please try again!");
                }
            } else {
                System.out.println("Invalid choice!Please select a number between 1-30.");
            }
        }
    }

    public static void chooseCatagoryForSeries(){
        System.out.println(" Choose a Catagory: ");
        System.out.println("1- Romantic");
        System.out.println("2- Action");
        System.out.println("3- Horror and Thriller ");
        System.out.println("4- Sci-fi and Fantasy");
        System.out.println("5- Comedy");
        System.out.println("6- Family and Children");
        System.out.println();
        System.out.println("Enter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayRomanticSeries(); break;
            case 2: displayActionSeries(); break;
            case 3: displayHorrorSeries(); break;
            case 4: displayFantasySeries(); break;
            case 5: displayComedySeries(); break;
            case 6: displayAnimationSeries(); break;
            default: System.out.println("Invalid Choice, please try again.");
        }
    }

    public static void displayRomanticSeries(){
        System.out.println("-- Romantic Series --\n");
        String[] romanticSeries= {"1- Thank You Next", "2- Bridgerton", "3- One Day", "4- Shahmaran", "5- Ginny & Georgia","6-Back to Homepage"};
        for(int i=0;i<romanticSeries.length;i++){
            System.out.println(romanticSeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("Thank You Next",
                    "Focusing on the lives of 30-year-old Lawyer Leyla and her friends with whom she works at the same law firm," +
                            "Thank You Next is about the modern-day pains they go through, sometimes on the 'bench', sometimes in the 'ghost'," +
                            "sometimes in a 'relationship', and mostly in a 'situationship'.",
                    "Serenay Sarıkaya, Metin Akdülger, Hakan Kurtaş, Boran Kuzum, Ahmet Rıfat Şungar, Bade İşçil, Esra Rusan,Meriç Aral, Efe Tunçer, Kamil Güler, Cem Güler.",
                    "Bertan Başaran", "1 Season 8 episode" );
            break;
            case 2: displayDeatilsForSeries("Bridgerton",
                    "Eight close-knit siblings from the Bridgerton family search for love and happiness in London high society. " +
                            "Inspired by Julia Quinn's bestselling novels.",
                    "Adjoa Andoh, Julie Andrews, Lorraine Ashbourne, Jonathan Bailey, Ruby Barker, Sabrina Bartlett, Harriet Cains,Bessie Carter, Nicola Coughlan, Phoebe Dynevor",
                    "Chris Van Dusen","2 Season 16 episodes");
            break;
            case 3: displayDeatilsForSeries("One Day",
                    "Adapted from David Nicholls' bestselling 2009 novel, One Day is about the lives of Emma Morley and Dexter Mayhew," +
                            " who met on the last day of their studies at the University of Edinburgh in 1988.",
                    "Ambika Mod, Leo Woodall, Essie Davis, Tim McInnerny, Amber Grappy, Jonny Weldon, Eleanor Tomlinson,Brendan Quinn",
                    "Nicole Taylor", "1 Season 14 episodes");
            break;
            case 4: displayDeatilsForSeries("Shahmaran",
                    "In this fantasy drama series, a lonely young woman finds her soulmate and discovers they are both part of an ancient legend.",
            "Serenay Sarıkaya, Burak Deniz, Mustafa Uğurlu, Mahir Günşiray, Ebru Özkan, Mert Ramazan Demir, Hakan Karahan, Elif Nur Kerkük, Mehmet Bilge Aslan",
                    "Umur Turagay", "1 Season 8 episodes");
            break;
            case 5: displayDeatilsForSeries("Ginny & Georgia",
                    "It begins after Georgia Miller becomes pregnant at a young age and gives birth to Ginny. " +
                            "Georgia is raising Ginny as a mother with a turbulent past. Georgia looks close to Ginny's age " +
                            "and is trying to provide her with a better life by making a fresh start.",
                    "Brianne Howey, Antonia Gentry, Diesel La Torraca, Jennifer Robertson, Felix Mallard, Sara Waisglass, Scott Porter, Raymond Ablack, Aaron Ashmore, Nathan Mitchell.",
                    "Sarah Lampert", "2 Season 20 episodes");
            break;
            case 6: return;
            default:
                System.out.println("Invalid choice. Please try again!");
        }
    }

    public static void displayActionSeries(){
        System.out.println("-- Action Series --\n");
        String[] actionSeries= {"1- Lupin", "2-The Walking Dead", "3- Narcos","4- The Protector", "5- La Casa De Papel","6- Back to Homepage"};

        for(int i=0;i<actionSeries.length;i++){
            System.out.println(actionSeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("Lupin",
                    "Acclaimed French actor Omar Sy plays a winsome thief who outwits the rich and powerful in this hit series," +
                            " with Ludivine Sagnier and Clotilde Hesme.",
                    "Omar Sy, Ludivine Sagnier, Clotilde Hesme, Nicole Garcia, Hervé Pierre, Soufiane Guerrab, Antoine Gouy," +
                            "Fargass Assandé, Vincent Londez, Shirine Boutella, Mamadou Haidara, Etan Simon, Ludmilla Makowski",
                    "Georger Kay","3 season 17 episodes");
            break;
            case 2: displayDeatilsForSeries("The Walking Dead",
                    "In the wake of a zombie apocalypse, survivors hold on to the hope of humanity by banding together to wage a fight for their own.",
                    "Andrew Lincoln, Steven Yeun, Norman Reedus, Chandler Riggs, Melissa McBride, Lauren Cohan, Danai Gurira",
                    "Frank Árpád Darabont", "11 season 177 episodes");
            break;
            case 3: displayDeatilsForSeries("Narcos",
                    "In this gangster series, you will watch the true story of Colombia's violent and powerful drug cartels." +
                            "Thousands of options, unlimited fun. It won Best Drama Series and Best TV Ensemble at the 2017 Fénix Awards held in Mexico.",
                    "Wagner Moura, Pedro Pascal, Boyd Holbrook, Damién Alcazar, Alberto Ammann, Francisco Denis, Pepé Rapazote, Matias Varela",
                    "Chris Brancato. Carlo Bernard. Doua Miro","3 season 30 episodes");
            break;
            case 4: displayDeatilsForSeries("The Protector",
                    "A young man living in modern-day Istanbul, who discovers his connection to an ancient secret society, " +
                            "embarks on an adventure to save the city from an immortal enemy.",
                    "Çağatay Ulusoy, Ayça Ayşin Turan, Hazar Ergüçlü, Okan Yalabık, Funda Eryiğit, Mehmet Kurtuluş, Engin Öztük,Bige Onal,İlayda Alişan",
                    "Umut Aral Gönenç, Uyanık Can Evrenol, Burcu Alptekin, Gökhan Tiryaki.","4 Season, 32 episodes");
            break;
            case 5: displayDeatilsForSeries("La Casa De Papel",
                    "Eight thieves take hostages and lock themselves in the Royal Mint of Spain as a criminal " +
                            "mastermind manipulates the police to carry out his plan.",
                    "Ursula Corbero, Alvaro Morte, Itziar Itufio, Pedro Alonso, Miguel Herran, Jaime Lorente, Esther Acebo, Darko Peri¢, Hovik Keuchkerian, Luka Pero$",
                    "Alex Pina", "5 Season 48 episodes");
            break;
            case 6: return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void displayHorrorSeries(){
        System.out.println("-- Horror and Thriller Series --\n");
        String[] horrorSeries={"1- Stranger Things", "2- Chilling Adventures of Sabrina", "3- Hellbound", "4- Parasyte: The Grey", "5- Van Helsing","6- Back to Homepage"};
        for(int i=0;i<horrorSeries.length;i++){
            System.out.println(horrorSeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("Stranger Things",
                    "In 1983, a boy vanishes from a sleepy town. To find him, his friends put their board game skills to the test — but a dark force lurks under the surface.",
                    "Winona Ryder, David Harbour, Millie Bobby Brown, Finn Wolfhard, Gaten Matarazzo, Caleb McLaughlin, Noah Schnapp. Sadie Sink, Natalia Dyer, Charlie Heaton",
                    "The Duffer Brothers","4 season 34 episodes");
            break;
            case 2: displayDeatilsForSeries("Chilling Adventures of Sabrina",
                    "Sabrina's hometown is spooky, her house is a mortuary, and her favorite teacher is possessed. But when the Dark Lord arrives, life turns really sinister.",
                    "Kiernan Shipka, Ross Lynch, Miranda Otto, Lucy Davis, Chance Perdomo, Michelle Gomez, Jaz Sinclair, Lachlan Watson, Gavin Leatherwood, Tati Gabrielle, Adeline Rudolph, Richard Coyle, Abigail Cowen",
                    "Sydney Pollack","4 season 36 episodes");
            case 3: displayDeatilsForSeries("Hellbound",
                    "This horror thriller from Yeon Sang-ho (“Train to Busan\"), based on a webtoon he wrote, shows humanity's dark sides in the face of otherworldly threats.",
                    "Yoo Ah-in, Kim Hyun-joo, Park Jeong-min, Won Jin-a, Yang Ik-june, Kim Do-yoon, Kim Shin-rock, Ryu Kyung-soo, Lee Re",
                    "Yeon Sang-ho, Choi Gyu-seok","1 season 6 episodes");
            break;
            case 4: displayDeatilsForSeries("Parasyte: The Grey",
                    "When a human-eating alien parasite inadvertently becomes one with a woman, the two embark on an unexpected journey to save humanity from extinction.",
                    "Jeon So-nee, Koo Kyo-hwan, Lee Jung-hyun, Kwon Hae-hyo, Kim In-kwon","Yeon Sang-ho, Ryu Yong-jae",
                    "1 Seaon 6 episodes");
            break;
            case 5: displayDeatilsForSeries("Van Helsing",
                    "After three years in a coma, Vanessa awakens to a world ravaged by vampires. Now, she and a motley band of fellow survivors fight to stay alive.",
                    "Kelly Overton, Jonathan Scarfe, Christopher Heyerdahl, Missy Peregrym, Paul Johansson, Rukiya Bernard, Vincent Gale, Aleks Paunovic, Trezzo Mahoro",
                    "Neil Labute", "5 season 65 episodes");
            break;
            case 6: return;
            default: System.out.println("Invalid choice. Please try again.");

        }
    }
    public static void displayComedySeries(){
        System.out.println("-- Comedy Series --\n");
        String[] comedySeries={"1- Bir Erkek Bir Kadın", "2- Emily in Paris", "3- Friends", "4- How I Met Your Mother (HIMYM)", "5- Orange Is The New Black","6- Back to Homepage"};
        for(int i=0;i<comedySeries.length;i++){
            System.out.println(comedySeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("Bir Erkek Bir Kadın","Two very different people — a cynic and a hopeless romantic — navigate all of life's comic situations and adventures together.",
                    "Demet Evgar, Emre Karayel","Müge Turalı","1 season 20 episodes");
            break;
            case 2:  displayDeatilsForSeries("Emily in Paris",
                    "Marketing executive Emily Cooper from Chicago is in Paris\n" +
                            "After securing the positions of their dreams, business, friendship and\n" +
                            "While dealing with love, she embraces his new life full of adventure.",
                    "Lily Collins, Philippine Leroy-Beaulieu, Ashley Park, Lucas Bravo, Kate Walsh, Samuel Arnold, Bruno Gouery,Camille Razat, Lucien Laviscount, Paul Forman, Melia Kreiling, Kevin Dias",
                    "Darren Star","3 season 30 episodes");
            break;
            case 3: displayDeatilsForSeries("Friends",
                    "This popular sitcom tells the story of business, love and life in 1990s Manhattan.It tells the funny adventures of six friends in their 20s who are dealing with the difficulties of daily life.",
                    "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc, Matthew Perry, David Schwimmer",
                    "David Crane, Marta Kauffman","10 season 235 episodes");
            break;
            case 4: displayDeatilsForSeries("How I Met Your Mother (HIMYM)","We are in 2030; Ted Mosby tells his children the 'long' story of how he met their mother, " +
                    "and suddenly we go back to America in 2005, where five best friends live their fun lives in their 20s. Ted is a 27-year-old architect from Manhattan.",
                    "Josh Radnor,Cobie Smulders,Jason Segel,Alyson Hannigan,Neil Patrick Harris,Joe Manganiello,Suzie Plakson,Bob Saget","Pamela Fryman",
                    "9 season 208 episodes");
            break;
            case 5: displayDeatilsForSeries("Orange is The New Black",
                    "In this darkly comic drama series, an affluent woman adapts to life in prison.",
                    "Taylor Schilling, Kate Mulgrew, Laura Prepon, Jason Biggs, Natasha Lyonne, Michael Harney, Uzo Aduba,Danielle Brooks, Samira Wiley, Dascha Polanco, Selenis Leyva, Nick Sandow, Yael Stone, Taryn Manning, Lea DelLaria",
                    "Jenji Kohan","7 season 91 episodes");
            break;
            case 6: return;
            default: System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void displayFantasySeries(){
        System.out.println("-- Sci-fi and Fantasy Series --\n");
        String[] fantasySeries={"1- Lucifer", "2- The Witcher", "3- One Piece", "4- Wednesday", "5- Locke & Key","6- Back to Homepage"};
        for(int i=0;i<fantasySeries.length;i++){
            System.out.println(fantasySeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("Lucifer",
                    "The series focuses on Lucifer Morningstar, a powerful angel who was expelled from Heaven for his rebellion and was forced to punish humans as the lord of Hell for thousands of years.",
                    "Tom Ellis, Lauren German, Kevin Alejandro, D.B. Woodside, Lesley-Ann Brandt, Aimee Garcia, Scarlett Estevez,Rachael Harris, Inbar Lavi, Tricia Helfer, Tom Welling, Jeremiah W. Birkett, Pej Vahdat, Michael Gladis, Dennis Haysbert,Brianna Hildebrand",
                    "Neil Gaiman","6 season 93 episodes");
            break;
            case 2: displayDeatilsForSeries("The Witcher",
                    "A massive hit across the globe, this epic tale of monsters, magic and destiny is \"incredibly fun to watch and easy to become immersed in,\" says Paste.",
                    "Henry Cavill, Anya Chalotra, Freya Allan, Joey Batey, Eamon Farren, MyAnna Buring, Mimi M Khayisa, Mahesh Jadu, Anna Shaffer, Royce Pierreson, Tom Canton",
                    "Lauren Schmidt Hissrich","3 season 24 episodes");
            break;
            case 3: displayDeatilsForSeries("One Piece", "Stranded on a sinking boat, carefree Luffy begins his journey in search of a pirate king's lost treasure. But first, he'll need a crew, a ship and a map.",
                    "Iñaki Godoy, Emily Rudd, Mackenyu, Jacob Romero Gibson, Taz Skylar, Vincent Regan, Jeff Ward, Morgan Davies",
                    "Steven Maeda, Matt Owens","1 season 8 episodes");
            break;
            case 4: displayDeatilsForSeries("Wednesday",
                    "Wednesday Addams, a smart, sarcastic and slightly depressed girl, meets new friends and friends at Nevermore Academy.murders that occur one after the other while making enemies investigates.",
                    "Jenna Ortega, Gwendoline Christie, Riki Lindhome, Christina Ricci, Jamie McShane, Hunter Doohan, Percy Hynes White, Emma Myers, Joy Sunday",
                    "Alfred Gough, Miles Millar","1 season 8 episodes");
            break;
            case 5: displayDeatilsForSeries("Locke & Key","After their dad's murder, three siblings move with their mom to his ancestral estate, where they discover magical keys that unlock powers — and secrets.",
                    "Darby Stanchfield, Connor Jessup, Emilia Jones, Jackson Robert Scott, Petrice Jones, Laysla De Oliveira, Griffin Gluck, Aaron Ashmore",
                    "Mark Romanek","3 season 28 episodes");
            break;
            case 6: return;
            default:
                System.out.println("Invalid choice, please try again!");
        }
    }

    public static void displayAnimationSeries(){
        System.out.println("-- Family and Children Series --\n");

        String[] animationSeries={"1- SpongeBob Squarepants", "2- Miraculous: Tales of Ladybug and Cat Noir","3- Ben10", "4- Adventure Time", "5- World of Winx","6- Back to homepage"};
        for(int i=0;i<animationSeries.length;i++){
            System.out.println(animationSeries[i]);
        }

        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: displayDeatilsForSeries("SpongeBob Squarepants",
                    "From his pineapple home base under the sea, SpongeBob and his friends, including his meowing pet snail Gary, get into memorable misadventures.",
                    "Tom Kenny, Rodger Bumpass, Bill Fagerbakke, Clancy Brown, Dee Bradley Baker, Mr. Lawrence, Carolyn Lawrence, Sirena Irwin, Marcelo Pissardini, Wendel Bezerra, Luis PérezPons",
                    "Vincent Waller","7 season 144 episodes");
            break;
            case 2: displayDeatilsForSeries("Miraculous: Tales of Ladybug and Cat Noir",
                    "When Paris encounters danger, Marinette transforms into Ladybug. However, she is unaware that her school sweetheart, Adrien, is also the Black Cat, a city-saving superhero.",
                    "Cristina Valenzuela, Bryce Papenbrook, Keith Silverstein, Mela Lee, Max Mittelman, Barbara Harris","Thomas Astruc","4 season 104 episodes");
            break;
            case 3: displayDeatilsForSeries("Ben10",
                    "Thanks to a mysterious device known as the Omnitrix, mischievo youngster Ben Tennyson has the power to morph into an array of alien superheroes.",
                    "Tara Strong, Paul Eiding, Meagan Smith, Dee Bradley Baker, Jim Ward, Steve Blum, Richard McGonagle, Fred Tatasciore","Duncan Rouleau, Joe Casey, Joe Kelly, Steven T. Seagle",
                    "3 season 39 episodes");
            break;
            case 4: displayDeatilsForSeries("Adventure Time",
                    "Young Finn and his shape-shifting dog buddy, Jake, go on a series of surreal adventures as they journey through the postapocalyptic Land of Ooo.",
                    "Jeremy Shada, John DiMaggio, Hynden Walch, Tom Kenny, Pendleton Ward, Dee Bradley Baker, Niki Yang, Maria Bamford, Steve Little, Olivia Olson",
                    "Pendleton Ward","4 season 52 episodes");
            break;
            case 5: displayDeatilsForSeries("World of Winx",
                    "Five young fairies attend a magical boarding school called Alfea in the Afterlife. Fairies," +
                            " who are approaching adulthood step by step, learn how to control their magical powers while trying to cope with the monsters, love and competition they encounter.",
                    "Haven Paschall, Alysha Deslorieux, Jessica Paquet, Eileen Stevens, Kate Bristol, Saskia Maarleveld, Brittany Pressley, Billy Bob Thompson","Igınio Straffi",
                    "2 season 26 episodes");
            break;
            case 6: return;
            default:
                System.out.println("Invalid choice, please try again!");
        }
    }

    public static void usersFavorites(){

        String [][][]  myListArray = new String[][][]{
                {{"-Heart Parade", "1h 48m", "+18"},
                        {"-Love Tactics", "1h 43m", "+13"},
                        {"-Thank You Next", "1 season/ 8 episode", "+16"},
                        {"-One Day", "1 season/ 10 episode", "+18"}},
                {{"-Lupin", "3 season / 13 episode", "+16"},
                        {"-The Maze Runner", "1h 54m", "+16"},
                        {"-La Casa De Papel", "5 season / 48 episode", "+18"}
                },
                {{"-Bird Box", "2h 4m", "+18"},
                        {"-Stranger Things", "4 season/ 34 episode", "+16"},
                        {"-Van Helsing", "5 season / 65 episode", "+18"}},
                {{"-Little Man", "1h 37m", "+16"},
                        {"-Friends", "10 season / 236 episode", "+13"},
                        {"-Orange is The New Black", "7 season / 91 episode","+16"}},
                {{"-I Am Mother", "1h 53m", "+13"},
                        {"-Paradise", "1h 58m", "+18"},
                        {"-The Witcher", "3 season / 24 episode", "+18"},
                        {"-Wednesday", "1 season / 8 episode", "+18"}},
                {{"-Madagascar", "1h 26m", "+7"},
                        {"-Boss Baby", "1h 37m", "+7"},
                        {"-Adventure Time", "10 season / 283 episode", "+7"},}
        };

        System.out.println("\n-User's Favorites-");

        for(int i=0;i< myListArray.length;i++){

            switch(i){
                case 0:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<< Romantic >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 1:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<< Action >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 2:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<< Horror >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 3:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<< Comedy >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 4:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<< Si-Ci and Fantacy >>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 5:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<< Kids and Family >>>>>>>>>>>>>>>>>>>>>>>>>>" );
                    break;
                default:
                    System.out.println("\nUnknown Category");
                    break;

            }
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-20s %-30s %-20s\n", "Film Name", "Time", "Age limit");
            System.out.println("-------------------------------------------------------------------");

            for (int j = 0; j <  myListArray[i].length ; j++) {
                System.out.printf("%-20s %-30s %-20s\n", myListArray[i][j][0], myListArray[i][j][1], myListArray[i][j][2]);
            }

        }


    }


    public static void main(String[] args) {
        userHints();
    }
}