public class Main {
    public static void main(String[] args) {
        try {
            TestExamples.example01_SuccessfulCheckout();
//            TestExamples.example02_InsufficientFunds();
//            TestExamples.example03_EmptyCart();
//            TestExamples.example04_NegativeQuantity();
//            TestExamples.example05_ExpiredProduct();
//            TestExamples.example06_NegativeWeight();
//            TestExamples.example07_OutOfStock();
//            TestExamples.example08_NoShipping();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
