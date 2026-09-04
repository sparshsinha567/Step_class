import java.util.Scanner;

public class MessWalletApp {

    public static class MessWallet {
        private double balance;

        public MessWallet(double initialBalance) {
            if (initialBalance < 0) {
                System.out.println("Warning: Negative opening balance given. Initialized to 0.0");
                this.balance = 0.0;
            } else {
                this.balance = initialBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: Amount must be greater than 0.");
                return;
            }
            this.balance += amount;
            System.out.printf("Balance after top-up: %.1f\n", this.balance);
        }

        public void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduct rejected: Amount must be greater than 0.");
                return;
            }
            if (amount > this.balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            this.balance -= amount;
            System.out.printf("Deduct successful: %.1f deducted. Current balance: %.1f\n", amount, this.balance);
        }

        public double getBalance() {
            return this.balance;
        }
    }

    public static void runWalletDemonstration() {
        System.out.println("--- Scenario 1: Standard Mess Wallet Flow ---");
        MessWallet wallet = new MessWallet(500.0);
        wallet.topUp(200.0);
        wallet.deduct(1000.0);
        System.out.printf("Final balance: %.1f\n", wallet.getBalance());

        System.out.println("\n--- Scenario 2: Negative Opening Balance Guard ---");
        MessWallet invalidWallet = new MessWallet(-150.0);
        System.out.printf("Current balance: %.1f\n", invalidWallet.getBalance());
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("      Hostel Mess-Card Wallet - Encapsulation & Guard        ");
        System.out.println("=============================================================");

        runWalletDemonstration();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Mess Wallet Session ---");
        System.out.print("Enter opening balance: ");
        if (scanner.hasNextDouble()) {
            double opening = scanner.nextDouble();
            MessWallet userWallet = new MessWallet(opening);
            System.out.print("Enter top-up amount: ");
            double topUpAmt = scanner.nextDouble();
            userWallet.topUp(topUpAmt);
            System.out.print("Enter deduction amount: ");
            double deductAmt = scanner.nextDouble();
            userWallet.deduct(deductAmt);
            System.out.printf("Final Balance: %.1f\n", userWallet.getBalance());
        }
        scanner.close();
    }
}
