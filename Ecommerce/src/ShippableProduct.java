public class ShippableProduct extends Product implements IShippableProduct {
    // fields
    private double weight;

    // constructors
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        setWeight(weight);
    }

    // getters & setters
    @Override
    public double getWeight() { return weight; }

    @Override
    public void setWeight(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Error during weight assignment for product " + this + " Weight cannot be negative.");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", weight:" + weight + "kg";
    }
}
