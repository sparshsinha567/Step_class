public class WeeklyCirculationReport {

    public static class LibraryMember {
        private final String memberId;
        private final int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("construction rejected");
            }
            this.memberId = memberId.trim();
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public void borrowBook() {
            if (this.booksBorrowed < this.borrowLimit) {
                this.booksBorrowed++;
            }
        }

        public int getBooksBorrowed() {
            return this.booksBorrowed;
        }

        public String displayInfo() {
            return "General | Books: " + this.booksBorrowed;
        }
    }

    public static class StudentMember extends LibraryMember {
        private final String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = (course != null) ? course.trim() : "General";
        }

        public String getCourse() {
            return this.course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + this.course + " | Books: " + this.booksBorrowed;
        }
    }

    public static String batchPrint(LibraryMember[] members) {
        if (members == null || members.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (LibraryMember m : members) {
            if (m != null) {
                sb.append(m.displayInfo());
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m;
                    sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                }
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] list = {
            new LibraryMember("LB500", 3),
            new StudentMember("STU60", 3, "ECE")
        };
        System.out.println(batchPrint(list));

        try {
            LibraryMember plain = new LibraryMember("LB600", 3);
            StudentMember bad = (StudentMember) plain;
            System.out.println(bad.getCourse());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
