import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


class Order {
    private final int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}

class OrderProducer implements Runnable {

    private final BlockingQueue<Order> queue;

    public OrderProducer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Order order = new Order(i);
                queue.put(order);  
                System.out.println("Produced Order: " + order.getOrderId());
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

class OrderConsumer implements Runnable {

    private final BlockingQueue<Order> queue;

    public OrderConsumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = queue.take();  
                System.out.println("Processing Order: " + order.getOrderId()
                        + " by " + Thread.currentThread().getName());
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer stopped.");
            Thread.currentThread().interrupt();
        }
    }
}

public class OrderProcessingSystem {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Order> queue = new LinkedBlockingQueue<>(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new OrderProducer(queue));
        executor.submit(new OrderConsumer(queue));

        Thread.sleep(20000);

        executor.shutdownNow();  
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Order Processing System Shutdown Completed.");
    }
}
