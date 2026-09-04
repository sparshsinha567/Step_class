public class ParkingFineCalculator {

    public static class ParkingTicket {
        private final String vehicleNo;
        private final double ratePerMinute;

        public ParkingTicket(String vehicleNo, double ratePerMinute) {
            if (vehicleNo == null) {
                throw new NullPointerException("Vehicle number cannot be null.");
            }
            if (ratePerMinute < 0) {
                throw new IllegalArgumentException("Rate per minute cannot be negative.");
            }
            this.vehicleNo = vehicleNo.trim();
            this.ratePerMinute = ratePerMinute;
        }

        public final double calculateFine(int overstayMinutes) {
            return overstayMinutes * this.ratePerMinute;
        }

        public final void printReceipt(int overstayMinutes) {
            double fine = calculateFine(overstayMinutes);
            System.out.printf("%s - Fine: Rs %.1f\n", this.vehicleNo, fine);
        }

        public String getVehicleNo() {
            return this.vehicleNo;
        }

        public double getRatePerMinute() {
            return this.ratePerMinute;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Campus Parking - Overstay Fine Receipt Calculator       ");
        System.out.println("=============================================================");

        String[] vehicleNos = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] ratePerMinute = {2.0, 2.0, 3.0, 2.0};
        int[] overstayMinutes = {15, 0, -5, 8};

        for (int i = 0; i < vehicleNos.length; i++) {
            ParkingTicket ticket = new ParkingTicket(vehicleNos[i], ratePerMinute[i]);

            if (overstayMinutes[i] > 0) {
                ticket.printReceipt(overstayMinutes[i]);
            } else {
                System.out.println(vehicleNos[i] + " - No fine, within allotted time");
            }
        }
    }
}
