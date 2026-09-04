import java.util.Scanner;

public class EmployeeProfileManager {

    public static class Employee {
        private final String empId;
        private final String empName;
        private final double salary;
        private boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            if (empId == null || empName == null) {
                throw new NullPointerException("Employee ID and name cannot be null.");
            }
            this.empId = empId.trim();
            this.empName = empName.trim();
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.printf("%s | %s | Rs %.1f | Intern: %b\n",
                    this.empId, this.empName, this.salary, this.isIntern);
        }

        public String getEmpId() {
            return this.empId;
        }

        public String getEmpName() {
            return this.empName;
        }

        public double getSalary() {
            return this.salary;
        }

        public boolean isIntern() {
            return this.isIntern;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Employee Onboarding - Constructor Overloading & Chaining  ");
        System.out.println("=============================================================");

        Employee permanentEmp = new Employee("E-101", "Divya", 65000.0);
        Employee internEmp = new Employee("E-102", "Arjun");

        if (permanentEmp instanceof Employee) {
            permanentEmp.printProfile();
        }

        if (internEmp instanceof Employee) {
            internEmp.printProfile();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Employee Registration ---");
        System.out.print("Enter Employee ID: ");
        if (scanner.hasNextLine()) {
            String id = scanner.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Is Intern? (true/false): ");
            boolean intern = scanner.nextBoolean();

            Employee newEmp;
            if (intern) {
                newEmp = new Employee(id, name);
            } else {
                System.out.print("Enter Salary: ");
                double sal = scanner.nextDouble();
                newEmp = new Employee(id, name, sal);
            }

            System.out.print("Created Profile: ");
            newEmp.printProfile();
        }
        scanner.close();
    }
}
