public class ConfigurationCheck {

    public static void main(String[] args) {

        // Configuration values (simulating values read from config file)
        int maxUsers = 1500;                // maximum number of users allowed
        double threshold = 0.85;            // system threshold limit
        boolean featureEnabled = true;      // feature flag
        String environment = "PROD";        // environment name

        // Print configuration values
        System.out.println("Environment    : " + environment);
        System.out.println("Max Users      : " + maxUsers);
        System.out.println("Threshold      : " + threshold);
        System.out.println("Feature Enabled: " + featureEnabled);

        // Defined safe limits
        int maxUserLimit = 1000;
        double thresholdLimit = 0.80;

        // Validate configuration and print warnings
        if (maxUsers > maxUserLimit) {
            System.out.println("WARNING: Max users exceed the allowed limit!");
        }

        if (threshold > thresholdLimit) {
            System.out.println("WARNING: Threshold exceeds the safe limit!");
        }
    }
}
