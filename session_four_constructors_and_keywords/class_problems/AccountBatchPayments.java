public class AccountBatchPayments {

    public static class FeeAccount {
        public void makePayment(double amount) {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static class HostelFeeAccount extends FeeAccount {
        @Override
        public void makePayment(double amount) {
            System.out.println("Paid in two installments (hostel account)");
        }
    }

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAccount = (HostelFeeAccount) account;
            hostelAccount.makePayment(amount);
        } else {
            account.makePayment(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000.0;
        int hostelAccountsProcessed = 0;
        int dayScholarAccountsProcessed = 0;

        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], amount);

            if (accounts[i] instanceof HostelFeeAccount) {
                hostelAccountsProcessed++;
            } else {
                dayScholarAccountsProcessed++;
            }
        }

        System.out.printf("Hostel accounts processed: %d | Day-scholar accounts processed: %d\n",
                hostelAccountsProcessed, dayScholarAccountsProcessed);
    }
}
