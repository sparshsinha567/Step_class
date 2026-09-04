public class LateFeeBatchProcessor {

    public static class FeeAccount {
        private final String regNo;
        private final double totalFee;

        public FeeAccount(String regNo, double totalFee) {
            if (regNo == null) {
                throw new NullPointerException("Registration number cannot be null.");
            }
            if (totalFee < 0) {
                throw new IllegalArgumentException("Total fee cannot be negative.");
            }
            this.regNo = regNo.trim();
            this.totalFee = totalFee;
        }

        public final double calculateLateFee(int daysLate) {
            return (this.totalFee * 0.01) * daysLate;
        }

        public final void printSummary(int daysLate) {
            double lateFee = calculateLateFee(daysLate);
            System.out.printf("%s | Total Fee: Rs %.1f | Late Fee: Rs %.1f\n", this.regNo, this.totalFee, lateFee);
        }

        public String getRegNo() {
            return this.regNo;
        }

        public double getTotalFee() {
            return this.totalFee;
        }
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000.0, 150000.0, 180000.0, 220000.0};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            FeeAccount account = new FeeAccount(regNos[i], totalFees[i]);

            if (daysLate[i] > 0) {
                account.printSummary(daysLate[i]);
            } else {
                System.out.println(regNos[i] + " - On time, no late fee");
            }
        }
    }
}
