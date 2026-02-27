

interface Payment{
    void pay();
}
class CreditCardPayment implements Payment{
    public void pay(){
        System.out.println("Paid using credit card");
    }
}
class UPIPayment implements Payment{
    public void pay(){
        System.out.println("UPI Payment Paid");
    }
}
class PaymentService{
    void ProcessPayment(Payment pymt){
        pymt.pay();
    }
}
public class PaymentOpenClosed{
    public static void main(String[]args){
        Payment credit =new CreditCardPayment();
        Payment upi =new UPIPayment();
        PaymentService pmts =new PaymentService();
        
       pmts.ProcessPayment(credit);
       pmts.ProcessPayment(upi);
    }
}