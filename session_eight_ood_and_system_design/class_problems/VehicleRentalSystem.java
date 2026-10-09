import java.util.Objects;

public class VehicleRentalSystem {

    public abstract static class Vehicle {
        private final String model;
        private final double dailyRate;
        private boolean available;

        public Vehicle(String model, double dailyRate) {
            this.model = Objects.requireNonNull(model, "model cannot be null").trim();
            if (dailyRate <= 0) {
                throw new IllegalArgumentException("Daily rate must be positive");
            }
            this.dailyRate = dailyRate;
            this.available = true;
        }

        public String getModel() {
            return model;
        }

        public double getDailyRate() {
            return dailyRate;
        }

        public boolean isAvailable() {
            return available;
        }

        protected void setAvailable(boolean available) {
            this.available = available;
        }

        public abstract double calculateCharge(int days);
    }

    public static class Sedan extends Vehicle {
        public Sedan(String model, double dailyRate) {
            super(model, dailyRate);
        }

        @Override
        public double calculateCharge(int days) {
            return getDailyRate() * days;
        }
    }

    public static class SUV extends Vehicle {
        public SUV(String model, double dailyRate) {
            super(model, dailyRate);
        }

        @Override
        public double calculateCharge(int days) {
            return getDailyRate() * days;
        }
    }

    public static class Truck extends Vehicle {
        public Truck(String model, double dailyRate) {
            super(model, dailyRate);
        }

        @Override
        public double calculateCharge(int days) {
            return getDailyRate() * days;
        }
    }

    public static class Customer {
        private final String name;

        public Customer(String name) {
            this.name = Objects.requireNonNull(name, "Customer name cannot be null").trim();
        }

        public String getName() {
            return name;
        }
    }

    public static class Rental {
        private final Vehicle vehicle;
        private final Customer customer;
        private final int days;
        private final double totalCharge;
        private boolean active;

        private Rental(Vehicle vehicle, Customer customer, int days, double totalCharge) {
            this.vehicle = vehicle;
            this.customer = customer;
            this.days = days;
            this.totalCharge = totalCharge;
            this.active = true;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public Customer getCustomer() {
            return customer;
        }

        public int getDays() {
            return days;
        }

        public double getTotalCharge() {
            return totalCharge;
        }

        public boolean isActive() {
            return active;
        }

        protected void closeRental() {
            this.active = false;
        }
    }

    public static class RentalAgency {
        public Rental rentVehicle(Vehicle vehicle, Customer customer, int days) {
            if (!vehicle.isAvailable()) {
                System.out.println(vehicle.getModel() + " is currently unavailable.");
                return null;
            }
            if (days <= 0) {
                throw new IllegalArgumentException("Rental days must be greater than 0");
            }

            vehicle.setAvailable(false);
            double charge = vehicle.calculateCharge(days);
            Rental rental = new Rental(vehicle, customer, days, charge);
            System.out.printf("%s rented successfully by %s. Rental charge: $%.2f.%n",
                    vehicle.getModel(), customer.getName(), charge);
            return rental;
        }

        public void returnVehicle(Rental rental) {
            if (rental == null || !rental.isActive()) {
                System.out.println("Invalid or already completed rental.");
                return;
            }
            rental.getVehicle().setAvailable(true);
            rental.closeRental();
            System.out.println(rental.getVehicle().getModel() + " returned by " + rental.getCustomer().getName() + ".");
        }
    }

    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Vehicle sedanA = new Sedan("Sedan A", 50.0);
        Vehicle suvB = new SUV("SUV B", 80.0);

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Rental r1 = agency.rentVehicle(sedanA, c1, 3);
        agency.rentVehicle(sedanA, c2, 2);
        agency.returnVehicle(r1);
        agency.rentVehicle(suvB, c3, 5);
    }
}
