import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class ReportTask implements Callable<String> {
    private String reportName;

    public ReportTask(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Generating " + reportName + " ...");

        Thread.sleep(1000 + (int)(Math.random() * 2000));

        String result = reportName + " generated successfully.";
        System.out.println(result);
        return result;
    }
}

public class ParallelReportGenerator {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new ReportTask("Report1"));
        tasks.add(new ReportTask("Report2"));
        tasks.add(new ReportTask("Report3"));
        tasks.add(new ReportTask("Report4"));
        tasks.add(new ReportTask("Report5"));

        try {
            List<Future<String>> results = executor.invokeAll(tasks);

            System.out.println("\n=== Report Summary ===");

            for (Future<String> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
