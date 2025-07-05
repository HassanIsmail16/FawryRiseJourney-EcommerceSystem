import java.time.LocalDate;

public class TestExamples {
    public static void example01_SuccessfulCheckout() {
        System.out.println("====== EXAMPLE 01 - SUCCESSFUL CHECKOUT ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 20, LocalDate.now(), 0.2);
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct("Biscuits", 75,  10, LocalDate.now(), 0.7);
        ShippableProduct tv = new ShippableProduct("TV", 999.99, 10, 5);
        Product scratchCard = new Product("Scratch Card", 10, 12);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(tv, 1);
        cart.addItem(scratchCard, 3);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example02_InsufficientFunds() {
        System.out.println("====== EXAMPLE 02 - INSUFFICIENT FUNDS ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 10, 200, LocalDate.now(), 0.2);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 20);

        // checkout
        Customer customer = new Customer("Hassan", 100);
        Store.checkout(cart, customer);
    }

    public static void example03_EmptyCart() {
        System.out.println("====== EXAMPLE 03 - EMPTY CART ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 20, LocalDate.now(), 0.2);
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct("Biscuits", 75,  10, LocalDate.now(), 0.7);
        ShippableProduct tv = new ShippableProduct("TV", 999.99, 10, 5);
        Product scratchCard = new Product("Scratch Card", 10, 12);

        // cart
        Cart cart = new Cart();

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example04_NegativeQuantity() {
        System.out.println("====== EXAMPLE 04 - NEGTAIVE QUANTITY ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, -20, LocalDate.now(), 0.2);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 2);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example05_ExpiredProduct() {
        System.out.println("====== EXAMPLE 05 - EXPIRED PRODUCT ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 20, LocalDate.of(2024, 1, 1), 0.2);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 2);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example06_NegativeWeight() {
        System.out.println("====== EXAMPLE 06 - NEGATIVE WEIGHT ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 20, LocalDate.now(), -0.2);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 2);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example07_OutOfStock() {
        System.out.println("====== EXAMPLE 07 - OUT OF STOCK ======");
        // products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 20, LocalDate.now(), 0.2);

        // cart
        Cart cart = new Cart();
        cart.addItem(cheese, 200);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }

    public static void example08_NoShipping() {
        System.out.println("====== EXAMPLE 08 - NO SHIPPING ======");
        // products

        Product scratchCard = new Product("Scratch Card", 10, 12);

        // cart
        Cart cart = new Cart();
        cart.addItem(scratchCard, 2);

        // checkout
        Customer customer = new Customer("Hassan", 10000);
        Store.checkout(cart, customer);
    }
}
