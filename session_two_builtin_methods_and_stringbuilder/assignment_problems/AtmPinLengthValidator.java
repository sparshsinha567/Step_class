import java.util.Scanner;

public class AtmPinLengthValidator {

    private static final int REQUIRED_PIN_LENGTH = 4;

    public static class InvalidPinException extends Exception {
        public InvalidPinException(String message) {
            super(message);
        }
    }

    public static void checkPinLength(String pin) throws InvalidPinException {
        if (pin == null) {
            throw new NullPointerException("PIN cannot be null.");
        }

        if (pin.length() != REQUIRED_PIN_LENGTH) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void processPin(String pin) {
        System.out.println("\nPIN Input: \"" + pin + "\"");
        try {
            System.out.print("Output:    ");
            checkPinLength(pin);
        } catch (InvalidPinException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("            ATM App - PIN Length Validator                   ");
        System.out.println("=============================================================");

        processPin("482");
        processPin("4820");
        processPin("12345");
        processPin("0000");
        processPin("");
        processPin(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive ATM PIN Input ---");
        System.out.print("Enter your ATM PIN: ");
        if (scanner.hasNextLine()) {
            String inputPin = scanner.nextLine();
            if (!inputPin.trim().isEmpty()) {
                processPin(inputPin);
            }
        }
        scanner.close();
    }
}
