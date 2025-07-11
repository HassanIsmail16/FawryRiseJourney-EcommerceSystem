public class Product {
    // fields
    private String name;
    private double price;
    private int quantity;

    // constructors
    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Error during price assignment for product " + this + ": Price cannot be negative.");
        this.price = price;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Error during quantity assignment for product " + this + ": Quantity cannot be negative.");
        this.quantity = quantity;
    }
    public void increaseQuantity(int addedAmount) { this.quantity += addedAmount; }
    public void decreaseQuantity(int removedAmount) { this.quantity -= Math.min(removedAmount, quantity); }

    @Override
    public String toString() {
        return "name: '" + name + '\'' +
            ", price: " + price +
            ", quantity: " + quantity;
    }
}
