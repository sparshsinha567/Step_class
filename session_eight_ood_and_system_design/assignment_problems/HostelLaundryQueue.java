import java.util.Objects;

// Implement: The Hostel Laundry Queue
public class HostelLaundryQueue {

    public interface WashType {
        String getName();
        int getDurationMinutes();
        double getCharge();
    }

    public static class QuickWash implements WashType {
        @Override
        public String getName() {
            return "Quick";
        }

        @Override
        public int getDurationMinutes() {
            return 30;
        }

        @Override
        public double getCharge() {
            return 20.00;
        }
    }

    public static class NormalWash implements WashType {
        @Override
        public String getName() {
            return "Normal";
        }

        @Override
        public int getDurationMinutes() {
            return 45;
        }

        @Override
        public double getCharge() {
            return 30.00;
        }
    }

    public static class HeavyWash implements WashType {
        @Override
        public String getName() {
            return "Heavy";
        }

        @Override
        public int getDurationMinutes() {
            return 60;
        }

        @Override
        public double getCharge() {
            return 45.00;
        }
    }

    public static class DelicateWash implements WashType {
        @Override
        public String getName() {
            return "Delicate";
        }

        @Override
        public int getDurationMinutes() {
            return 35;
        }

        @Override
        public double getCharge() {
            return 35.00;
        }
    }

    public static class Student {
        private final String name;

        public Student(String name) {
            this.name = Objects.requireNonNull(name, "Name cannot be null").trim();
        }

        public String getName() {
            return name;
        }
    }

    public static class WashingMachine {
        private final String machineId;
        private boolean busy;
        private WashCycle currentCycle;

        public WashingMachine(String machineId) {
            this.machineId = Objects.requireNonNull(machineId, "Machine ID cannot be null").trim();
            this.busy = false;
        }

        public String getMachineId() {
            return machineId;
        }

        public boolean isBusy() {
            return busy;
        }

        public WashCycle startWash(Student student, WashType washType) {
            if (this.busy) {
                System.out.println("Machine " + machineId + " is currently busy.");
                return null;
            }
            this.busy = true;
            this.currentCycle = new WashCycle(student, this, washType);
            System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                    washType.getName(), machineId, student.getName(),
                    washType.getDurationMinutes(), washType.getCharge());
            return this.currentCycle;
        }

        public void completeCycle() {
            if (!this.busy) {
                System.out.println("Machine " + machineId + " is not currently running a cycle.");
                return;
            }
            this.busy = false;
            this.currentCycle = null;
            System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
        }
    }

    public static class WashCycle {
        private final Student student;
        private final WashingMachine machine;
        private final WashType washType;

        public WashCycle(Student student, WashingMachine machine, WashType washType) {
            this.student = student;
            this.machine = machine;
            this.washType = washType;
        }

        public Student getStudent() {
            return student;
        }

        public WashingMachine getMachine() {
            return machine;
        }

        public WashType getWashType() {
            return washType;
        }
    }

    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        m1.startWash(asha, quick);
        m1.startWash(ravi, heavy);
        m2.startWash(ravi, heavy);
        m1.completeCycle();
        m1.startWash(neha, normal);
    }
}
