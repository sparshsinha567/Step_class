import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    private static final int SHORT_WORD_MAX = 4;
    private static final int MEDIUM_WORD_MAX = 8;

    public static class EmptyReviewException extends Exception {
        public EmptyReviewException(String message) {
            super(message);
        }
    }

    public static void classifyWordLengths(String review) throws EmptyReviewException {
        if (review == null) {
            throw new NullPointerException("Review text cannot be null.");
        }

        String cleanedReview = review.trim();
        if (cleanedReview.isEmpty()) {
            throw new EmptyReviewException("Review content is empty.");
        }

        String[] words = cleanedReview.split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            String sanitizedWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int wordLength = sanitizedWord.length();

            if (wordLength == 0) {
                continue;
            }

            if (wordLength <= SHORT_WORD_MAX) {
                shortCount++;
            } else if (wordLength <= MEDIUM_WORD_MAX) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void profileReview(String reviewText) {
        System.out.println("\nReview: \"" + reviewText + "\"");
        try {
            System.out.print("Output: ");
            classifyWordLengths(reviewText);
        } catch (EmptyReviewException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Movie Review Moderation Tool - Word Length Profiler       ");
        System.out.println("=============================================================");

        profileReview("This movie was absolutely fantastic and thrilling");
        profileReview("Great film!");
        profileReview("Supercalifragilisticexpialidocious performance throughout");
        profileReview("   ");
        profileReview(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Review Profiling ---");
        System.out.print("Enter movie review text: ");
        if (scanner.hasNextLine()) {
            String inputReview = scanner.nextLine();
            if (!inputReview.trim().isEmpty()) {
                profileReview(inputReview);
            }
        }
        scanner.close();
    }
}
