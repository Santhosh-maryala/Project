public class MultipleRecords {

    public static void main(String[] args) {

        int[] records = { -101, 102, -1, 103, 112, 999, 104 };

        System.out.println("=== Batch Job Started ===");

        for (int i = 0; i < records.length; i++) {

            int record = records[i];

            if (record < 0) {
                System.out.println("Invalid record found: " + record + " (skipped)");
                continue;
            }

            if (record == 999) {
                System.out.println("Critical error on record: " + record);
                System.out.println("Stopping batch job...");
                break;
            }

            System.out.println("Processing record: " + record);
        }

        System.out.println("=== Batch Job Ended ===");
    }
}
