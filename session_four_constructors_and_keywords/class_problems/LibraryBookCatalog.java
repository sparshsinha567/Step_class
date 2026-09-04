public class LibraryBookCatalog {

    public static class LibraryBook {
        private String title;
        private String isbn;
        private boolean catalogued;

        public LibraryBook(String title, String isbn) {
            if (title == null) {
                throw new NullPointerException("Title cannot be null.");
            }
            this.title = title.trim();
            this.isbn = (isbn == null || isbn.trim().isEmpty()) ? "PENDING" : isbn.trim();
            this.catalogued = true;
        }

        public LibraryBook(String title) {
            this(title, "PENDING");
        }

        public void printCatalogEntry() {
            System.out.printf("%s | %s | Catalogued: %b\n", this.title, this.isbn, this.catalogued);
        }

        public String getTitle() {
            return this.title;
        }

        public String getIsbn() {
            return this.isbn;
        }

        public boolean isCatalogued() {
            return this.catalogued;
        }
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book;
            if (isbns[i] == null || isbns[i].trim().isEmpty()) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }
            book.printCatalogEntry();
        }
    }
}
