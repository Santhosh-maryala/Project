import java.util.Scanner;

public class AccessValidation{
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for user age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Ask if user has a valid ID
        System.out.print("Do you have a valid ID? (true/false): ");
        boolean hasValidID = scanner.nextBoolean();

        // Ask if user has an active subscription
        System.out.print("Do you have an active subscription? (true/false): ");
        boolean hasActiveSubscription = scanner.nextBoolean();

        // Validate access
        if (age >= 18 && hasValidID && hasActiveSubscription) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Access Denied");
        }

        scanner.close();
    }
}