import java.util.Scanner;

public class Main {

    static int INDEX = 100;
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

    public static void displaySeries(){
        String[] seriesArray= {"1- Lupin", "2-The Walking Dead", "3- Narcos","4- The Protector", "5- La Casa De Papel\n",
                "6- Stranger Things", "7- Chilling Adventures of Sabrina", "8- Hellbound", "9- Parasyte: The Grey", "10- Van Helsing\n",
        "11- Bir Erkek Bir Kadın", "12- Emily in Paris", "13- Friends", "14- How I Met Your Mother (HIMYM)", "15- Orange Is The New Black\n",
        "16- Thank You Next", "17- Bridgerton", "18- One Day", "19- Shahmaran", "20- Ginny & Georgia\n",
        "21- Lucifer", "22- The Witcher", "23- One Piece", "24- Wednesday", "25- Locke & Key\n",
        "26- SpongeBob Squarepants", "27- Miraculous: Tales of Ladybug and Cat Noir","28- Ben10", "29- Adventure Time", "30- World of Winx","\n31- Back to Homepage"};

        for(int i=0;i<seriesArray.length;i++){
            System.out.println(seriesArray[i]);
        }

        System.out.println("\nEnter Your Choice: ");
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
            case 6: displayDeatilsForSeries("Stranger Things",
                    "In 1983, a boy vanishes from a sleepy town. To find him, his friends put their board game skills to the test — but a dark force lurks under the surface.",
                    "Winona Ryder, David Harbour, Millie Bobby Brown, Finn Wolfhard, Gaten Matarazzo, Caleb McLaughlin, Noah Schnapp. Sadie Sink, Natalia Dyer, Charlie Heaton",
                    "The Duffer Brothers","4 season 34 episodes");
            break;
            case 7: displayDeatilsForSeries("Chilling Adventures of Sabrina",
                    "Sabrina's hometown is spooky, her house is a mortuary, and her favorite teacher is possessed. But when the Dark Lord arrives, life turns really sinister.",
                    "Kiernan Shipka, Ross Lynch, Miranda Otto, Lucy Davis, Chance Perdomo, Michelle Gomez, Jaz Sinclair, Lachlan Watson, Gavin Leatherwood, Tati Gabrielle, Adeline Rudolph, Richard Coyle, Abigail Cowen",
                    "Sydney Pollack","4 season 36 episodes");
            break;
            case 8: displayDeatilsForSeries("Hellbound",
                    "This horror thriller from Yeon Sang-ho (“Train to Busan\"), based on a webtoon he wrote, shows humanity's dark sides in the face of otherworldly threats.",
                    "Yoo Ah-in, Kim Hyun-joo, Park Jeong-min, Won Jin-a, Yang Ik-june, Kim Do-yoon, Kim Shin-rock, Ryu Kyung-soo, Lee Re",
                    "Yeon Sang-ho, Choi Gyu-seok","1 season 6 episodes");
            break;
            case 9: displayDeatilsForSeries("Parasyte: The Grey",
                    "When a human-eating alien parasite inadvertently becomes one with a woman, the two embark on an unexpected journey to save humanity from extinction.",
                    "Jeon So-nee, Koo Kyo-hwan, Lee Jung-hyun, Kwon Hae-hyo, Kim In-kwon","Yeon Sang-ho, Ryu Yong-jae",
                    "1 Seaon 6 episodes");
            break;
            case 10: displayDeatilsForSeries("Van Helsing",
                    "After three years in a coma, Vanessa awakens to a world ravaged by vampires. Now, she and a motley band of fellow survivors fight to stay alive.",
                    "Kelly Overton, Jonathan Scarfe, Christopher Heyerdahl, Missy Peregrym, Paul Johansson, Rukiya Bernard, Vincent Gale, Aleks Paunovic, Trezzo Mahoro",
                    "Neil Labute", "5 season 65 episodes");
            break;
            case 11: displayDeatilsForSeries("Bir Erkek Bir Kadın","Two very different people — a cynic and a hopeless romantic — navigate all of life's comic situations and adventures together.",
                    "Demet Evgar, Emre Karayel","Müge Turalı","1 season 20 episodes");
            break;
            case 12: displayDeatilsForSeries("Emily in Paris",
                    "Marketing executive Emily Cooper from Chicago is in Paris\n" +
                            "After securing the positions of their dreams, business, friendship and\n" +
                            "While dealing with love, she embraces his new life full of adventure.",
                    "Lily Collins, Philippine Leroy-Beaulieu, Ashley Park, Lucas Bravo, Kate Walsh, Samuel Arnold, Bruno Gouery,Camille Razat, Lucien Laviscount, Paul Forman, Melia Kreiling, Kevin Dias",
                    "Darren Star","3 season 30 episodes");
            break;
            case 13: displayDeatilsForSeries("Friends",
                    "This popular sitcom tells the story of business, love and life in 1990s Manhattan.It tells the funny adventures of six friends in their 20s who are dealing with the difficulties of daily life.",
                    "Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc, Matthew Perry, David Schwimmer",
                    "David Crane, Marta Kauffman","10 season 235 episodes");
            break;
            case 14: displayDeatilsForSeries("How I Met Your Mother (HIMYM)","We are in 2030; Ted Mosby tells his children the 'long' story of how he met their mother, " +
                            "and suddenly we go back to America in 2005, where five best friends live their fun lives in their 20s. Ted is a 27-year-old architect from Manhattan.",
                    "Josh Radnor,Cobie Smulders,Jason Segel,Alyson Hannigan,Neil Patrick Harris,Joe Manganiello,Suzie Plakson,Bob Saget","Pamela Fryman",
                    "9 season 208 episodes");
            break;
            case 15: displayDeatilsForSeries("Orange is The New Black",
                    "In this darkly comic drama series, an affluent woman adapts to life in prison.",
                    "Taylor Schilling, Kate Mulgrew, Laura Prepon, Jason Biggs, Natasha Lyonne, Michael Harney, Uzo Aduba,Danielle Brooks, Samira Wiley, Dascha Polanco, Selenis Leyva, Nick Sandow, Yael Stone, Taryn Manning, Lea DelLaria",
                    "Jenji Kohan","7 season 91 episodes");
            break;
            case 16: displayDeatilsForSeries("Thank You Next",
                    "Focusing on the lives of 30-year-old Lawyer Leyla and her friends with whom she works at the same law firm," +
                            "Thank You Next is about the modern-day pains they go through, sometimes on the 'bench', sometimes in the 'ghost'," +
                            "sometimes in a 'relationship', and mostly in a 'situationship'.",
                    "Serenay Sarıkaya, Metin Akdülger, Hakan Kurtaş, Boran Kuzum, Ahmet Rıfat Şungar, Bade İşçil, Esra Rusan,Meriç Aral, Efe Tunçer, Kamil Güler, Cem Güler.",
                    "Bertan Başaran", "1 Season 8 episode" );
            break;
            case 17: displayDeatilsForSeries("Bridgerton",
                    "Eight close-knit siblings from the Bridgerton family search for love and happiness in London high society. " +
                            "Inspired by Julia Quinn's bestselling novels.",
                    "Adjoa Andoh, Julie Andrews, Lorraine Ashbourne, Jonathan Bailey, Ruby Barker, Sabrina Bartlett, Harriet Cains,Bessie Carter, Nicola Coughlan, Phoebe Dynevor",
                    "Chris Van Dusen","2 Season 16 episodes");
            break;
            case 18: displayDeatilsForSeries("One Day",
                    "Adapted from David Nicholls' bestselling 2009 novel, One Day is about the lives of Emma Morley and Dexter Mayhew," +
                            " who met on the last day of their studies at the University of Edinburgh in 1988.",
                    "Ambika Mod, Leo Woodall, Essie Davis, Tim McInnerny, Amber Grappy, Jonny Weldon, Eleanor Tomlinson,Brendan Quinn",
                    "Nicole Taylor", "1 Season 14 episodes");
            break;
            case 19: displayDeatilsForSeries("Shahmaran",
                    "In this fantasy drama series, a lonely young woman finds her soulmate and discovers they are both part of an ancient legend.",
                    "Serenay Sarıkaya, Burak Deniz, Mustafa Uğurlu, Mahir Günşiray, Ebru Özkan, Mert Ramazan Demir, Hakan Karahan, Elif Nur Kerkük, Mehmet Bilge Aslan",
                    "Umur Turagay", "1 Season 8 episodes");
            break;
            case 20: displayDeatilsForSeries("Ginny & Georgia",
                    "It begins after Georgia Miller becomes pregnant at a young age and gives birth to Ginny. " +
                            "Georgia is raising Ginny as a mother with a turbulent past. Georgia looks close to Ginny's age " +
                            "and is trying to provide her with a better life by making a fresh start.",
                    "Brianne Howey, Antonia Gentry, Diesel La Torraca, Jennifer Robertson, Felix Mallard, Sara Waisglass, Scott Porter, Raymond Ablack, Aaron Ashmore, Nathan Mitchell.",
                    "Sarah Lampert", "2 Season 20 episodes");
            break;
            case 21: displayDeatilsForSeries("Lucifer",
                    "The series focuses on Lucifer Morningstar, a powerful angel who was expelled from Heaven for his rebellion and was forced to punish humans as the lord of Hell for thousands of years.",
                    "Tom Ellis, Lauren German, Kevin Alejandro, D.B. Woodside, Lesley-Ann Brandt, Aimee Garcia, Scarlett Estevez,Rachael Harris, Inbar Lavi, Tricia Helfer, Tom Welling, Jeremiah W. Birkett, Pej Vahdat, Michael Gladis, Dennis Haysbert,Brianna Hildebrand",
                    "Neil Gaiman","6 season 93 episodes");
            break;
            case 22: displayDeatilsForSeries("The Witcher",
                    "A massive hit across the globe, this epic tale of monsters, magic and destiny is \"incredibly fun to watch and easy to become immersed in,\" says Paste.",
                    "Henry Cavill, Anya Chalotra, Freya Allan, Joey Batey, Eamon Farren, MyAnna Buring, Mimi M Khayisa, Mahesh Jadu, Anna Shaffer, Royce Pierreson, Tom Canton",
                    "Lauren Schmidt Hissrich","3 season 24 episodes");
            break;
            case 23: displayDeatilsForSeries("One Piece", "Stranded on a sinking boat, carefree Luffy begins his journey in search of a pirate king's lost treasure. But first, he'll need a crew, a ship and a map.",
                    "Iñaki Godoy, Emily Rudd, Mackenyu, Jacob Romero Gibson, Taz Skylar, Vincent Regan, Jeff Ward, Morgan Davies",
                    "Steven Maeda, Matt Owens","1 season 8 episodes");
            break;
            case 24: displayDeatilsForSeries("Wednesday",
                    "Wednesday Addams, a smart, sarcastic and slightly depressed girl, meets new friends and friends at Nevermore Academy.murders that occur one after the other while making enemies investigates.",
                    "Jenna Ortega, Gwendoline Christie, Riki Lindhome, Christina Ricci, Jamie McShane, Hunter Doohan, Percy Hynes White, Emma Myers, Joy Sunday",
                    "Alfred Gough, Miles Millar","1 season 8 episodes");
            break;
            case 25: displayDeatilsForSeries("Locke & Key","After their dad's murder, three siblings move with their mom to his ancestral estate, where they discover magical keys that unlock powers — and secrets.",
                    "Darby Stanchfield, Connor Jessup, Emilia Jones, Jackson Robert Scott, Petrice Jones, Laysla De Oliveira, Griffin Gluck, Aaron Ashmore",
                    "Mark Romanek","3 season 28 episodes");
            break;
            case 26:displayDeatilsForSeries("SpongeBob Squarepants",
                    "From his pineapple home base under the sea, SpongeBob and his friends, including his meowing pet snail Gary, get into memorable misadventures.",
                    "Tom Kenny, Rodger Bumpass, Bill Fagerbakke, Clancy Brown, Dee Bradley Baker, Mr. Lawrence, Carolyn Lawrence, Sirena Irwin, Marcelo Pissardini, Wendel Bezerra, Luis PérezPons",
                    "Vincent Waller","7 season 144 episodes");
            break;
            case 27: displayDeatilsForSeries("Miraculous: Tales of Ladybug and Cat Noir",
                    "When Paris encounters danger, Marinette transforms into Ladybug. However, she is unaware that her school sweetheart, Adrien, is also the Black Cat, a city-saving superhero.",
                    "Cristina Valenzuela, Bryce Papenbrook, Keith Silverstein, Mela Lee, Max Mittelman, Barbara Harris","Thomas Astruc","4 season 104 episodes");
            break;
            case 28: displayDeatilsForSeries("Ben10",
                    "Thanks to a mysterious device known as the Omnitrix, mischievo youngster Ben Tennyson has the power to morph into an array of alien superheroes.",
                    "Tara Strong, Paul Eiding, Meagan Smith, Dee Bradley Baker, Jim Ward, Steve Blum, Richard McGonagle, Fred Tatasciore","Duncan Rouleau, Joe Casey, Joe Kelly, Steven T. Seagle",
                    "3 season 39 episodes");
            break;
            case 29: displayDeatilsForSeries("Adventure Time",
                    "Young Finn and his shape-shifting dog buddy, Jake, go on a series of surreal adventures as they journey through the postapocalyptic Land of Ooo.",
                    "Jeremy Shada, John DiMaggio, Hynden Walch, Tom Kenny, Pendleton Ward, Dee Bradley Baker, Niki Yang, Maria Bamford, Steve Little, Olivia Olson",
                    "Pendleton Ward","4 season 52 episodes");
            break;
            case 30: displayDeatilsForSeries("World of Winx",
                    "Five young fairies attend a magical boarding school called Alfea in the Afterlife. Fairies," +
                            " who are approaching adulthood step by step, learn how to control their magical powers while trying to cope with the monsters, love and competition they encounter.",
                    "Haven Paschall, Alysha Deslorieux, Jessica Paquet, Eileen Stevens, Kate Bristol, Saskia Maarleveld, Brittany Pressley, Billy Bob Thompson","Igınio Straffi",
                    "2 season 26 episodes");
            break;
            case 31: return;
            default:
                System.out.println("Invalid choice, please try again!");
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

    public static void main(String[] args) {
        userHints();
    }
}