import java.util.Arrays;

public class NightlySettlementLedger {

    public static class BookingReceipt {
        private final String bookingId;
        private final String[] seatNumbers;

        public BookingReceipt(String bookingId, String[] seatNumbers) {
            this.bookingId = bookingId;
            if (seatNumbers != null) {
                this.seatNumbers = seatNumbers.clone();
            } else {
                this.seatNumbers = new String[0];
            }
        }

        public String getBookingId() {
            return this.bookingId;
        }

        public String[] getSeatNumbers() {
            return this.seatNumbers.clone();
        }

        public BookingReceipt withUpdatedSeat(int index, String newSeat) {
            String[] updatedSeats = this.seatNumbers.clone();
            if (index >= 0 && index < updatedSeats.length) {
                updatedSeats[index] = newSeat;
            }
            return new BookingReceipt(this.bookingId, updatedSeats);
        }
    }

    public static class GroupBookingReceipt extends BookingReceipt {
        private final int groupSize;

        public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
            super(bookingId, seatNumbers);
            this.groupSize = groupSize;
        }

        public int getGroupSize() {
            return this.groupSize;
        }
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        if (receipts == null || receipts.length == 0) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof GroupBookingReceipt) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}
