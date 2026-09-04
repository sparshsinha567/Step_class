public class CompanyEmployeeTracker {

    public static class Employee {
        private String empName;
        private double salary;

        public static final String companyName = "Bright Horizon Technologies";
        public static int employeeCount = 0;

        public Employee(String empName, double salary) {
            if (empName == null) {
                throw new NullPointerException("Employee name cannot be null.");
            }
            this.empName = empName.trim();
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }

        public String getEmpName() {
            return this.empName;
        }

        public double getSalary() {
            return this.salary;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("    Company Workforce Registry - Instance vs Static Members  ");
        System.out.println("=============================================================");

        Employee emp1 = new Employee("Neha Sharma", 55000.0);
        Employee emp2 = new Employee("Vikram Malhotra", 72000.0);
        Employee emp3 = new Employee("Ankit Verma", 48000.0);

        if (emp1 instanceof Employee && emp2 instanceof Employee && emp3 instanceof Employee) {
            System.out.println("3 Employee objects created");
        }

        Employee.printCompanyInfo();
    }
}
