import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFilteredFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    public static class EmptyFeedbackException extends Exception {
        public EmptyFeedbackException(String message) {
            super(message);
        }
    }

    public static void printFilteredWordFrequency(String feedback) throws EmptyFeedbackException {
        if (feedback == null) {
            throw new NullPointerException("Feedback text cannot be null.");
        }

        String cleanedText = feedback.toLowerCase();
        cleanedText = cleanedText.replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "")
                                 .replace(";", "")
                                 .replace(":", "")
                                 .replace("\"", "")
                                 .trim();

        if (cleanedText.isEmpty()) {
            throw new EmptyFeedbackException("Feedback text is empty after removing punctuation.");
        }

        String[] words = cleanedText.split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        if (frequencyMap.isEmpty()) {
            System.out.println("No non-stop words found in feedback.");
            return;
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int countComparison = entry2.getValue().compareTo(entry1.getValue());
            if (countComparison != 0) {
                return countComparison;
            }
            return entry1.getKey().compareTo(entry2.getKey());
        });

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void processFeedback(String feedback) {
        System.out.println("\nFeedback: \"" + feedback + "\"");
        System.out.println("--- Frequency Report ---");
        try {
            printFilteredWordFrequency(feedback);
        } catch (EmptyFeedbackException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   T&P Feedback Analysis - Stop-Word Filtered Word Frequency ");
        System.out.println("=============================================================");

        processFeedback("The mentor was great, the session was great and clear.");
        processFeedback("Java is powerful, fast and versatile. Java is used in industry.");
        processFeedback("the was and a is of in");
        processFeedback("   ");
        processFeedback(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Feedback Analysis ---");
        System.out.print("Enter feedback paragraph: ");
        if (scanner.hasNextLine()) {
            String inputFeedback = scanner.nextLine();
            if (!inputFeedback.trim().isEmpty()) {
                processFeedback(inputFeedback);
            }
        }
        scanner.close();
    }
}
