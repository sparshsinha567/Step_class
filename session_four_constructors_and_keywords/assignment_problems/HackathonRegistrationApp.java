public class HackathonRegistrationApp {

    public static class Participant {
        private String name;
        private String teamName;
        private boolean registered;

        public Participant(String name, String teamName) {
            if (name == null || teamName == null) {
                throw new NullPointerException("Name and Team Name cannot be null.");
            }
            this.name = name.trim();
            this.teamName = teamName.trim();
            this.registered = true;
        }

        public Participant(String name) {
            this(name, "Unassigned");
        }

        public void printStatus() {
            System.out.printf("%s | %s | Registered: %b\n", this.name, this.teamName, this.registered);
        }

        public String getName() {
            return this.name;
        }

        public String getTeamName() {
            return this.teamName;
        }

        public boolean isRegistered() {
            return this.registered;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("    Hackathon Registration Desk - Constructor Chaining       ");
        System.out.println("=============================================================");

        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        Participant[] participants = new Participant[names.length];

        for (int i = 0; i < names.length; i++) {
            if (teamNames[i] == null || teamNames[i].trim().isEmpty()) {
                participants[i] = new Participant(names[i]);
            } else {
                participants[i] = new Participant(names[i], teamNames[i]);
            }

            participants[i].printStatus();
        }
    }
}
