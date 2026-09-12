public class LibraryBatchEnrollment {

    public static class LibraryMember {
        private final String memberId;
        private final int borrowLimit;
        private int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("construction rejected");
            }
            if (borrowLimit <= 0) {
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

        public String getMemberId() {
            return this.memberId;
        }

        public int getBorrowLimit() {
            return this.borrowLimit;
        }
    }

    public static class StudentMember extends LibraryMember {
        private final String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            if (course == null || course.trim().isEmpty()) {
                throw new IllegalArgumentException("construction rejected");
            }
            this.course = course.trim();
        }

        public String getCourse() {
            return this.course;
        }
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        if (memberIds == null || memberIds.length == 0) {
            return "Enrolled: 0 | Rejected: 0";
        }

        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] batch = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(batch, 3));
    }
}
