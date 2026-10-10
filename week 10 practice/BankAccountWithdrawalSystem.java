import java.util.*;

abstract class Account {
    protected String id;
    protected double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);
}

class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + (long) balance);
        }
    }
}

class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = -5000.0;

    public CurrentAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < OVERDRAFT_LIMIT) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + (long) balance);
        }
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();
            if (op.equalsIgnoreCase("Savings")) {
                String id = sc.next();
                double initialBalance = sc.nextDouble();
                accounts.put(id, new SavingsAccount(id, initialBalance));
            } else if (op.equalsIgnoreCase("Current")) {
                String id = sc.next();
                double initialBalance = sc.nextDouble();
                accounts.put(id, new CurrentAccount(id, initialBalance));
            } else if (op.equalsIgnoreCase("WITHDRAW")) {
                String id = sc.next();
                double amount = sc.nextDouble();
                Account acc = accounts.get(id);
                if (acc == null) {
                    System.out.println("Account not found");
                } else {
                    acc.withdraw(amount);
                }
            }
        }
        sc.close();
    }
}
