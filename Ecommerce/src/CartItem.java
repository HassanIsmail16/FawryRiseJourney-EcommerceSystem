public class CartItem {
    // fields
    private final Product product;
    private int quantity;

    // constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // getters & setters
    public Product getProduct() { return product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Error during setting quantity." + product + " Quantity cannot be negative.");
        this.quantity = quantity;
    }
}
