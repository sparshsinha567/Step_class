import java.util.*;

abstract class Staff {
    protected String name;
    protected String type;

    public Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract long calculatePay();

    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
    }
}

class FullTimeStaff extends Staff {
    private long salary;

    public FullTimeStaff(String name, long salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    @Override
    public long calculatePay() {
        return salary;
    }
}

class PartTimeStaff extends Staff {
    private long hours;
    private long rate;

    public PartTimeStaff(String name, long hours, long rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public long calculatePay() {
        return hours * rate;
    }
}

class InternStaff extends Staff {
    private long stipend;

    public InternStaff(String name, long stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    @Override
    public long calculatePay() {
        return stipend;
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            if (type.equalsIgnoreCase("FullTime")) {
                long salary = sc.nextLong();
                staffList.add(new FullTimeStaff(name, salary));
            } else if (type.equalsIgnoreCase("PartTime")) {
                long hours = sc.nextLong();
                long rate = sc.nextLong();
                staffList.add(new PartTimeStaff(name, hours, rate));
            } else if (type.equalsIgnoreCase("Intern")) {
                long stipend = sc.nextLong();
                staffList.add(new InternStaff(name, stipend));
            }
        }

        long totalPay = 0;
        long maxPay = -1;
        String topEarner = "";

        for (Staff s : staffList) {
            System.out.println(s);
            long pay = s.calculatePay();
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = s.getName();
            }
        }

        System.out.println("Total " + totalPay);
        System.out.println("top earner " + topEarner);
        sc.close();
    }
}
