

class Order implements Runnable{
    private final int orderId;

    public Order(int orderId){
        this.orderId=orderId;
    }

    private void validateOrder(){
        System.out.println(Thread.currentThread().getName() +"  -Order "+ orderId+"iS being validated...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private  void processPayment(){
        System.out.println(Thread.currentThread().getName()+" Payment processing for order "+orderId+" ..");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void complteOrder(){
        System.out.println(Thread.currentThread().getName()+" -Order "+ orderId+" Completed Successfully!");        
    }

    public void run(){
        validateOrder();
        processPayment();
        complteOrder();
    }
}
public class ECommerceOrder{
    public static void main(String[] args) {

        for(int i=0;i<=5;i++){
            Order or =new Order(i);

            Thread th=new Thread(or);
            th.setName("Order-thread-"+i);
            th.start();
        }
        System.out.println("All orders are being processsed Concurrently....");

    }
}