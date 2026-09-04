import java.util.Scanner;

public class PlacementManager {

    public static class PlacementRecord {
        private final String studentName;
        private final String company;
        private final double packageLpa;

        public PlacementRecord(String studentName, String company, double packageLpa) {
            if (studentName == null || company == null) {
                throw new NullPointerException("Student name and company cannot be null.");
            }
            if (packageLpa < 0.0) {
                throw new IllegalArgumentException("Package LPA cannot be negative.");
            }
            this.studentName = studentName.trim();
            this.company = company.trim();
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.printf("%s -> %s @ %.1f LPA\n", this.studentName, this.company, this.packageLpa);
        }

        public String getStudentName() {
            return this.studentName;
        }

        public String getCompany() {
            return this.company;
        }

        public double getPackageLpa() {
            return this.packageLpa;
        }
    }

    public static void displayAllPlacements(PlacementRecord[] records) {
        if (records == null) {
            throw new NullPointerException("Placement records array cannot be null.");
        }

        for (int i = 0; i < records.length; i++) {
            if (records[i] instanceof PlacementRecord) {
                records[i].printRecord();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("         T&P Cell - Student Placement Records                ");
        System.out.println("=============================================================");

        PlacementRecord[] placements = new PlacementRecord[3];
        placements[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        placements[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        placements[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        displayAllPlacements(placements);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Placement Entry ---");
        System.out.print("Enter (Name,Company,LPA): ");
        if (scanner.hasNextLine()) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                String[] tokens = raw.split(",");
                if (tokens.length == 3) {
                    try {
                        String name = tokens[0].trim();
                        String company = tokens[1].trim();
                        double lpa = Double.parseDouble(tokens[2].trim());
                        PlacementRecord customRecord = new PlacementRecord(name, company, lpa);
                        System.out.print("Created Record: ");
                        customRecord.printRecord();
                    } catch (NumberFormatException e) {
                        System.out.println("[Error]: Invalid package LPA format.");
                    }
                }
            }
        }
        scanner.close();
    }
}
