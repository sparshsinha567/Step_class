public class MembershipHierarchyClassifier {

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
            return "General Member | Books Borrowed: " + this.booksBorrowed;
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
            return "Student Member | Course: " + this.course + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    public static class HonorsStudentMember extends StudentMember {
        private final int bonusLimit;

        public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }

        public int getBonusLimit() {
            return this.bonusLimit;
        }

        @Override
        public String displayInfo() {
            return "Honors Student Member | Course: " + this.getCourse() + " | Bonus Limit: " + this.bonusLimit + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    public static class FacultyMember extends LibraryMember {
        private final String department;

        public FacultyMember(String memberId, int borrowLimit, String department) {
            super(memberId, borrowLimit);
            this.department = (department != null) ? department.trim() : "General";
        }

        public String getDepartment() {
            return this.department;
        }

        @Override
        public String displayInfo() {
            return "Faculty Member | Department: " + this.department + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Direct subclass (2 generations deep)";
        } else if (member != null) {
            return "Base class (root generation)";
        }
        return "Unknown";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        if (members == null) {
            return 0;
        }

        int total = 0;
        for (LibraryMember m : members) {
            if (m != null) {
                total += m.getBooksBorrowed();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new LibraryMember("STU1", 3).displayInfo());
        System.out.println(new StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new FacultyMember("STU4", 5, "Physics").displayInfo());

        HonorsStudentMember honorsMember = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember facultyMember = new FacultyMember("STU4", 5, "Physics");
        StudentMember studentMember = new StudentMember("STU2", 3, "CSE");

        System.out.println(classifyGeneration(honorsMember));
        System.out.println(classifyGeneration(facultyMember));

        studentMember.borrowBook();
        studentMember.borrowBook();

        honorsMember.borrowBook();

        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();

        LibraryMember[] list = {studentMember, honorsMember, facultyMember};
        System.out.println(getTotalBooksBorrowed(list));
    }
}
