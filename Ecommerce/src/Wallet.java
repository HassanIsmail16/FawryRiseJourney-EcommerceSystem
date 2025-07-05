public class Wallet {
    // fields
    private double balance;

    // constructor
    public Wallet(double balance) {
        setBalance(balance);
    }
    
    // getters & setters
    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Error during wallet creation. Balance cannot be negative.");
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Couldn't withdraw " + amount + ". Insufficient balance.");
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean canAfford(double amount) {
        return amount <= balance;
    }
}
