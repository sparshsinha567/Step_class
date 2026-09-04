public class SrmStudentBatchSetup {

    public static class SrmStudent {
        public static String collegeName;
        public static String academicYear;

        private final String studentName;

        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2024-2025";
            System.out.println("College info loaded");
        }

        public SrmStudent(String studentName) {
            if (studentName == null) {
                throw new NullPointerException("Student name cannot be null.");
            }
            this.studentName = studentName.trim();
        }

        public String getStudentName() {
            return this.studentName;
        }

        public void printConfirmation() {
            System.out.println("Student record created: " + this.studentName);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (int i = 0; i < names.length; i++) {
            SrmStudent student = new SrmStudent(names[i]);
            student.printConfirmation();
        }
    }
}
