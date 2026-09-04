import java.util.Scanner;

public class LibraryInventoryManager {

    public static class BookInventory {
        private final String title;
        private final String author;
        private final int copiesAvailable;

        public BookInventory(String title, String author, int copiesAvailable) {
            if (title == null || author == null) {
                throw new NullPointerException("Title and Author cannot be null.");
            }
            if (copiesAvailable < 0) {
                throw new IllegalArgumentException("Copies available cannot be negative.");
            }
            this.title = title.trim();
            this.author = author.trim();
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.printf("%s by %s - %d copies available\n", this.title, this.author, this.copiesAvailable);
        }

        public String getTitle() {
            return this.title;
        }

        public String getAuthor() {
            return this.author;
        }

        public int getCopiesAvailable() {
            return this.copiesAvailable;
        }
    }

    public static void displayInventory(BookInventory[] books) {
        if (books == null) {
            throw new NullPointerException("Books array cannot be null.");
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof BookInventory) {
                books[i].printEntry();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Library Book Inventory - OOP Class & Object Array       ");
        System.out.println("=============================================================");

        BookInventory[] inventory = new BookInventory[4];
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        displayInventory(inventory);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Book Entry ---");
        System.out.print("Enter (Title, Author, Copies): ");
        if (scanner.hasNextLine()) {
            String rawLine = scanner.nextLine().trim();
            if (!rawLine.isEmpty()) {
                String[] tokens = rawLine.split(",");
                if (tokens.length == 3) {
                    try {
                        String title = tokens[0].trim();
                        String author = tokens[1].trim();
                        int copies = Integer.parseInt(tokens[2].trim());
                        BookInventory customBook = new BookInventory(title, author, copies);
                        System.out.print("Added Entry: ");
                        customBook.printEntry();
                    } catch (NumberFormatException e) {
                        System.out.println("[Error]: Invalid number of copies format.");
                    }
                }
            }
        }
        scanner.close();
    }
}
