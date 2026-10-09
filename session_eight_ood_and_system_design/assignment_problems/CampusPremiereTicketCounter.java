import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Implement: The Campus Premiere Ticket Counter
public class CampusPremiereTicketCounter {

    public interface Seat {
        String getSeatNumber();
        double getPrice();
        String getCategory();
    }

    public static class RegularSeat implements Seat {
        private final String seatNumber;

        public RegularSeat(String seatNumber) {
            this.seatNumber = Objects.requireNonNull(seatNumber).trim();
        }

        @Override
        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public double getPrice() {
            return 150.00;
        }

        @Override
        public String getCategory() {
            return "Regular";
        }
    }

    public static class PremiumSeat implements Seat {
        private final String seatNumber;

        public PremiumSeat(String seatNumber) {
            this.seatNumber = Objects.requireNonNull(seatNumber).trim();
        }

        @Override
        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public double getPrice() {
            return 250.00;
        }

        @Override
        public String getCategory() {
            return "Premium";
        }
    }

    public static class ReclinerSeat implements Seat {
        private final String seatNumber;

        public ReclinerSeat(String seatNumber) {
            this.seatNumber = Objects.requireNonNull(seatNumber).trim();
        }

        @Override
        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public double getPrice() {
            return 400.00;
        }

        @Override
        public String getCategory() {
            return "Recliner";
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

    public static class Show {
        private final String name;
        private final String time;
        private final Set<String> bookedSeatNumbers;
        private boolean showStarted;

        public Show(String name, String time) {
            this.name = Objects.requireNonNull(name).trim();
            this.time = Objects.requireNonNull(time).trim();
            this.bookedSeatNumbers = new HashSet<>();
            this.showStarted = false;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        public boolean isShowStarted() {
            return showStarted;
        }

        public void setShowStarted(boolean showStarted) {
            this.showStarted = showStarted;
        }

        public boolean isSeatAvailable(String seatNumber) {
            return !bookedSeatNumbers.contains(seatNumber);
        }

        public synchronized Booking bookSeats(Customer customer, List<Seat> seats) {
            if (seats == null || seats.isEmpty()) {
                System.out.println("No seats selected.");
                return null;
            }
            if (seats.size() > 6) {
                System.out.println("Cannot book more than 6 seats per booking.");
                return null;
            }

            for (Seat seat : seats) {
                if (bookedSeatNumbers.contains(seat.getSeatNumber())) {
                    System.out.println("Seat " + seat.getSeatNumber() + " is already booked for this show.");
                    return null;
                }
            }

            double total = 0;
            List<String> labels = new ArrayList<>();
            for (Seat seat : seats) {
                bookedSeatNumbers.add(seat.getSeatNumber());
                total += seat.getPrice();
                labels.add(seat.getSeatNumber());
            }

            Booking booking = new Booking(customer, this, seats, total);
            System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n",
                    customer.getName(), String.join(", ", labels), total);
            return booking;
        }

        public synchronized void cancelBooking(Booking booking) {
            if (booking == null || !booking.isActive()) {
                System.out.println("Invalid booking.");
                return;
            }
            if (showStarted) {
                System.out.println("Cannot cancel booking after the show has started.");
                return;
            }

            List<String> releasedSeats = new ArrayList<>();
            for (Seat seat : booking.getSeats()) {
                bookedSeatNumbers.remove(seat.getSeatNumber());
                releasedSeats.add(seat.getSeatNumber());
            }
            booking.setActive(false);

            System.out.printf("%s's booking cancelled. Seats %s released.%n",
                    booking.getCustomer().getName(), String.join(", ", releasedSeats));
        }
    }

    public static class Booking {
        private final Customer customer;
        private final Show show;
        private final List<Seat> seats;
        private final double totalAmount;
        private boolean active;

        public Booking(Customer customer, Show show, List<Seat> seats, double totalAmount) {
            this.customer = customer;
            this.show = show;
            this.seats = new ArrayList<>(seats);
            this.totalAmount = totalAmount;
            this.active = true;
        }

        public Customer getCustomer() {
            return customer;
        }

        public Show getShow() {
            return show;
        }

        public List<Seat> getSeats() {
            return Collections.unmodifiableList(seats);
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public boolean isActive() {
            return active;
        }

        protected void setActive(boolean active) {
            this.active = active;
        }
    }

    public static void main(String[] args) {
        Show show7PM = new Show("Evening Premiere", "7 PM");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        List<Seat> ashaSeats = List.of(a1, a2, f5);
        Booking ashaBooking = show7PM.bookSeats(asha, ashaSeats);

        show7PM.bookSeats(ravi, List.of(a2));

        Booking raviBooking = show7PM.bookSeats(ravi, List.of(r1));

        show7PM.cancelBooking(ashaBooking);

        show7PM.bookSeats(neha, List.of(a2));
    }
}
