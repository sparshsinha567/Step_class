import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static class InventoryDataException extends Exception {
        public InventoryDataException(String message) {
            super(message);
        }
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) throws InventoryDataException {
        if (sectionA == null || sectionB == null) {
            throw new NullPointerException("Inventory section arrays cannot be null.");
        }

        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Section A and Section B must have matching category lengths. (A: "
                    + sectionA.length + ", B: " + sectionB.length + ")");
        }

        if (sectionA.length == 0) {
            throw new InventoryDataException("Inventory sections contain no product categories.");
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] < 0 || sectionB[i] < 0) {
                throw new InventoryDataException("Negative quantity detected at item index " + (i + 1));
            }

            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String balanceStatus = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, balanceStatus, highestQuantity, highestSection, highestItemIndex);
    }

    public static void runAudit(int[] secA, int[] secB) {
        System.out.print("\nSection A: {");
        if (secA != null) {
            for (int i = 0; i < secA.length; i++) {
                System.out.print(secA[i] + (i < secA.length - 1 ? ", " : ""));
            }
        }
        System.out.print("} | Section B: {");
        if (secB != null) {
            for (int i = 0; i < secB.length; i++) {
                System.out.print(secB[i] + (i < secB.length - 1 ? ", " : ""));
            }
        }
        System.out.println("}");

        try {
            System.out.print("Output:    ");
            analyzeInventory(secA, secB);
        } catch (InventoryDataException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("       Warehouse Storage Sections - Inventory Balancer        ");
        System.out.println("=============================================================");

        int[] sampleA1 = {20, 15, 30};
        int[] sampleB1 = {25, 10, 30};
        runAudit(sampleA1, sampleB1);

        int[] sampleA2 = {50, 40, 10};
        int[] sampleB2 = {30, 20, 10};
        runAudit(sampleA2, sampleB2);

        int[] sampleA3 = {10, 20};
        int[] sampleB3 = {10, 20, 30};
        runAudit(sampleA3, sampleB3);

        int[] sampleA4 = {10, -5};
        int[] sampleB4 = {5, 0};
        runAudit(sampleA4, sampleB4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Warehouse Inventory Input ---");
        System.out.print("Enter Section A quantities (comma-separated): ");
        if (scanner.hasNextLine()) {
            String lineA = scanner.nextLine().trim();
            System.out.print("Enter Section B quantities (comma-separated): ");
            if (scanner.hasNextLine()) {
                String lineB = scanner.nextLine().trim();
                try {
                    String[] tokensA = lineA.split(",");
                    String[] tokensB = lineB.split(",");
                    int[] userA = new int[tokensA.length];
                    int[] userB = new int[tokensB.length];

                    for (int i = 0; i < tokensA.length; i++) {
                        userA[i] = Integer.parseInt(tokensA[i].trim());
                    }
                    for (int i = 0; i < tokensB.length; i++) {
                        userB[i] = Integer.parseInt(tokensB[i].trim());
                    }

                    runAudit(userA, userB);
                } catch (NumberFormatException e) {
                    System.out.println("[Format Error]: Please enter valid integer numbers.");
                }
            }
        }
        scanner.close();
    }
}
