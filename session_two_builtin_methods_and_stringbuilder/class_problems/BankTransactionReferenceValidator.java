import java.util.Scanner;

public class BankTransactionReferenceValidator {

    public static class TransactionReferenceException extends Exception {
        public TransactionReferenceException(String message) {
            super(message);
        }
    }

    public static String normalizeReference(String raw) {
        if (raw == null) {
            throw new NullPointerException("Raw reference string cannot be null.");
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference cannot be null";
        }

        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String day = normalized.substring(3, 5);
        String month = normalized.substring(5, 7);
        String year = normalized.substring(7, 9);
        String sequence = normalized.substring(9, 14);

        StringBuilder formattedBuilder = new StringBuilder();
        formattedBuilder.append("[").append(bankCode).append("] ")
                        .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                        .append(" | SEQ: ").append(sequence);

        return formattedBuilder.toString();
    }

    public static void processReference(String rawReference) {
        System.out.println("\nRaw Input: \"" + rawReference + "\"");
        try {
            String result = validateAndFormat(rawReference);
            System.out.println("Output:    " + result);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Fintech Platform - Bank Reference Generator & Validator   ");
        System.out.println("=============================================================");

        processReference(" hdf03022600042 ");
        processReference("12F03022600042");
        processReference("sbi15082412345");
        processReference("icici12345");
        processReference("AXIS010125ABCDE");
        processReference(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Reference Validation ---");
        System.out.print("Enter transaction reference: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                processReference(userInput);
            }
        }
        scanner.close();
    }
}
