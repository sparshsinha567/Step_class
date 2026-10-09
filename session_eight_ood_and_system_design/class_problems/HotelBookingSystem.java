import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HotelBookingSystem {

    public abstract static class Room {
        private final String roomNumber;
        private final double ratePerNight;

        public Room(String roomNumber, double ratePerNight) {
            this.roomNumber = Objects.requireNonNull(roomNumber).trim();
            this.ratePerNight = ratePerNight;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public double getRatePerNight() {
            return ratePerNight;
        }

        public abstract String getCategoryName();

        public abstract double calculatePrice(int nights);

        @Override
        public String toString() {
            return getCategoryName() + " " + roomNumber;
        }
    }

    public static class StandardRoom extends Room {
        public StandardRoom(String roomNumber) {
            super(roomNumber, 100.0);
        }

        @Override
        public String getCategoryName() {
            return "Standard Room";
        }

        @Override
        public double calculatePrice(int nights) {
            return getRatePerNight() * nights;
        }
    }

    public static class DeluxeRoom extends Room {
        public DeluxeRoom(String roomNumber) {
            super(roomNumber, 150.0);
        }

        @Override
        public String getCategoryName() {
            return "Deluxe Room";
        }

        @Override
        public double calculatePrice(int nights) {
            return getRatePerNight() * nights;
        }
    }

    public static class Suite extends Room {
        public Suite(String roomNumber) {
            super(roomNumber, 250.0);
        }

        @Override
        public String getCategoryName() {
            return "Suite";
        }

        @Override
        public double calculatePrice(int nights) {
            return getRatePerNight() * nights;
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

    public static class SimpleDate {
        private final String month;
        private final int day;

        public SimpleDate(String month, int day) {
            this.month = month.trim();
            this.day = day;
        }

        public int getDay() {
            return day;
        }

        public String getMonth() {
            return month;
        }

        public boolean isBefore(SimpleDate other) {
            if (!this.month.equalsIgnoreCase(other.month)) {
                return this.month.compareTo(other.month) < 0;
            }
            return this.day < other.day;
        }

        public boolean overlaps(SimpleDate s1, SimpleDate e1, SimpleDate s2, SimpleDate e2) {
            if (!s1.month.equalsIgnoreCase(s2.month)) {
                return false;
            }
            return Math.max(s1.day, s2.day) < Math.min(e1.day, e2.day);
        }
    }

    public static class Reservation {
        private final Customer customer;
        private final Room room;
        private final String dateRange;
        private final int startDay;
        private final int endDay;
        private final String month;
        private final double price;
        private boolean active;

        public Reservation(Customer customer, Room room, String month, int startDay, int endDay, double price) {
            this.customer = customer;
            this.room = room;
            this.month = month;
            this.startDay = startDay;
            this.endDay = endDay;
            this.dateRange = month + " " + startDay + " to " + month + " " + endDay;
            this.price = price;
            this.active = true;
        }

        public Customer getCustomer() {
            return customer;
        }

        public Room getRoom() {
            return room;
        }

        public String getDateRange() {
            return dateRange;
        }

        public double getPrice() {
            return price;
        }

        public boolean isActive() {
            return active;
        }

        public void cancel() {
            this.active = false;
        }

        public boolean overlaps(String m, int s, int e) {
            if (!this.active) return false;
            if (!this.month.equalsIgnoreCase(m)) return false;
            return Math.max(this.startDay, s) < Math.min(this.endDay, e);
        }
    }

    public static class Hotel {
        private final List<Reservation> reservations = new ArrayList<>();

        public boolean isAvailable(Room room, String month, int startDay, int endDay) {
            for (Reservation res : reservations) {
                if (res.getRoom().getRoomNumber().equals(room.getRoomNumber()) && res.overlaps(month, startDay, endDay)) {
                    return false;
                }
            }
            return true;
        }

        public void checkAvailability(Room room, String month, int startDay, int endDay) {
            if (isAvailable(room, month, startDay, endDay)) {
                System.out.printf("%s is available from %s %d to %s %d.%n",
                        room.toString(), month, startDay, month, endDay);
            } else {
                System.out.printf("%s is not available from %s %d to %s %d.%n",
                        room.toString(), month, startDay, month, endDay);
            }
        }

        public Reservation bookRoom(Customer customer, Room room, String month, int startDay, int endDay) {
            if (!isAvailable(room, month, startDay, endDay)) {
                System.out.printf("%s is not available from %s %d to %s %d.%n",
                        room.toString(), month, startDay, month, endDay);
                return null;
            }
            int nights = endDay - startDay;
            double price = room.calculatePrice(nights);
            Reservation reservation = new Reservation(customer, room, month, startDay, endDay, price);
            reservations.add(reservation);
            System.out.printf("Reservation confirmed for %s, %s (%s %d-%d). Price: $%.2f.%n",
                    customer.getName(), room.toString(), month, startDay, endDay, price);
            return reservation;
        }

        public void cancelReservation(Reservation reservation, String label) {
            if (reservation != null && reservation.isActive()) {
                reservation.cancel();
                System.out.printf("Reservation for %s, %s (%s) cancelled successfully.%n",
                        reservation.getCustomer().getName(), reservation.getRoom().toString(), label);
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        StandardRoom room101 = new StandardRoom("101");
        DeluxeRoom room201 = new DeluxeRoom("201");

        Customer custA = new Customer("Customer A");
        Customer custB = new Customer("Customer B");
        Customer custC = new Customer("Customer C");

        hotel.checkAvailability(room101, "Jan", 1, 5);
        Reservation resA = hotel.bookRoom(custA, room101, "Jan", 1, 5);
        hotel.bookRoom(custB, room101, "Jan", 3, 7);
        hotel.cancelReservation(resA, "Jan 1-5");
        hotel.bookRoom(custC, room201, "Feb", 10, 12);
    }
}
