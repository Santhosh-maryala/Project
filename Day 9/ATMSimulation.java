import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(String user, double amount) {
        System.out.println(user + " attempting to withdraw ₹" + amount);

        if (balance >= amount) {
            System.out.println("Transaction approved for " + user);
            balance -= amount;

            try {
                Thread.sleep(1000); // simulate ATM processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(user + " successfully withdrew ₹" + amount);
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Transaction failed for " + user + " (Insufficient Balance)");
        }

        System.out.println("-----------------------------------");
    }
}

class ATMUser implements Runnable {
    private BankAccount account;
    private String userName;
    private double amount;

    public ATMUser(BankAccount account, String userName, double amount) {
        this.account = account;
        this.userName = userName;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(userName, amount);
    }
}

public class ATMSimulation {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(new ATMUser(account, "User1", 3000));
        executor.execute(new ATMUser(account, "User2", 4000));
        executor.execute(new ATMUser(account, "User3", 2000));
        executor.execute(new ATMUser(account, "User4", 2500));
        executor.execute(new ATMUser(account, "User5", 1500));

        executor.shutdown();
    }
}
