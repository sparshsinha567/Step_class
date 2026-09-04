public class PayrollBatchBonus {

    public static class Employee {
        private String empId;
        private double salary;

        public Employee(String empId, double salary) {
            if (empId == null) {
                throw new NullPointerException("Employee ID cannot be null.");
            }
            if (salary < 0) {
                throw new IllegalArgumentException("Salary cannot be negative.");
            }
            this.empId = empId;
            this.salary = salary;
        }

        public void raiseSalary(double salary) {
            if (salary > 0) {
                this.salary += salary;
            }
        }

        public String getEmpId() {
            return this.empId;
        }

        public double getSalary() {
            return this.salary;
        }

        public void printSalaryStatus() {
            System.out.printf("%s | Final Salary: Rs %.1f\n", this.empId, this.salary);
        }
    }

    public static void main(String[] args) {
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        double[] startingSalaries = {40000.0, 55000.0, 62000.0, 48000.0};

        Employee[] employees = new Employee[empIds.length];

        for (int i = 0; i < empIds.length; i++) {
            employees[i] = new Employee(empIds[i], startingSalaries[i]);
            employees[i].raiseSalary(5000.0);
            employees[i].printSalaryStatus();
        }
    }
}
