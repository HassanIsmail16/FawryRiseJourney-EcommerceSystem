import java.time.LocalDate;

public class ExpirableProduct extends Product implements IExpirableProduct {
    // fields
    private LocalDate expirationDate;

    // constructors
    public ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    // getters & setters
    @Override
    public LocalDate getExpirationDate() { return expirationDate; }

    @Override
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate;
    }
}
