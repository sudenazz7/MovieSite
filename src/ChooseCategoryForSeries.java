import java.util.Scanner;
public class ChooseCategoryForSeries {
    static Scanner scanner = new Scanner(System.in);
    public static void chooseCatagoryForSeries() {
        System.out.println("Choose a Catagory");
        System.out.println("1-Romantic");
        System.out.println("2-Action");
        System.out.println("3-Horror and Thriller");
        System.out.println("4-Sci-Fi and Fantasy");
        System.out.println("5-Comedy");
        System.out.println("6-Family and Kids\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: Categories.Romantic.displayRomanticSeries(); break;
            case 2: Categories.Action.displayActionSeries(); break;
            case 3: Categories.HorrorAndThriller.displayHorrorAndThrillerSeries(); break;
            case 4: Categories.SciFiAndFantasy.displaySciFiAndFantasySeries(); break;
            case 5: Categories.Comedy.displayComedySeries(); break;
            case 6: Categories.FamilyAndChildren.displayFamilyAndChildrenSeries(); break;
            default:
                System.out.println("Invalid choice. Please try again!");
        }
    }
}
