import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaymentProcessingSystem {

    public enum OrderStatus {
        PENDING, PAID, CANCELLED
    }

    public static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            this.name = Objects.requireNonNull(name).trim();
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class OrderItem {
        private final Product product;
        private final int quantity;

        public OrderItem(Product product, int quantity) {
            this.product = Objects.requireNonNull(product);
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getSubtotal() {
            return product.getPrice() * quantity;
        }
    }

    public static class Customer {
        private final String name;

        public Customer(String name) {
            this.name = Objects.requireNonNull(name).trim();
        }

        public String getName() {
            return name;
        }
    }

    public interface PaymentMethod {
        String getName();
        boolean processPayment(double amount);
    }

    public static class CreditCardPayment implements PaymentMethod {
        private final boolean simulateSuccess;

        public CreditCardPayment(boolean simulateSuccess) {
            this.simulateSuccess = simulateSuccess;
        }

        @Override
        public String getName() {
            return "Credit Card";
        }

        @Override
        public boolean processPayment(double amount) {
            return simulateSuccess;
        }
    }

    public static class PayPalPayment implements PaymentMethod {
        private final boolean simulateSuccess;

        public PayPalPayment(boolean simulateSuccess) {
            this.simulateSuccess = simulateSuccess;
        }

        @Override
        public String getName() {
            return "PayPal";
        }

        @Override
        public boolean processPayment(double amount) {
            return simulateSuccess;
        }
    }

    public static class BankTransferPayment implements PaymentMethod {
        private final boolean simulateSuccess;

        public BankTransferPayment(boolean simulateSuccess) {
            this.simulateSuccess = simulateSuccess;
        }

        @Override
        public String getName() {
            return "Bank Transfer";
        }

        @Override
        public boolean processPayment(double amount) {
            return simulateSuccess;
        }
    }

    public static class Order {
        private final String orderId;
        private final Customer customer;
        private final List<OrderItem> items;
        private OrderStatus status;

        public Order(String orderId, Customer customer) {
            this.orderId = Objects.requireNonNull(orderId).trim();
            this.customer = Objects.requireNonNull(customer);
            this.items = new ArrayList<>();
            this.status = OrderStatus.PENDING;
            System.out.println("Order created for " + customer.getName() + ".");
        }

        public void addItem(Product product, int quantity) {
            items.add(new OrderItem(product, quantity));
        }

        public double getTotal() {
            double sum = 0;
            for (OrderItem item : items) {
                sum += item.getSubtotal();
            }
            return sum;
        }

        public List<OrderItem> getItems() {
            return items;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public String getOrderId() {
            return orderId;
        }

        public Customer getCustomer() {
            return customer;
        }

        public boolean processPayment(PaymentMethod method) {
            if (items.isEmpty()) {
                System.out.println("Cannot process payment for an empty order.");
                return false;
            }

            System.out.printf("Payment initiated via %s for %s. ", method.getName(), orderId);
            boolean success = method.processPayment(getTotal());
            if (success) {
                this.status = OrderStatus.PAID;
                System.out.printf("Payment for %s successful. Order status: Paid.%n", orderId);
                return true;
            } else {
                System.out.printf("Payment for %s failed. Order status: Pending.%n", orderId);
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Product prodA = new Product("Product A", 20.0);
        Product prodB = new Product("Product B", 30.0);
        Product prodC = new Product("Product C", 50.0);

        Customer custX = new Customer("Customer X");
        Order orderX = new Order("Order X", custX);
        orderX.addItem(prodA, 2);
        orderX.addItem(prodB, 1);
        orderX.processPayment(new CreditCardPayment(true));

        Customer custY = new Customer("Customer Y");
        Order orderY = new Order("Customer Y", custY);
        orderY.processPayment(new CreditCardPayment(true));

        Customer custZ = new Customer("Customer Z");
        Order orderZ = new Order("Order Z", custZ);
        orderZ.addItem(prodC, 1);
        orderZ.processPayment(new PayPalPayment(false));
    }
}
