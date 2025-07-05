public class Customer {
    // fields
    private String name;
    private Wallet wallet;

    // constructors
    public Customer(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Customer(String name, double balance) {
        this(name, new Wallet(balance));
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Wallet getWallet() { return wallet; }
    public void setWallet(Wallet wallet) {
        if (wallet == null)
            throw new IllegalArgumentException("Error during wallet assignment for customer " + this.name + ": Wallet cannot be null.");
        this.wallet = wallet;
    }
}

