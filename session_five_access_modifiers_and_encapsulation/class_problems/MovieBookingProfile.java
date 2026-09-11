public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otpHash;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp != null && !otp.trim().isEmpty()) {
            this.otpHash = "TRANSFORMED_" + otp.hashCode();
        }
    }

    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName());

        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());

        p.setOtp("4471");
    }
}
