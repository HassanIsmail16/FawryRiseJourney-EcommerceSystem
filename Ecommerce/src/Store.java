import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Store {
    public static void checkout(Cart cart, Customer customer) {
        validateCart(cart);
        Map<IShippableProduct, Integer> shipment = prepareShipment(cart);
        ShippingService.printShipmentNotice(shipment);
        printCheckoutDetails(cart, customer, shipment);
        boolean paymentSuccessful = processPayment(customer, getTotalAmount(cart.getTotalPrice(), ShippingService.calculateShippingCost(shipment)));
        if (paymentSuccessful)
            updateInventory(cart);
    }

    private static void validateCart(Cart cart) {
        // empty cart validation
        if (cart.getItems().isEmpty())
            throw new IllegalArgumentException("Error during checkout. Cart is empty.");

        // quantity validation
        for (CartItem item : cart.getItems()) {
            if (item.getQuantity() < 1)
                throw new IllegalArgumentException("Error during checkout. " + item.getProduct() + " quantity cannot be less than 1.");

            if (item.getProduct().getQuantity() < item.getQuantity())
                throw new IllegalArgumentException("Error during checkout. " + item.getProduct() + " Not enough quantity in stock. (requested: " + item.getQuantity() +  ", available: " +  item.getProduct().getQuantity() +  ")");

            if (item.getProduct() instanceof IExpirableProduct expirable) {
                if (expirable.getExpirationDate().isBefore(LocalDate.now()))
                    throw new IllegalArgumentException("Error during checkout. Product " + expirable.toString() + " is expired.");
            }
        }
    }

    private static Map<IShippableProduct, Integer> prepareShipment(Cart cart) {
        Map<IShippableProduct, Integer> shipment = new HashMap<>();

        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof IShippableProduct product) {
                shipment.put(product, item.getQuantity());
            }
        }

        return shipment;
    }

    private static void printCheckoutDetails(Cart cart, Customer customer, Map<IShippableProduct, Integer> shipment) {
        System.out.println("** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-15s %.0f\n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }

        System.out.println("----------------------");

        // total
        double subtotal = cart.getTotalPrice();
        double shippingCost = ShippingService.calculateShippingCost(shipment);
        double totalAmount = getTotalAmount(subtotal, shippingCost);

        System.out.printf("%-18s %.0f\n", "Subtotal", subtotal);
        System.out.printf("%-18s %.0f\n", "Shipping", shippingCost);
        System.out.printf("%-18s %.0f\n", "Amount", totalAmount);

        System.out.println("----------------------");
    }

    private static double getTotalAmount(double subtotal, double shippingCost) {
        return subtotal + shippingCost;
    }

    private static boolean processPayment(Customer customer, double totalAmount) {
        if (customer.getWallet().canAfford(totalAmount)) {
            customer.getWallet().withdraw(totalAmount);
            System.out.println("Payment successful!");
            System.out.printf("Customer %s's balance is now %.0f\n", customer.getName(), customer.getWallet().getBalance());
            return true;
        } else {
            System.err.println("Insufficient funds!");
            return false;
        }
    }

    private static void updateInventory(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }
    }
}
