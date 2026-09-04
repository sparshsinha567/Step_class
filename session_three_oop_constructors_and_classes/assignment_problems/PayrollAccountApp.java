import java.util.Scanner;

public class PayrollAccountApp {

    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: Negative basic salary given. Initialized to 0.0");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus credit rejected: Amount must be positive.");
                return;
            }
            this.bonus += amount;
            System.out.printf("Bonus credited: Rs %.1f\n", amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: Percentage must be between 0 and 100.");
                return;
            }
            double taxAmount = (this.basicSalary * percent) / 100.0;
            this.basicSalary -= taxAmount;
            System.out.printf("Tax deducted: %.0f%%\n", percent);
        }

        public double getNetSalary() {
            return this.basicSalary + this.bonus;
        }

        public double getBasicSalary() {
            return this.basicSalary;
        }

        public double getBonus() {
            return this.bonus;
        }
    }

    public static void runPayrollDemonstration() {
        PayrollAccount account = new PayrollAccount(50000.0);
        account.creditBonus(5000.0);
        account.deductTax(10.0);
        System.out.printf("Net salary: Rs %.1f\n", account.getNetSalary());
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Encapsulated Payroll Account - Salary & Bonus Tracker   ");
        System.out.println("=============================================================");

        runPayrollDemonstration();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Payroll Session ---");
        System.out.print("Enter basic salary: ");
        if (scanner.hasNextDouble()) {
            double salary = scanner.nextDouble();
            PayrollAccount userAccount = new PayrollAccount(salary);
            System.out.print("Enter bonus to credit: ");
            double bonusAmt = scanner.nextDouble();
            userAccount.creditBonus(bonusAmt);
            System.out.print("Enter tax percentage to deduct: ");
            double taxPct = scanner.nextDouble();
            userAccount.deductTax(taxPct);
            System.out.printf("Final Net Salary: Rs %.1f\n", userAccount.getNetSalary());
        }
        scanner.close();
    }
}
