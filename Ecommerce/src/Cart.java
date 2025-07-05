import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>(); // <CartItem>

    public void addItem(Product product, int quantity) {
        if (quantity < 1)
            throw new IllegalArgumentException("Error while adding item to cart." + product + " Quantity cannot be less than 1.");

        // handle existing item
        CartItem existingItem = items.stream().filter(item -> item.getProduct().equals(product)).findFirst().orElse(null);
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            return;
        }

        // handle new item
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public List<CartItem> getItems() { return items; }
}
