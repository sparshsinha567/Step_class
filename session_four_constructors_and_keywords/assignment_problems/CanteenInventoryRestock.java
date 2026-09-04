public class CanteenInventoryRestock {

    public static class Item {
        private String itemName;
        private int stock;

        public Item(String itemName, int stock) {
            if (itemName == null) {
                throw new NullPointerException("Item name cannot be null.");
            }
            if (stock < 0) {
                throw new IllegalArgumentException("Starting stock cannot be negative.");
            }
            this.itemName = itemName;
            this.stock = stock;
        }

        public void restock(int stock) {
            if (stock > 0) {
                this.stock += stock;
            }
        }

        public String getItemName() {
            return this.itemName;
        }

        public int getStock() {
            return this.stock;
        }

        public void printItemStatus() {
            System.out.printf("%s | Final Stock: %d\n", this.itemName, this.stock);
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("       Campus Canteen Inventory - Batch Restock System        ");
        System.out.println("=============================================================");

        Item[] items = new Item[4];
        items[0] = new Item("Samosa", 15);
        items[1] = new Item("Tea Powder", 40);
        items[2] = new Item("Bread", 8);
        items[3] = new Item("Biscuit Packs", 25);

        for (int i = 0; i < items.length; i++) {
            items[i].restock(20);
            items[i].printItemStatus();
        }
    }
}
