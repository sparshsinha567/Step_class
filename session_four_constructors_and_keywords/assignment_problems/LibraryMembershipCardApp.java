public class LibraryMembershipCardApp {

    public static class MembershipCard {
        public static String libraryName;
        public static String validUntil;

        private final String studentName;

        static {
            libraryName = "SRM Central Library";
            validUntil = "May 2027";
            System.out.println("Library info loaded");
        }

        public MembershipCard(String studentName) {
            if (studentName == null) {
                throw new NullPointerException("Student name cannot be null.");
            }
            this.studentName = studentName.trim();
        }

        public String getStudentName() {
            return this.studentName;
        }

        public void printCardDetails() {
            System.out.println("Membership card issued: " + this.studentName);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (int i = 0; i < names.length; i++) {
            MembershipCard card = new MembershipCard(names[i]);
            card.printCardDetails();
        }
    }
}
