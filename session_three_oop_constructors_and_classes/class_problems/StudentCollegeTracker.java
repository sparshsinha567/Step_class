public class StudentCollegeTracker {

    public static class Student {
        private String name;
        private double attendance;

        public static final String collegeName = "SRM Institute of Science and Technology";
        public static int studentCount = 0;

        public Student(String name, double attendance) {
            if (name == null) {
                throw new NullPointerException("Student name cannot be null.");
            }
            this.name = name.trim();
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }

        public String getName() {
            return this.name;
        }

        public double getAttendance() {
            return this.attendance;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("      Student Registry - Instance vs Static Splitting        ");
        System.out.println("=============================================================");

        Student student1 = new Student("Aarav Sharma", 88.5);
        Student student2 = new Student("Pooja Patel", 92.0);

        if (student1 instanceof Student && student2 instanceof Student) {
            System.out.println("2 Student objects created");
        }

        Student.printCollegeInfo();
    }
}
