
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledCleanUp{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler =Executors.newScheduledThreadPool(1);
        Runnable cleanupTask = new Runnable(){
            
            @Override
            public void run(){
                System.out.println("Cleanup started at: " + System.currentTimeMillis()+ "| Thread :" +Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Cleanup interrupted");
                    Thread.currentThread().interrupt();
                }
                System.out.println("Cleanup Completed");
            }
        };
        System.out.println("Starting scheduled cleanup job");
        scheduler.scheduleAtFixedRate(cleanupTask, 0,5, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable(){
            @Override
            public void run(){
                System.out.println("Stopping scheduler");
                scheduler.shutdown();
            }
            
        },20,TimeUnit.SECONDS);
    }
}