# FawryRiseJourney-EcommerceSystem
This is my solution to the e-commerce system assessment task for Fawry Rise Journey Internship.

## Project overview
This is an e-commerce system. 
You can add products with a name, price, and quantity. You can also add products with an expiration date, a weight for shipping, or both.
The system is extensible, you can add new types of products easily based.
A customer can add products to their cart and proceed to checkout.
The system will print a checkout receipt with a shipment notice and will make sure everything is valid then process payment.

## How to run
- You can run the project directly via any java IDE from the `main()` method in the `Main` class.
- You can also run it using javac in your terminal
- Navigate to the `/src` directory
```bash
javac *.java
java Main
```

## Using test examples
- In the `TestExamples` class, you'll find a number of `public` `static` methods prefixed by `example0*`. These methods are example tests you can run from the `main()` method in the `Main` class to test the system's behavior.
- Below is the expected output for each test
  - `TestExamples.example01_SuccessfulCheckout()` : Sucessful checkout
  - `TestExamples.example02_InsufficientFunds()` : Insufficient funds error
  - `TestExamples.example03_EmptyCart()` : Empty cart error
  - `TestExamples.example04_NegativeQuantity()` : Negative quantity error
  - `TestExamples.example05_ExpiredProduct()` : Expired product error
  - `TestExamples.example06_NegativeWeight()` : Negative weight error
  - `TestExamples.example07_OutOfStock()` : Insufficient stock error
  - `TestExamples.example08_NoShipping()` : Sucessful checkout without a shipping notice
