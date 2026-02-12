import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}

abstract class BankAccount {
    private final String accNum;
    private double balance;
    private final List<String> transactions = new ArrayList<>();

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BankAccount(String accNum, double balance) {
        this.accNum = accNum;
        this.balance = balance;
        addTransaction("Created: $" + balance);
    }
    public void deposit(double amount) { balance += amount; addTransaction("Deposited: $" + amount); }
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    public double getBalance() { return balance; }
    public String getAccNum() { return accNum; }
    protected void setBalance(double balance) { this.balance = balance; }
    protected void addTransaction(String t) { transactions.add(t); }
    public List<String> getTransactions() { return transactions; }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String n, double b) { super(n, b); }
    @Override
    public void withdraw(double a) throws InsufficientBalanceException {
        if (getBalance() < a) throw new InsufficientBalanceException("No overdraft allowed.");
        setBalance(getBalance() - a); addTransaction("Withdrew: $" + a);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String n, double b) { super(n, b); }
    @Override
    public void withdraw(double a) throws InsufficientBalanceException {
        if (getBalance() + 1000 < a) throw new InsufficientBalanceException("Overdraft limit exceeded.");
        setBalance(getBalance() - a); addTransaction("Withdrew: $" + a);
    }
}

public class BankingSystemDemo {
    private static final Map<String, BankAccount> accounts = new HashMap<>();
    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner sc = new Scanner(System.in);

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Balance 5.History 6.Exit");
            int ch = sc.nextInt(); sc.nextLine();
            if (ch == 6) break;
            try {
                if (ch == 1) {
                    System.out.print("Num, Bal, Type(S/C): ");
                    String n = sc.next(), t = sc.next();
                    double b = sc.nextDouble();
                    accounts.put(n, t.equalsIgnoreCase("S") ? new SavingsAccount(n, b) : new CurrentAccount(n, b));
                } else {
                    System.out.print("Account Num: ");
                    BankAccount acc = accounts.get(sc.next());
                    if (acc == null) System.out.println("Not found.");
                    else if (ch == 2) { System.out.print("Amt: "); acc.deposit(sc.nextDouble()); }
                    else if (ch == 3) { System.out.print("Amt: "); acc.withdraw(sc.nextDouble()); }
                    else if (ch == 4) System.out.println("Bal: " + acc.getBalance());
                    else if (ch == 5) acc.getTransactions().forEach(System.out::println);
                }
            } catch (Exception e) { System.out.println(e.getMessage()); }
        }
    }
}
