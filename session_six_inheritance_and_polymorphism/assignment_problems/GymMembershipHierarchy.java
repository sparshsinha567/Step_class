public class GymMembershipHierarchy {

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
            return "Standard Member | Sessions: " + this.sessionsAttended;
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
            return "Premium Member | Trainer: " + this.trainerName + " | Sessions: " + this.sessionsAttended;
        }
    }

    public static class EliteMember extends PremiumMember {
        private final String lockerNumber;

        public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
            super(memberId, monthlyFee, trainerName);
            this.lockerNumber = (lockerNumber != null) ? lockerNumber.trim() : "None";
        }

        public String getLockerNumber() {
            return this.lockerNumber;
        }

        @Override
        public String displayInfo() {
            return "Elite Member | Trainer: " + this.getTrainerName() + " | Locker: " + this.lockerNumber + " | Sessions: " + this.sessionsAttended;
        }
    }

    public static class GroupClassMember extends GymMember {
        private final String className;

        public GroupClassMember(String memberId, int monthlyFee, String className) {
            super(memberId, monthlyFee);
            this.className = (className != null) ? className.trim() : "General";
        }

        public String getClassName() {
            return this.className;
        }

        @Override
        public String displayInfo() {
            return "Group Class Member | Class: " + this.className + " | Sessions: " + this.sessionsAttended;
        }
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Direct subclass (2 generations deep)";
        } else if (member != null) {
            return "Base class (root generation)";
        }
        return "Unknown";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        if (members == null) {
            return 0;
        }

        int total = 0;
        for (GymMember m : members) {
            if (m != null) {
                total += m.getSessionsAttended();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(new PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new GroupClassMember("MEM4", 1500, "Zumba").displayInfo());

        EliteMember eliteMember = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember = new GroupClassMember("MEM4", 1500, "Zumba");
        PremiumMember premiumMember = new PremiumMember("MEM2", 2000, "Coach Riya");

        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));

        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        GymMember[] list = {premiumMember, eliteMember, groupClassMember};
        System.out.println(getTotalSessionsAttended(list));
    }
}
