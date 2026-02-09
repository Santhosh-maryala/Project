import java.util.Scanner;

public class ApplicationMenuSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Loop until user chooses to exit
        while (true) {

            // Display menu
            System.out.println("\n=== Application Menu ===");
            System.out.println("1. Start Service");
            System.out.println("2. Stop Service");
            System.out.println("3. Restart Service");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            // Switch case to perform actions
            switch (choice) {
                case 1 -> System.out.println("Service started successfully.");

                case 2 -> System.out.println("Service stopped successfully.");

                case 3 -> System.out.println("Service restarted successfully.");

                case 4 -> {
                    System.out.println("Exiting application...");
                    sc.close();
                    return; // Exit the program
                }
                default -> System.out.println("Invalid choice! Please select 1–4.");
            }
        }
    }
}