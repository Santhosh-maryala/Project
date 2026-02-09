public class SystemHealthCheck {

    public static void main(String[] args) {

        // Step 1: Consider values
        double totalCPU = 100;
        double usedCPU = 70;

        double totalMemory = 8000;
        double usedMemory = 6000;

        // Step 2: Calculate usage percentage
        double cpuUsage = (usedCPU / totalCPU) * 100;
        double memoryUsage = (usedMemory / totalMemory) * 100;

        // Step 3: Print usage
        System.out.println("CPU Usage: " + cpuUsage + "%");
        System.out.println("Memory Usage: " + memoryUsage + "%");

        // Step 4: Ternary operator for health check
        String cpuStatus = cpuUsage < 75 ? "HEALTHY" : "CRITICAL";
        String memoryStatus = memoryUsage < 80 ? "HEALTHY" : "CRITICAL";

        // Step 5: Print status
        System.out.println("CPU Status: " + cpuStatus);
        System.out.println("Memory Status: " + memoryStatus);
    }
}
