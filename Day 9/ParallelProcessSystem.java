
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FileProcessor implements Runnable{
    private String fileName;
    public FileProcessor(String fileName){
        this.fileName=fileName;
    }
    public void run(){
        System.out.println("Started Processing"+fileName+ "by" + Thread.currentThread().getName());
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        System.out.println("Procesing interupted for " +fileName);
        Thread.currentThread().interrupt();
    }
    System.out.println("Completed Processing :" +fileName);
    }
}
public class ParallelProcessSystem{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=1;i<=5;i++){
            executor.submit(new  FileProcessor("File " + i + ".txt"));
        }
        executor.shutdown();
        try {
        if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
            executor.shutdownNow();
        }
        }catch(InterruptedException e){
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("All files proceessed. Executor shutdown complete");
    }
}