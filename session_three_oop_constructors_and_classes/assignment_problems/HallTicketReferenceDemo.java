public class HallTicketReferenceDemo {

    public static class HallTicket {
        private final String studentName;
        public int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            if (studentName == null) {
                throw new NullPointerException("Student name cannot be null.");
            }
            this.studentName = studentName.trim();
            this.seatNumber = seatNumber;
        }

        public String getStudentName() {
            return this.studentName;
        }

        public int getSeatNumber() {
            return this.seatNumber;
        }
    }

    public static void runIdentityTest() {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable): " + priya.getSeatNumber());
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Exam Hall Ticket System - Reference Copying & Equality    ");
        System.out.println("=============================================================");

        runIdentityTest();
    }
}
