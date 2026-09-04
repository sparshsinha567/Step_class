public class IdCardReferenceDemo {

    public static class IdCard {
        private final String name;
        public int booksIssued;

        public IdCard(String name, int booksIssued) {
            if (name == null) {
                throw new NullPointerException("Student name cannot be null.");
            }
            this.name = name.trim();
            this.booksIssued = booksIssued;
        }

        public String getName() {
            return this.name;
        }

        public int getBooksIssued() {
            return this.booksIssued;
        }
    }

    public static void runIdentityTest() {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.getBooksIssued());
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("     Library Card System - Reference Copies vs Identity      ");
        System.out.println("=============================================================");

        runIdentityTest();
    }
}
