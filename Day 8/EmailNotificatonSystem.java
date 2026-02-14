class EmailService implements Runnable {
    private int orderId;

    public EmailService(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("[Email Service] Preparing email for Order " + orderId + "...");
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Email Service] Email sent for Order " + orderId + "!");
    }
}

public class EmailNotificatonSystem {

    public static void processOrder(int orderId) {
        System.out.println("[Main Thread] Processing Order " + orderId + "...");
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread emailThread = new Thread(new EmailService(orderId));
        emailThread.start();

        System.out.println("[Main Thread] Order " + orderId + " confirmed successfully!");
    }

    public static void main(String[] args) {
        processOrder(101);
        System.out.println("[Main Thread] Ready to process next order...");
    }
}
