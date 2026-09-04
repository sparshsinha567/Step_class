import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static class InvalidPhoneNumberException extends Exception {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    public static String maskPhoneNumber(String phone) throws InvalidPhoneNumberException {
        if (phone == null) {
            throw new NullPointerException("Phone number cannot be null.");
        }

        String cleanedPhone = phone.trim();

        if (cleanedPhone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < cleanedPhone.length(); i++) {
            char ch = cleanedPhone.charAt(i);
            if (!Character.isDigit(ch)) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = cleanedPhone.substring(6);

        StringBuilder maskedBuilder = new StringBuilder();
        maskedBuilder.append("XXXXXX");
        maskedBuilder.append("-");
        maskedBuilder.append(lastFourDigits);

        return maskedBuilder.toString();
    }

    public static void processPhoneNumber(String phone) {
        System.out.println("\nPhone Input: \"" + phone + "\"");
        try {
            String masked = maskPhoneNumber(phone);
            System.out.println("Output:      " + masked);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Student-Support Call Center - Masked Phone Formatter      ");
        System.out.println("=============================================================");

        processPhoneNumber("9876543210");
        processPhoneNumber("98765");
        processPhoneNumber("98765abcde");
        processPhoneNumber("123456789012");
        processPhoneNumber("8877665544");
        processPhoneNumber(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Phone Masking ---");
        System.out.print("Enter phone number: ");
        if (scanner.hasNextLine()) {
            String inputPhone = scanner.nextLine();
            if (!inputPhone.trim().isEmpty()) {
                processPhoneNumber(inputPhone);
            }
        }
        scanner.close();
    }
}
