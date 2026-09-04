public class CanteenPaymentDispatch {

    public static class Payment {
        public double pay(double amount) {
            System.out.printf("Paid (cash): Rs %.1f\n", amount);
            return amount;
        }
    }

    public static class CardPayment extends Payment {
        public double payWithProcessingFee(double amount) {
            double totalWithFee = amount + (amount * 0.02);
            System.out.printf("Charged (card, incl. fee): Rs %.1f\n", totalWithFee);
            return totalWithFee;
        }

        @Override
        public double pay(double amount) {
            return payWithProcessingFee(amount);
        }
    }

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment;
            return card.payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100.0, 50.0, 200.0, 75.0, 120.0};
        double totalCollected = 0.0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }

        System.out.printf("Total Collected: Rs %.1f\n", totalCollected);
    }
}
