public class SkylineDeliveryFleet {

    public static abstract class Drone {
        public Drone() {
        }

        public abstract String fly();
    }

    public interface Trackable {
        String getLocation();
    }

    public static class DeliveryDrone extends Drone implements Trackable {
        private final String id;

        public DeliveryDrone(String id) {
            super();
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("id is never blank");
            }
            this.id = id.trim();
        }

        public String getId() {
            return this.id;
        }

        @Override
        public String fly() {
            return "Delivery drone " + this.id + " in flight";
        }

        @Override
        public String getLocation() {
            return this.id + " at Sector 4";
        }
    }

    public static class ScoutDrone extends Drone {
        private final String id;

        public ScoutDrone(String id) {
            super();
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("id is never blank");
            }
            this.id = id.trim();
        }

        public String getId() {
            return this.id;
        }

        @Override
        public String fly() {
            return "Scout drone " + this.id + " scouting area";
        }
    }

    public static class GroundRobot implements Trackable {
        private final String id;

        public GroundRobot(String id) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("id is never blank");
            }
            this.id = id.trim();
        }

        public String getId() {
            return this.id;
        }

        @Override
        public String getLocation() {
            return this.id + " at Sector 4";
        }
    }

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable trackable = (Trackable) o;
            return trackable.getLocation();
        }
        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        System.out.println(getLocationIfTrackable(d));

        ScoutDrone s = new ScoutDrone("SC-1");
        System.out.println(getLocationIfTrackable(s));

        GroundRobot g = new GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(g));
    }
}
