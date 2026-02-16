

public class DeadLockPrevention{
    private static final Object paymentLock =new Object();
    private static final Object inventoryLock =new Object();

    public static void processOrder(String threadName){
        synchronized (paymentLock) {
            System.out.println(threadName+"locked Payment");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) 
            {
                Thread.currentThread().interrupt();
            }
            synchronized (inventoryLock) {
                System.out.println(threadName+" locked Inventory");
                System.out.println(threadName+"processing order");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(threadName +"order completed");
                
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 =new Thread(( )-> processOrder("thread-1"));
        Thread t2 =new Thread(() -> processOrder("thread-2"));
        t1.start();
        t2.start();
    }
}
