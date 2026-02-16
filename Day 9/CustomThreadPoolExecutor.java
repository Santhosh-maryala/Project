
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor{
    public static void main(String[] args) {
        int corePoolSize=4;
        int maxPoolSize=8;
        int queueCapacity =5;
        long keepAliveTime =10;

        BlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(queueCapacity);
        ThreadPoolExecutor exu = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,TimeUnit.SECONDS,queue, new ThreadPoolExecutor.CallerRunsPolicy());
    
    System.out.println("Submitting 30 tasks");

    for(int i=1;i<=30;i++){
        int taskId =i;
        exu.execute(() ->{
            System.out.println("Task " + taskId + "running by"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task"+taskId+"completed");
        });
        System.out.println("Pool Size: " + exu.getPoolSize() + " | Active Thread :" + exu.getActiveCount()+ "| Queue Size:" +exu.getQueue().size()); 
    }
    exu.shutdown();
    }
}
