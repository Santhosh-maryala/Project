import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RequestHandler implements Runnable {
    private int requestId;

    public RequestHandler(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void run() {
        System.out.println("Processing request #" + requestId + " by " + Thread.currentThread().getName());
        try {
            
            Thread.sleep(50 + (int)(Math.random() * 100));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed request #" + requestId + " by " + Thread.currentThread().getName());
    }
}

public class HighLoadSimulation {
    public static void main(String[] args) {

        int totalRequests = 100;
        int poolSize = 10;

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        long startTime = System.currentTimeMillis(); 

        for (int i = 1; i <= totalRequests; i++) {
            executor.execute(new RequestHandler(i));
        }

        executor.shutdown();  

       
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis();  
        long totalTime = endTime - startTime;

        System.out.println("\n=== Performance Summary ===");
        System.out.println("Total requests processed: " + totalRequests);
        System.out.println("Thread pool size: " + poolSize);
        System.out.println("Total time taken: " + totalTime + " ms");
        System.out.printf("Average time per request: %.2f ms\n", (double) totalTime / totalRequests);
    }
}
