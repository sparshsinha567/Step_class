import java.util.Arrays;

public class StudentFineLedger {

    public static class LibraryMember {
        private final String memberId;
        private final int borrowLimit;
        private final int[] fineHistory;
        private int fineCount;
        private int totalFine;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("construction rejected");
            }
            this.memberId = memberId.trim();
            this.borrowLimit = borrowLimit;
            this.fineHistory = new int[10];
            this.fineCount = 0;
            this.totalFine = 0;
        }

        protected void chargeFine(int amount) {
            if (amount > 0 && this.fineCount < this.fineHistory.length) {
                this.fineHistory[this.fineCount++] = amount;
                this.totalFine += amount;
            }
        }

        public int[] getFineHistory() {
            return Arrays.copyOf(this.fineHistory, this.fineCount);
        }

        public int getTotalFine() {
            return this.totalFine;
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
            this.course = (course != null) ? course.trim() : "General";
        }

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }

        public String getCourse() {
            return this.course;
        }
    }

    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}
