class Account{
    private int balance=10000;

    public synchronized void withdraw(int amount,String customerName){
        System.out.println(customerName +" is trying to withdraw :"+ amount);

        if(balance>=amount){
            System.out.println(customerName + " withdraw is process...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -=amount;
            System.out.println(customerName +" Successfully withdraw " +amount);
            System.out.println("Remaining balance: "+balance);

        }else{
            System.out.println(customerName + "cannot withdraw Insufficent balance");
        }
        System.out.println("=-----------------------");
    }
}
class Customer extends Thread{

    private Account account;
    private int amount;
    public Customer(Account account,String name,int amount){
        super(name);
        this.account=account;
        this.amount=amount;
    }
    public void run(){
        account.withdraw(amount, Thread.currentThread().getName());}
        }

public class BankTransactionSystem{
    public static void main(String[] args) {
        Account sharedAccount =new Account();

        Customer C1 =new Customer(sharedAccount,"Customer 1",600);
        Customer C2 =new Customer(sharedAccount,"Customer 2" ,800);
        Customer C3 =new Customer(sharedAccount,"Customer 3" ,900);

        C1.start();
        C2.start();
        C3.start();
    }

}