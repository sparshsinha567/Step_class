public class PackageDropOffLog {

    public static abstract class DeliveryNote {
        public DeliveryNote() {
        }

        public abstract String confirmDelivery();

        public String confirmDelivery(String signature) {
            if (signature == null || signature.trim().isEmpty()) {
                return confirmDelivery();
            }
            return confirmDelivery() + ", signed by " + signature.trim();
        }
    }

    public static class ParcelNote extends DeliveryNote {
        private final String trackingId;

        public ParcelNote(String trackingId) {
            if (trackingId == null || trackingId.trim().isEmpty()) {
                throw new IllegalArgumentException("trackingId is never blank");
            }
            this.trackingId = trackingId.trim();
        }

        public String getTrackingId() {
            return this.trackingId;
        }

        @Override
        public String confirmDelivery() {
            return "Parcel " + this.trackingId + " delivered";
        }
    }

    public static class LetterNote extends DeliveryNote {
        private final String trackingId;

        public LetterNote(String trackingId) {
            if (trackingId == null || trackingId.trim().isEmpty()) {
                throw new IllegalArgumentException("trackingId is never blank");
            }
            this.trackingId = trackingId.trim();
        }

        public String getTrackingId() {
            return this.trackingId;
        }

        @Override
        public String confirmDelivery() {
            return "Letter " + this.trackingId + " delivered";
        }
    }

    public static void logAll(DeliveryNote[] notes) {
        if (notes == null) {
            return;
        }
        for (DeliveryNote note : notes) {
            if (note != null) {
                System.out.println(note.confirmDelivery());
            }
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;
        logAll(new DeliveryNote[]{ ref, new LetterNote("TRK-2") });
    }
}
