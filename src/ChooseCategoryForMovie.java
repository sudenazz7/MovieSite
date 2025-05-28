import java.util.Scanner;
public class ChooseCategoryForMovie {
    static Scanner scanner = new Scanner(System.in);
    public static void chooseCatagoryForMovie() {
        System.out.println("Choose a Catagory");
        System.out.println("1-Romantic");
        System.out.println("2-Action");
        System.out.println("3-Horror and Thriller");
        System.out.println("4-Sci-Fi and Fantasy");
        System.out.println("5-Comedy");
        System.out.println("6-Family and Kids\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: Categories.Romantic.displayRomanticMovies(); break;
            case 2: Categories.Action.displayActionMovies(); break;
            case 3: Categories.HorrorAndThriller.displayHorrorAndThrillerMovies(); break;
            case 4: Categories.SciFiAndFantasy.displaySciFiAndFantasyMovies(); break;
            case 5: Categories.Comedy.displayComedyMovies(); break;
            case 6: Categories.FamilyAndChildren.displayFamilyAndChildrenMovies(); break;
            default:
                System.out.println("Invalid choice. Please try again!");
        }
    }
}
