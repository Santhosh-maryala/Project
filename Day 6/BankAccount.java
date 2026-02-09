class Bank {

    private int balance = 0;

    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Not enough balance");
        }
    }

    public void showBalance() {
        System.out.println("Balance Amount: " + balance);
    }
}

public class BankAccount {
    public static void main(String[] args) {

        Bank bk = new Bank();
        bk.deposit(500);
        bk.withdraw(200);
        bk.showBalance();
        bk.withdraw(500); 
    }
}
