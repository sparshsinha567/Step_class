public class GalleryDescriptionCards {

    public static abstract class ArtPiece {
        private static int counter = 1000;
        private final String pieceId;
        protected final String title;

        public ArtPiece(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("title is never blank");
            }
            this.title = title.trim();
            this.pieceId = "ART-" + (++counter);
        }

        public abstract String describe();

        public String getPieceId() {
            return this.pieceId;
        }

        public String getTitle() {
            return this.title;
        }
    }

    public static class Painting extends ArtPiece {
        public Painting(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Painting: " + this.title + ", framed on canvas";
        }
    }

    public static class Sculpture extends ArtPiece {
        public Sculpture(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Sculpture: " + this.title + ", carved from stone";
        }
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());

        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}
