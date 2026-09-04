import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    private static final int ASCII_SIZE = 256;

    public static class NoUniqueCharacterException extends Exception {
        public NoUniqueCharacterException(String message) {
            super(message);
        }
    }

    public static int[] computeAsciiFrequencies(String text) {
        if (text == null) {
            throw new NullPointerException("Input string cannot be null.");
        }
        int[] frequencyArray = new int[ASCII_SIZE];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int asciiCode = (int) ch;

            if (asciiCode < ASCII_SIZE) {
                frequencyArray[asciiCode]++;
            }
        }
        return frequencyArray;
    }

    public static char findFirstNonRepeatingChar(String text) throws NoUniqueCharacterException {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be empty.");
        }

        int[] frequencies = computeAsciiFrequencies(text);

        for (int i = 0; i < text.length(); i++) {
            char candidate = text.charAt(i);
            int asciiCode = (int) candidate;

            if (asciiCode < ASCII_SIZE && frequencies[asciiCode] == 1) {
                return candidate;
            }
        }

        throw new NoUniqueCharacterException("No Non-Repeating Character Found in \"" + text + "\"");
    }

    public static void evaluateAndDisplay(String input) {
        System.out.println("\nAnalyzing Input: \"" + input + "\"");
        try {
            char result = findFirstNonRepeatingChar(input);
            int asciiVal = (int) result;
            System.out.printf("Output -> First Non-Repeating Character: '%c' (ASCII Code: %d)\n", result, asciiVal);
        } catch (NoUniqueCharacterException e) {
            System.out.println("Output -> " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("[Validation Error]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Unique Letter Hunt Mini-Game - Character Frequency       ");
        System.out.println("=============================================================");

        String[] testCases = {
            "swiss",
            "aabbcc",
            "stress",
            "algorithm",
            "1122334",
            "",
            null
        };

        System.out.println("\n--- Automated Test Scenarios ---");
        for (String testCase : testCases) {
            evaluateAndDisplay(testCase);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Player Input ---");
        System.out.print("Enter a word or sentence for the Unique Letter Hunt: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                evaluateAndDisplay(userInput);
            }
        }
        scanner.close();
    }
}
