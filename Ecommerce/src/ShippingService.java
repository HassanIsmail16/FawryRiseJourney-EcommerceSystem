import java.util.Map;

public class ShippingService {
    private static final double SHIPPING_COST_PER_KG = 30;

    public static void printShipmentNotice(Map<IShippableProduct, Integer> items) {
        if (items.isEmpty()) {
            System.out.println("** Nothing to ship **");
            return;
        }

        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (Map.Entry<IShippableProduct, Integer> entry : items.entrySet()) {
            IShippableProduct product = entry.getKey();
            int quantity = entry.getValue();
            double weight = product.getWeight() * 1000; // weight in grams
            totalWeight += product.getWeight() * quantity;

            System.out.printf("%dx %-15s %.0fg" + "\n",
                    quantity,
                    product.getName(),
                    weight * quantity);
        }

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }

    public static double calculateShippingCost(Map<IShippableProduct, Integer> shipment) {
        double totalWeight = 0;
        for (Map.Entry<IShippableProduct, Integer> entry : shipment.entrySet()) {
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }
        return totalWeight * SHIPPING_COST_PER_KG;
    }
}
