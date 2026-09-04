import java.util.Scanner;

public class ReverseCustomerName {

    public static class InvalidCustomerNameException extends Exception {
        public InvalidCustomerNameException(String message) {
            super(message);
        }
    }

    public static String reverseCustomerName(String customerName) throws InvalidCustomerNameException {
        if (customerName == null) {
            throw new NullPointerException("Customer name cannot be null.");
        }

        String trimmedName = customerName.trim();

        if (trimmedName.isEmpty()) {
            throw new InvalidCustomerNameException("Customer name cannot be empty or solely whitespace.");
        }

        for (int i = 0; i < trimmedName.length(); i++) {
            char ch = trimmedName.charAt(i);
            int asciiVal = (int) ch;
            if (asciiVal < 32 || asciiVal > 126) {
                throw new InvalidCustomerNameException("Customer name contains non-standard ASCII characters.");
            }
        }

        char[] originalChars = trimmedName.toCharArray();
        int length = originalChars.length;
        char[] reversedChars = new char[length];

        for (int i = 0; i < length; i++) {
            reversedChars[i] = originalChars[length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void verifyAndDisplayCustomer(String name) {
        System.out.println("\nProcessing Verification for: \"" + name + "\"");
        try {
            String reversed = reverseCustomerName(name);

            System.out.println("\tOriginal Name: " + name);
            System.out.println("\tReversed Name: " + reversed);
            System.out.println("\tVerification Status: [SUCCESS]");
        } catch (InvalidCustomerNameException e) {
            System.out.println("\t[Compliance Error]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("\t[Runtime Error]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Customer Identity Verification System - Name Reversal     ");
        System.out.println("=============================================================");

        String[] customerDatabase = {
            "Sunil",
            "Alice Johnson",
            "John Doe",
            "Radar",
            "   ",
            null
        };

        System.out.println("\n--- Batch Customer Record Verification ---");
        for (String customer : customerDatabase) {
            verifyAndDisplayCustomer(customer);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Customer Identity Check ---");
        System.out.print("Enter customer name to verify: ");
        if (scanner.hasNextLine()) {
            String inputName = scanner.nextLine();
            if (!inputName.trim().isEmpty()) {
                verifyAndDisplayCustomer(inputName);
            }
        }
        scanner.close();
    }
}
