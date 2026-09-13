public class MonthlyAttendanceAnnouncer {

    public static class GymMember {
        private final String memberId;
        private final int monthlyFee;
        protected int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("construction rejected");
            }
            this.memberId = memberId.trim();
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            this.sessionsAttended++;
        }

        public int getSessionsAttended() {
            return this.sessionsAttended;
        }

        public String displayInfo() {
            return "Standard | Sessions: " + this.sessionsAttended;
        }
    }

    public static class PremiumMember extends GymMember {
        private final String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = (trainerName != null) ? trainerName.trim() : "General";
        }

        public String getTrainerName() {
            return this.trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium | Trainer: " + this.trainerName + " | Sessions: " + this.sessionsAttended;
        }
    }

    public static String batchPrint(GymMember[] members) {
        if (members == null || members.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (GymMember m : members) {
            if (m != null) {
                sb.append(m.displayInfo());
                if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                }
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GymMember[] list = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(list));

        try {
            GymMember plain = new GymMember("MEM8", 1000);
            PremiumMember bad = (PremiumMember) plain;
            System.out.println(bad.getTrainerName());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
