import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements IShippableProduct, IExpirableProduct {
    // fields
    private LocalDate expirationDate;
    private double weight;

    // constructors
    ExpirableShippableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        setWeight(weight);
    }

    // getters & setters
    @Override
    public LocalDate getExpirationDate() { return this.expirationDate; }

    @Override
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public double getWeight() { return this.weight; }

    @Override
    public void setWeight(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Error during weight assignment for product " + this + " Weight cannot be negative.");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", expiration date: " + expirationDate + ", weight: " + weight + " kg";
    }
}
