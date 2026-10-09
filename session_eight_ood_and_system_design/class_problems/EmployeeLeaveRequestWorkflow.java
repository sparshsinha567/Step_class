import java.util.Objects;

public class EmployeeLeaveRequestWorkflow {

    public enum LeaveStatus {
        PENDING, APPROVED, REJECTED
    }

    public abstract static class Employee {
        private final String name;
        private final String role;

        public Employee(String name, String role) {
            this.name = Objects.requireNonNull(name, "Name cannot be null").trim();
            this.role = Objects.requireNonNull(role, "Role cannot be null").trim();
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public abstract int getMaxConsecutiveLeaveDays();
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name) {
            super(name, "Full-Time");
        }

        @Override
        public int getMaxConsecutiveLeaveDays() {
            return 30;
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name) {
            super(name, "Part-Time");
        }

        @Override
        public int getMaxConsecutiveLeaveDays() {
            return 10;
        }
    }

    public static class Contractor extends Employee {
        public Contractor(String name) {
            super(name, "Contractor");
        }

        @Override
        public int getMaxConsecutiveLeaveDays() {
            return 5;
        }
    }

    public static class Manager {
        private final String name;

        public Manager(String name) {
            this.name = Objects.requireNonNull(name, "Manager name cannot be null").trim();
        }

        public String getName() {
            return name;
        }

        public void review(LeaveRequest request, boolean approve) {
            if (request == null) {
                return;
            }
            if (approve) {
                request.approve(this);
            } else {
                request.reject(this);
            }
        }
    }

    public static class LeaveRequest {
        private final Employee employee;
        private final String dates;
        private final int days;
        private LeaveStatus status;

        public LeaveRequest(Employee employee, String dates, int days) {
            this.employee = Objects.requireNonNull(employee, "Employee cannot be null");
            this.dates = Objects.requireNonNull(dates, "Dates cannot be null").trim();
            if (days <= 0) {
                throw new IllegalArgumentException("Leave days must be positive");
            }
            this.days = days;
            this.status = LeaveStatus.PENDING;
            System.out.printf("Leave request submitted for %s (%s). Status: Pending.%n",
                    employee.getName(), dates);
        }

        public Employee getEmployee() {
            return employee;
        }

        public String getDates() {
            return dates;
        }

        public int getDays() {
            return days;
        }

        public LeaveStatus getStatus() {
            return status;
        }

        public boolean approve(Manager manager) {
            if (this.status != LeaveStatus.PENDING) {
                System.out.println("Cannot review a request that is already " + this.status + ".");
                return false;
            }
            this.status = LeaveStatus.APPROVED;
            System.out.printf("%s's leave request (%s) approved. Status: Approved.%n",
                    employee.getName(), dates);
            return true;
        }

        public boolean reject(Manager manager) {
            if (this.status != LeaveStatus.PENDING) {
                System.out.println("Cannot review a request that is already " + this.status + ".");
                return false;
            }
            this.status = LeaveStatus.REJECTED;
            System.out.printf("%s's leave request (%s) rejected. Status: Rejected.%n",
                    employee.getName(), dates);
            return true;
        }

        public void setStatus(LeaveStatus newStatus) {
            if (this.status != LeaveStatus.PENDING && newStatus == LeaveStatus.PENDING) {
                String capitalized = this.status.name().charAt(0) + this.status.name().substring(1).toLowerCase();
                System.out.printf("Cannot change leave request status from %s to Pending.%n", capitalized);
                return;
            }
            this.status = newStatus;
        }
    }

    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Manager alice = new Manager("Alice");
        LeaveRequest req1 = new LeaveRequest(john, "Jan 1-5", 5);
        alice.review(req1, true);

        Employee jane = new PartTimeEmployee("Jane");
        Manager bob = new Manager("Bob");
        LeaveRequest req2 = new LeaveRequest(jane, "Feb 10-11", 2);
        bob.review(req2, false);

        req1.setStatus(LeaveStatus.PENDING);
    }
}
