import java.util.Scanner;

public class VowelConsonantCounter {

    public static class InvalidTextInputException extends Exception {
        public InvalidTextInputException(String message) {
            super(message);
        }
    }

    public static void countVowelsAndConsonants(String text) throws InvalidTextInputException {
        if (text == null) {
            throw new NullPointerException("Input text cannot be null.");
        }

        String cleanedText = text.trim();
        if (cleanedText.isEmpty()) {
            throw new InvalidTextInputException("Input text is empty.");
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < cleanedText.length(); i++) {
            char ch = cleanedText.charAt(i);

            if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d\n", vowelCount, consonantCount);
    }

    public static void processText(String text) {
        System.out.println("\nInput:  \"" + text + "\"");
        try {
            System.out.print("Output: ");
            countVowelsAndConsonants(text);
        } catch (InvalidTextInputException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("        Library Kiosk - Vowel & Consonant Counter            ");
        System.out.println("=============================================================");

        processText("Java Programming");
        processText("Data Structures & Algorithms");
        processText("AEIOU");
        processText("BCDFG");
        processText("   ");
        processText(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Text Analysis ---");
        System.out.print("Enter book title / text: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                processText(userInput);
            }
        }
        scanner.close();
    }
}
