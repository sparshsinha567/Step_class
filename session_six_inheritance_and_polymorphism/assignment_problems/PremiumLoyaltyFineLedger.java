import java.util.Arrays;

public class PremiumLoyaltyFineLedger {

    public static class GymMember {
        private final String memberId;
        private final int monthlyFee;
        private final int[] lateFeeHistory;
        private int lateFeeCount;
        private int totalLateFees;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("construction rejected");
            }
            this.memberId = memberId.trim();
            this.monthlyFee = monthlyFee;
            this.lateFeeHistory = new int[10];
            this.lateFeeCount = 0;
            this.totalLateFees = 0;
        }

        protected void chargeLateFee(int amount) {
            if (amount > 0 && this.lateFeeCount < this.lateFeeHistory.length) {
                this.lateFeeHistory[this.lateFeeCount++] = amount;
                this.totalLateFees += amount;
            }
        }

        public int[] getLateFeeHistory() {
            return Arrays.copyOf(this.lateFeeHistory, this.lateFeeCount);
        }

        public int getTotalLateFees() {
            return this.totalLateFees;
        }

        public String getMemberId() {
            return this.memberId;
        }

        public int getMonthlyFee() {
            return this.monthlyFee;
        }
    }

    public static class PremiumMember extends GymMember {
        private final String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = (trainerName != null) ? trainerName.trim() : "General";
        }

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }

        public String getTrainerName() {
            return this.trainerName;
        }
    }

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}
