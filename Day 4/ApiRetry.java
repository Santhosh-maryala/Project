public class ApiRetry {

    public static void main(String[] args) {

        int maxRetries = 3;
        int attempt = 1;
        boolean success = false;

        while (attempt <= maxRetries && !success) {
            System.out.println("Attempt " + attempt + ": Calling API...");

            // Simulated API call
            success = callApi();

            if (success) {
                System.out.println("API call successful!");
            } else {
                System.out.println("API call failed. Retrying...");
            }

            attempt++;
        }

        if (!success) {
            System.out.println("API call failed after maximum retries.");
        }
    }

    // Simulated API method
    private static boolean callApi() {
        // Random success/failure
        return Math.random() > 0.7;
    }
}
