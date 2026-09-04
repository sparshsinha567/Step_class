import java.util.Scanner;

public class ProductInventoryCsvParser {

    public static class InvalidCsvFormatException extends Exception {
        public InvalidCsvFormatException(String message) {
            super(message);
        }
    }

    public static void parseInventoryRecord(String csvLine) throws InvalidCsvFormatException {
        if (csvLine == null) {
            throw new NullPointerException("CSV line cannot be null.");
        }

        String cleanedLine = csvLine.trim();
        if (cleanedLine.isEmpty()) {
            throw new InvalidCsvFormatException("CSV line is empty.");
        }

        String[] fields = cleanedLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Product: ").append(productName)
                     .append(" | SKU: ").append(sku)
                     .append(" | Qty: ").append(quantity);

        System.out.println(recordBuilder.toString());
    }

    public static void processRecord(String line) {
        System.out.println("\nInput:  \"" + line + "\"");
        try {
            System.out.print("Output: ");
            parseInventoryRecord(line);
        } catch (InvalidCsvFormatException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Warehouse Inventory Updates - CSV Product Parser        ");
        System.out.println("=============================================================");

        processRecord("Wireless Mouse,WM-2201,150");
        processRecord("Wireless Mouse,150");
        processRecord("Mechanical Keyboard,KB-9002,80");
        processRecord("Gaming Monitor,GM-5001,45");
        processRecord("Headphones, ,100");
        processRecord("");
        processRecord(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Inventory CSV Input ---");
        System.out.print("Enter CSV line (ProductName,SKU,Quantity): ");
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (!inputLine.trim().isEmpty()) {
                processRecord(inputLine);
            }
        }
        scanner.close();
    }
}
