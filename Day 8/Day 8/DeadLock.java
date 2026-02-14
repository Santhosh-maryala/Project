class BankAccount {
    double balance;
    String name;
    int id; 

    public BankAccount(String name, double balance, int id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }
    void withdraw(double amount) { balance -= amount; }
    void deposit(double amount) { balance += amount; }
}

public class DeadLock {
    public static void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount firstLock = from.id < to.id ? from : to;
        BankAccount secondLock = from.id < to.id ? to : from;

        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " locked " + firstLock.name);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + " locked " + secondLock.name);
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public static void main(String[] args) {
        final BankAccount accountA = new BankAccount("A", 1000, 1);
        final BankAccount accountB = new BankAccount("B", 1000, 2);

        Thread t1 = new Thread(() -> transfer(accountA, accountB, 100), "Thread1");
        Thread t2 = new Thread(() -> transfer(accountB, accountA, 100), "Thread2");

        t1.start();
        t2.start();
    }
}
