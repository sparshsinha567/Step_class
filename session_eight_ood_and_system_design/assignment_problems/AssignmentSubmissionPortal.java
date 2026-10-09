import java.util.Objects;

// Implement: The Assignment Submission Portal
public class AssignmentSubmissionPortal {

    public enum SubmissionStatus {
        SUBMITTED, GRADED
    }

    public abstract static class Assignment {
        private final String title;
        private final int maxMarks;
        private final int dueDay; // e.g. day of month for simplicity or day index

        public Assignment(String title, int maxMarks, int dueDay) {
            this.title = Objects.requireNonNull(title).trim();
            this.maxMarks = maxMarks;
            this.dueDay = dueDay;
        }

        public String getTitle() {
            return title;
        }

        public int getMaxMarks() {
            return maxMarks;
        }

        public int getDueDay() {
            return dueDay;
        }

        public abstract double getDailyPenaltyRate();

        public double calculateFinalMarks(double rawMarks, int lateDays) {
            if (lateDays <= 0) {
                return rawMarks;
            }
            double penaltyPercent = getDailyPenaltyRate() * lateDays;
            if (penaltyPercent > 1.0) {
                penaltyPercent = 1.0;
            }
            double penalty = rawMarks * penaltyPercent;
            return Math.max(0, rawMarks - penalty);
        }
    }

    public static class CodingAssignment extends Assignment {
        public CodingAssignment(String title, int maxMarks, int dueDay) {
            super(title, maxMarks, dueDay);
        }

        @Override
        public double getDailyPenaltyRate() {
            return 0.10; // 10% per day late
        }
    }

    public static class WrittenAssignment extends Assignment {
        public WrittenAssignment(String title, int maxMarks, int dueDay) {
            super(title, maxMarks, dueDay);
        }

        @Override
        public double getDailyPenaltyRate() {
            return 0.20; // 20% per day late
        }
    }

    public static class Student {
        private final String name;

        public Student(String name) {
            this.name = Objects.requireNonNull(name).trim();
        }

        public String getName() {
            return name;
        }
    }

    public static class Submission {
        private final Student student;
        private final Assignment assignment;
        private final int submissionDay;
        private final int lateDays;
        private SubmissionStatus status;
        private double finalMarks;

        public Submission(Student student, Assignment assignment, int submissionDay) {
            this.student = Objects.requireNonNull(student);
            this.assignment = Objects.requireNonNull(assignment);
            this.submissionDay = submissionDay;
            this.lateDays = Math.max(0, submissionDay - assignment.getDueDay());
            this.status = SubmissionStatus.SUBMITTED;

            String lateInfo = (lateDays == 0) ? "(on time)" : String.format("(%d days late)", lateDays);
            System.out.printf("%s's submission for '%s' received %s. Status: Submitted.%n",
                    student.getName(), assignment.getTitle(), lateInfo);
        }

        public Student getStudent() {
            return student;
        }

        public Assignment getAssignment() {
            return assignment;
        }

        public SubmissionStatus getStatus() {
            return status;
        }

        public double getFinalMarks() {
            return finalMarks;
        }

        public void grade(double awardedMarks) {
            if (status == SubmissionStatus.GRADED) {
                System.out.println("Submission has already been graded.");
                return;
            }
            this.status = SubmissionStatus.GRADED;
            this.finalMarks = assignment.calculateFinalMarks(awardedMarks, lateDays);

            int penaltyPercent = (int) Math.round(lateDays * assignment.getDailyPenaltyRate() * 100);
            if (penaltyPercent > 0) {
                System.out.printf("%s graded: %d/%d after %d%% late penalty. Status: Graded.%n",
                        student.getName(), (int) finalMarks, assignment.getMaxMarks(), penaltyPercent);
            } else {
                System.out.printf("%s graded: %d/%d. Status: Graded.%n",
                        student.getName(), (int) finalMarks, assignment.getMaxMarks());
            }
        }

        public boolean canResubmit() {
            return status != SubmissionStatus.GRADED;
        }
    }

    public static class PortalService {
        public Submission submitAssignment(Student student, Assignment assignment, int submitDay, Submission existing) {
            if (existing != null && !existing.canResubmit()) {
                System.out.printf("Cannot resubmit: '%s' has already been graded.%n", assignment.getTitle());
                return existing;
            }
            return new Submission(student, assignment, submitDay);
        }
    }

    public static void main(String[] args) {
        PortalService portal = new PortalService();

        Assignment codingLab = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment writtenEssay = new WrittenAssignment("Design Essay", 50, 12);

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission ashaSub = portal.submitAssignment(asha, codingLab, 10, null);
        Submission raviSub = portal.submitAssignment(ravi, writtenEssay, 14, null);

        ashaSub.grade(45);
        raviSub.grade(40);

        portal.submitAssignment(asha, codingLab, 15, ashaSub);
    }
}
