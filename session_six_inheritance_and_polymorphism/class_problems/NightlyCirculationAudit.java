public class NightlyCirculationAudit {

    public static class LibraryMember {
        private static int memberCount = 100;

        public final String memberNumber;
        private final int borrowLimit;
        private int booksBorrowed;
        private String lastGenre;

        public LibraryMember(int borrowLimit) {
            memberCount++;
            this.memberNumber = "LIB-" + memberCount;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
            this.lastGenre = "None";
        }

        public void borrowBook() {
            if (this.booksBorrowed < this.borrowLimit) {
                this.booksBorrowed++;
            }
        }

        public void borrowBook(String genre) {
            this.lastGenre = (genre != null) ? genre.trim() : "None";
            borrowBook();
        }

        public int getBooksBorrowed() {
            return this.booksBorrowed;
        }

        public String getLastGenre() {
            return this.lastGenre;
        }

        public static int getMembersEnrolled() {
            return memberCount - 100;
        }
    }

    public static class FacultyMember extends LibraryMember {
        private final String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = (department != null) ? department.trim() : "General";
        }

        public String getDepartment() {
            return this.department;
        }
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'R') {
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

    public static String processNightlyAudit(LibraryMember[] members) {
        if (members == null || members.length == 0) {
            return "0 processed | 0 null skipped | 0 faculty | 0 regular";
        }

        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + facultyCount + " faculty | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(processNightlyAudit(batch));
    }
}
