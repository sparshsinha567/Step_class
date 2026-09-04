import java.util.Scanner;

public class CourseManager {

    public static class Course {
        private final String code;
        private final String title;
        private final int credits;
        private final int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            if (code == null || title == null) {
                throw new NullPointerException("Course code and title cannot be null.");
            }
            this.code = code.trim();
            this.title = title.trim();
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return this.credits + this.labCredits;
        }

        public String getCode() {
            return this.code;
        }

        public String getTitle() {
            return this.title;
        }

        public int getCredits() {
            return this.credits;
        }

        public int getLabCredits() {
            return this.labCredits;
        }

        public void printCourseDetails() {
            System.out.printf("%s total credits: %d\n", this.code, this.totalCredits());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Course Curriculum Manager - Constructor Overloading & Chaining ");
        System.out.println("=============================================================");

        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course integratedCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        if (theoryCourse instanceof Course) {
            theoryCourse.printCourseDetails();
        }

        if (integratedCourse instanceof Course) {
            integratedCourse.printCourseDetails();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Course Registration ---");
        System.out.print("Enter Course Code: ");
        if (scanner.hasNextLine()) {
            String code = scanner.nextLine();
            System.out.print("Enter Course Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Lecture Credits: ");
            int credits = scanner.nextInt();
            System.out.print("Has Lab? (true/false): ");
            boolean hasLab = scanner.nextBoolean();

            Course customCourse;
            if (hasLab) {
                System.out.print("Enter Lab Credits: ");
                int labCredits = scanner.nextInt();
                customCourse = new Course(code, title, credits, labCredits);
            } else {
                customCourse = new Course(code, title, credits);
            }

            customCourse.printCourseDetails();
        }
        scanner.close();
    }
}
