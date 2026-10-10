import java.util.*;

class Student {
    private String rollNumber;
    private String name;

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rollNumber, student.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        boolean reportedCount = false;

        while (sc.hasNext()) {
            String op = sc.next();
            if (op.equalsIgnoreCase("ADD")) {
                String roll = sc.next();
                String name = sc.next();
                Student s = new Student(roll, name);
                if (members.add(s)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }
            } else if (op.equalsIgnoreCase("CONTAINS")) {
                if (!reportedCount) {
                    System.out.println("member count " + members.size());
                    reportedCount = true;
                }
                String roll = sc.next();
                String name = sc.next();
                Student s = new Student(roll, name);
                System.out.println("contains: " + members.contains(s));
            }
        }
        if (!reportedCount) {
            System.out.println("member count " + members.size());
        }
        sc.close();
    }
}
