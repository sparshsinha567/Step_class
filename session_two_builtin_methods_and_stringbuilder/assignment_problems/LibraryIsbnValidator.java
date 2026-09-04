import java.util.Scanner;

public class LibraryIsbnValidator {

    public static class InvalidIsbnException extends Exception {
        public InvalidIsbnException(String message) {
            super(message);
        }
    }

    public static String normalizeCode(String raw) {
        if (raw == null) {
            throw new NullPointerException("Raw ISBN code cannot be null.");
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code cannot be null";
        }

        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalogNumber = normalized.substring(7, 13);

        StringBuilder formattedBuilder = new StringBuilder();
        formattedBuilder.append("[").append(pubCode).append("] ")
                        .append("YEAR: ").append(year)
                        .append(" | CATALOG: ").append(catalogNumber);

        return formattedBuilder.toString();
    }

    public static void processIsbn(String rawCode) {
        System.out.println("\nRaw Input: \"" + rawCode + "\"");
        try {
            String result = validateAndFormat(rawCode);
            System.out.println("Output:    " + result);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Library Book-Intake Scanner - ISBN Normalizer & Validator");
        System.out.println("=============================================================");

        processIsbn(" pen2026004251 ");
        processIsbn("12N2026004251");
        processIsbn("oxf2023123456");
        processIsbn("mit2024abc123");
        processIsbn("short123");
        processIsbn(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive ISBN Validation ---");
        System.out.print("Enter book ISBN-style code: ");
        if (scanner.hasNextLine()) {
            String inputCode = scanner.nextLine();
            if (!inputCode.trim().isEmpty()) {
                processIsbn(inputCode);
            }
        }
        scanner.close();
    }
}
