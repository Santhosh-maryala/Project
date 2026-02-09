public class ServerLoadMonitor {
    public static void main(String[] args) {
        double[] cpuLoads = {25.5, 40.0, 85.2, 10.5, 60.1, 95.0, 30.0};

        double highest = cpuLoads[0];
        double lowest = cpuLoads[0];
        double sum = 0;

        for (double load : cpuLoads) {
            if (load > highest) highest = load;
            if (load < lowest) lowest = load;
            sum += load;
        }

        double average = sum / cpuLoads.length;

        System.out.println("--- Daily Server Load Monitoring ---");
        System.out.println("Highest Load: " + highest + "%");
        System.out.println("Lowest Load: " + lowest + "%");
        System.out.printf("Average Load: %.2f%%\n", average);
    }
}
