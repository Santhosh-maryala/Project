
import java.util.Random;


//Payment Gateway Delay Simulation

class Payment extends Thread{
    private String paymentId;
    private Random rndm =new Random();

     Payment(String paymentId) {
        this.paymentId=paymentId;
    }
    @Override
    public void run(){
        try {
            System.out.println(paymentId + "Start Verification");
            int delay = 1000 + rndm.nextInt(2000);
            Thread.sleep(delay);
            System.out.println(paymentId+"Completed after" +(delay/1000.0)+"seconds");
        } 
        catch (InterruptedException e) {
            System.out.println(paymentId +" was interrupted");
        }
    }   
}
public class PaymentGateway{
    public static void main(String[] args) {
        Payment p1 =new Payment("Payment-1");
        Payment p2 =new Payment("Payment-2");
        Payment p3 =new Payment("Payment-3");
        p1.start();
        p2.start(); 
        p3.start();
    }
}