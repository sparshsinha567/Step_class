import java.util.*;

interface Chargeable {
    boolean canCharge();
}

abstract class Vehicle {
    protected String passNumber;
    protected String ownerName;
    protected String type;

    public Vehicle(String type, String passNumber, String ownerName) {
        this.type = type;
        this.passNumber = passNumber;
        this.ownerName = ownerName;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getType() {
        return type;
    }

    public abstract int getPassFee();
}

class Bike extends Vehicle {
    public Bike(String passNumber, String ownerName) {
        super("Bike", passNumber, ownerName);
    }

    @Override
    public int getPassFee() {
        return 300;
    }
}

class Car extends Vehicle {
    public Car(String passNumber, String ownerName) {
        super("Car", passNumber, ownerName);
    }

    @Override
    public int getPassFee() {
        return 1000;
    }
}

class EBike extends Vehicle implements Chargeable {
    public EBike(String passNumber, String ownerName) {
        super("EBike", passNumber, ownerName);
    }

    @Override
    public int getPassFee() {
        return 300;
    }

    @Override
    public boolean canCharge() {
        return true;
    }
}

class ECar extends Vehicle implements Chargeable {
    public ECar(String passNumber, String ownerName) {
        super("ECar", passNumber, ownerName);
    }

    @Override
    public int getPassFee() {
        return 1000;
    }

    @Override
    public boolean canCharge() {
        return true;
    }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> registry = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();
            if (op.equalsIgnoreCase("PASS")) {
                String typeStr = sc.next();
                String passNumber = sc.next();
                String ownerName = sc.next();

                Vehicle v;
                if (typeStr.equalsIgnoreCase("Bike")) v = new Bike(passNumber, ownerName);
                else if (typeStr.equalsIgnoreCase("Car")) v = new Car(passNumber, ownerName);
                else if (typeStr.equalsIgnoreCase("EBike")) v = new EBike(passNumber, ownerName);
                else v = new ECar(passNumber, ownerName);

                registry.put(passNumber, v);
                System.out.println(passNumber + " (" + typeStr + ") pass fee " + v.getPassFee());
            } else if (op.equalsIgnoreCase("CHARGE")) {
                String passNumber = sc.next();
                Vehicle v = registry.get(passNumber);
                if (v instanceof Chargeable) {
                    System.out.println(passNumber + " charging bay allotted");
                } else {
                    System.out.println(passNumber + " rejected: charging unsupported");
                }
            }
        }
        sc.close();
    }
}
