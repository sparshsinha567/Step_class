import java.util.Scanner;

public class WordReversalEncoder {

    public static class EmptySentenceException extends Exception {
        public EmptySentenceException(String message) {
            super(message);
        }
    }

    public static String reverseEachWord(String sentence) throws EmptySentenceException {
        if (sentence == null) {
            throw new NullPointerException("Sentence cannot be null.");
        }

        String cleanedSentence = sentence.trim();
        if (cleanedSentence.isEmpty()) {
            throw new EmptySentenceException("Sentence cannot be empty.");
        }

        String[] words = cleanedSentence.split(" ");
        StringBuilder sentenceBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            StringBuilder wordReverser = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                wordReverser.append(word.charAt(j));
            }

            sentenceBuilder.append(wordReverser.toString());
            if (i < words.length - 1) {
                sentenceBuilder.append(" ");
            }
        }

        return sentenceBuilder.toString();
    }

    public static void encodeSentence(String sentence) {
        System.out.println("\nInput:  \"" + sentence + "\"");
        try {
            String encoded = reverseEachWord(sentence);
            System.out.println("Output: " + encoded);
        } catch (EmptySentenceException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("      Coding Club Mirror Text - Word Reversal Encoder         ");
        System.out.println("=============================================================");

        encodeSentence("hello club");
        encodeSentence("Java is awesome");
        encodeSentence("Data Structures and Algorithms");
        encodeSentence("   ");
        encodeSentence(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Word Reversal ---");
        System.out.print("Enter sentence to mirror: ");
        if (scanner.hasNextLine()) {
            String inputSentence = scanner.nextLine();
            if (!inputSentence.trim().isEmpty()) {
                encodeSentence(inputSentence);
            }
        }
        scanner.close();
    }
}
