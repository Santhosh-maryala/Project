import java.util.Scanner;

public class AcidProperties {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== ACID PROPERTIES MENU ===");
            System.out.println("1. Definition of Acid");
            System.out.println("2. Physical Properties");
            System.out.println("3. Chemical Properties");
            System.out.println("4. pH Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nDefinition:");
                    System.out.println("An acid is a substance that produces hydrogen ions (H+) in water.");
                    break;

                case 2:
                    System.out.println("\nPhysical Properties of Acids:");
                    System.out.println("- Sour in taste");
                    System.out.println("- Turn blue litmus paper red");
                    System.out.println("- Conduct electricity in aqueous solution");
                    break;

                case 3:
                    System.out.println("\nChemical Properties of Acids:");
                    System.out.println("- React with metals to produce hydrogen gas");
                    System.out.println("  Example: Zn + 2HCl -> ZnCl2 + H2");
                    System.out.println("- React with bases to form salt and water (Neutralization)");
                    System.out.println("  Example: HCl + NaOH -> NaCl + H2O");
                    break;

                case 4:
                    System.out.println("\npH Information:");
                    System.out.println("- Acids have pH less than 7");
                    System.out.println("- Strong acids: pH 0-3");
                    System.out.println("- Weak acids: pH 4-6");
                    break;

                case 5:
                    System.out.println("Exiting program... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}