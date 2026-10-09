import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryCatalogLookup {

    public static class BookRecord {
        private final String isbn;
        private final String title;

        public BookRecord(String isbn, String title) {
            this.isbn = Objects.requireNonNull(isbn).trim();
            this.title = Objects.requireNonNull(title).trim();
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "(\"" + isbn + "\", \"" + title + "\")";
        }
    }

    /**
     * Binary search to find a book title by targetIsbn in a sorted catalog.
     *
     * Time Complexity: O(log n) - In each iteration, the search interval is halved.
     * Auxiliary Space Complexity: O(1) - Uses constant extra pointers.
     */
    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null || catalog.isEmpty()) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            BookRecord midRecord = catalog.get(mid);
            int cmp = midRecord.getIsbn().compareTo(targetIsbn);

            if (cmp == 0) {
                return midRecord.getTitle();
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        List<BookRecord> catalog = new ArrayList<>();
        catalog.add(new BookRecord("0001112223", "Introduction to Algebra"));
        catalog.add(new BookRecord("0002223334", "Beginning Python"));
        catalog.add(new BookRecord("0003334445", "Classic Mythology"));
        catalog.add(new BookRecord("0004445556", "Data and Society"));
        catalog.add(new BookRecord("0005556667", "European History"));

        System.out.println("Lookup 0003334445: " + findBook(catalog, "0003334445"));
        System.out.println("Lookup 0009998887: " + findBook(catalog, "0009998887"));
    }
}
