import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    public static class StringLengthMismatchException extends Exception {
        public StringLengthMismatchException(String message) {
            super(message);
        }
    }

    public static void checkTypingAccuracy(String original, String typed) throws StringLengthMismatchException {
        if (original == null || typed == null) {
            throw new NullPointerException("Original and typed strings cannot be null.");
        }

        if (original.length() != typed.length()) {
            throw new StringLengthMismatchException("String length mismatch: Original ("
                    + original.length() + " chars) vs Typed (" + typed.length() + " chars).");
        }

        int totalChars = original.length();
        if (totalChars == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalCharMismatch = ' ';
        char typedCharMismatch = ' ';

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            int origAscii = (int) origChar;
            int typedAscii = (int) typedChar;

            if (origAscii == typedAscii) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
                originalCharMismatch = origChar;
                typedCharMismatch = typedChar;
            }
        }

        double accuracy = ((double) matchedCount / totalChars) * 100.0;

        if (firstMismatchPosition != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
                    matchedCount, totalChars, accuracy, firstMismatchPosition, originalCharMismatch, typedCharMismatch);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n",
                    matchedCount, totalChars, accuracy);
        }
    }

    public static void evaluateTyping(String original, String typed) {
        System.out.println("\nOriginal: \"" + original + "\"");
        System.out.println("Typed:    \"" + typed + "\"");
        try {
            System.out.print("Output:   ");
            checkTypingAccuracy(original, typed);
        } catch (StringLengthMismatchException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Online Typing Practice - Accuracy & Mismatch Checker     ");
        System.out.println("=============================================================");

        evaluateTyping("hello world", "hello worlt");
        evaluateTyping("coding", "coding");
        evaluateTyping("Java Programming", "Jawa Programmlng");
        evaluateTyping("Short", "LongerText");
        evaluateTyping(null, "Test");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Typing Accuracy Test ---");
        System.out.print("Enter original passage: ");
        if (scanner.hasNextLine()) {
            String orig = scanner.nextLine();
            System.out.print("Enter user typed text:  ");
            if (scanner.hasNextLine()) {
                String typed = scanner.nextLine();
                evaluateTyping(orig, typed);
            }
        }
        scanner.close();
    }
}
