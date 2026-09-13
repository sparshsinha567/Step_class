public class GymWeeklyCheckInAudit {

    public static class GymMember {
        private static int memberCount = 2000;

        public final String membershipNumber;
        private final int monthlyFee;
        private int feesPaid;
        private String lastPaymentMode;

        public GymMember(int monthlyFee) {
            memberCount++;
            this.membershipNumber = "GYM-" + memberCount;
            this.monthlyFee = monthlyFee;
            this.feesPaid = 0;
            this.lastPaymentMode = "Cash";
        }

        public void payFee(int amount) {
            if (amount > 0) {
                this.feesPaid += amount;
            }
        }

        public void payFee(int amount, String mode) {
            this.lastPaymentMode = (mode != null) ? mode.trim() : "Cash";
            payFee(amount);
        }

        public int getFeesPaid() {
            return this.feesPaid;
        }

        public String getLastPaymentMode() {
            return this.lastPaymentMode;
        }

        public int getMonthlyFee() {
            return this.monthlyFee;
        }

        public static int getMembersEnrolled() {
            return memberCount - 2000;
        }
    }

    public static class GroupClassMember extends GymMember {
        private final String className;

        public GroupClassMember(int monthlyFee, String className) {
            super(monthlyFee);
            this.className = (className != null) ? className.trim() : "General";
        }

        public String getClassName() {
            return this.className;
        }
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        if (members == null || members.length == 0) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(isValidReferralCode("G45B"));
        System.out.println(isValidReferralCode("G4B"));
        System.out.println(isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        GymMember[] batch = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };
        System.out.println(processWeeklyCheckIn(batch));
    }
}
