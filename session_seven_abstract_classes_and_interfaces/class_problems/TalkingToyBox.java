public class TalkingToyBox {

    public static abstract class Toy {
        private static int counter = 1000;
        private final String toyId;
        protected final String name;

        public Toy(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("name is never blank");
            }
            this.name = name.trim();
            this.toyId = "TOY-" + (++counter);
        }

        public abstract String makeSound();

        public String getToyId() {
            return this.toyId;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return this.name + ": Vroom vroom!";
        }
    }

    public static class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return this.name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
