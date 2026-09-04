import java.util.Scanner;

public class PalindromeChecker {

    public static class InvalidTextInputException extends Exception {
        public InvalidTextInputException(String message) {
            super(message);
        }
    }

    public static String sanitizeText(String text) throws InvalidTextInputException {
        if (text == null) {
            throw new NullPointerException("Input text cannot be null.");
        }
        String cleaned = text.trim().toLowerCase();
        if (cleaned.isEmpty()) {
            throw new InvalidTextInputException("Input string is empty after trimming whitespace.");
        }
        return cleaned;
    }

    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        char[] originalChars = text.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        String reversedText = new String(reversedChars);
        return text.equals(reversedText);
    }

    public static void verifyPalindrome(String rawInput) {
        System.out.println("\nTesting Input: \"" + rawInput + "\"");
        try {
            String sanitized = sanitizeText(rawInput);

            boolean resIterative = isPalindromeIterative(sanitized);
            boolean resRecursive = isPalindromeRecursive(sanitized);
            boolean resArrayReversal = isPalindromeArrayReversal(sanitized);

            String iterText = resIterative ? "Palindrome" : "Not Palindrome";
            String recText = resRecursive ? "Palindrome" : "Not Palindrome";
            String arrText = resArrayReversal ? "Palindrome" : "Not Palindrome";

            System.out.printf("Output -> Iterative: %s | Recursive: %s | Array Reversal: %s\n",
                    iterText, recText, arrText);

            if (resIterative == resRecursive && resRecursive == resArrayReversal) {
                System.out.println("QA Check Status: [PASSED] - All 3 approaches agreed.");
            } else {
                System.out.println("QA Check Status: [FAILED] - Discrepancy detected across approaches!");
            }
        } catch (InvalidTextInputException e) {
            System.out.println("[Checked Exception Caught]: " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("[Unchecked Exception Caught]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("        QA Text Verification Toolkit - Palindrome Checker     ");
        System.out.println("=============================================================");

        String[] testSamples = {"madam", "hello", "RaceCar", "A", ""};

        System.out.println("\n--- Running Automated Test Suite ---");
        for (String sample : testSamples) {
            verifyPalindrome(sample);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Palindrome Verification ---");
        System.out.print("Enter custom text to check: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                verifyPalindrome(userInput);
            }
        }
        scanner.close();
    }
}
