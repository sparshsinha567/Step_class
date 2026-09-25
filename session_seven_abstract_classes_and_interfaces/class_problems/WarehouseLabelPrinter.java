public class WarehouseLabelPrinter {

    public interface Printable {
        String printLabel();
    }

    public static class PackageBox implements Printable {
        private final String trackingId;

        public PackageBox(String trackingId) {
            if (trackingId == null || trackingId.trim().isEmpty()) {
                throw new IllegalArgumentException("trackingId is never blank");
            }
            this.trackingId = trackingId.trim();
        }

        public String getTrackingId() {
            return this.trackingId;
        }

        @Override
        public String printLabel() {
            return "Package label: " + this.trackingId;
        }
    }

    public static class Invoice implements Printable {
        private final String invoiceNumber;

        public Invoice(String invoiceNumber) {
            if (invoiceNumber == null || invoiceNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("invoiceNumber is never blank");
            }
            this.invoiceNumber = invoiceNumber.trim();
        }

        public String getInvoiceNumber() {
            return this.invoiceNumber;
        }

        @Override
        public String printLabel() {
            return "Invoice label: " + this.invoiceNumber;
        }
    }

    public static void printAll(Printable[] items) {
        if (items == null) {
            return;
        }
        for (Printable item : items) {
            if (item != null) {
                System.out.println(item.printLabel());
            }
        }
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        System.out.println(p.printLabel());

        Invoice i = new Invoice("INV-42");
        System.out.println(i.printLabel());

        printAll(new Printable[]{ p, i });
    }
}
