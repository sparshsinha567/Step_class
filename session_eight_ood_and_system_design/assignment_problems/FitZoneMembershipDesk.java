import java.util.Objects;

// Implement: The FitZone Membership Desk
public class FitZoneMembershipDesk {

    public enum MembershipStatus {
        ACTIVE, FROZEN, EXPIRED
    }

    public interface MembershipPlan {
        String getPlanName();
        int getDurationMonths();
        double calculateFee();
    }

    public static abstract class AbstractMembershipPlan implements MembershipPlan {
        public static final double BASE_MONTHLY_RATE = 1000.00;
        private final String planName;
        private final int durationMonths;
        private final double discountRate;

        public AbstractMembershipPlan(String planName, int durationMonths, double discountRate) {
            this.planName = Objects.requireNonNull(planName).trim();
            this.durationMonths = durationMonths;
            this.discountRate = discountRate;
        }

        @Override
        public String getPlanName() {
            return planName;
        }

        @Override
        public int getDurationMonths() {
            return durationMonths;
        }

        @Override
        public double calculateFee() {
            return (BASE_MONTHLY_RATE * durationMonths) * (1.0 - discountRate);
        }
    }

    public static class MonthlyPlan extends AbstractMembershipPlan {
        public MonthlyPlan() {
            super("Monthly", 1, 0.0);
        }
    }

    public static class QuarterlyPlan extends AbstractMembershipPlan {
        public QuarterlyPlan() {
            super("Quarterly", 3, 0.10);
        }
    }

    public static class AnnualPlan extends AbstractMembershipPlan {
        public AnnualPlan() {
            super("Annual", 12, 0.25);
        }
    }

    public static class HalfYearlyPlan extends AbstractMembershipPlan {
        public HalfYearlyPlan() {
            super("Half-Yearly", 6, 0.15);
        }
    }

    public static class Member {
        private final String name;

        public Member(String name) {
            this.name = Objects.requireNonNull(name).trim();
        }

        public String getName() {
            return name;
        }
    }

    public static class Membership {
        private final Member member;
        private final MembershipPlan plan;
        private final double fee;
        private MembershipStatus status;

        public Membership(Member member, MembershipPlan plan) {
            this.member = Objects.requireNonNull(member);
            this.plan = Objects.requireNonNull(plan);
            this.fee = plan.calculateFee();
            this.status = MembershipStatus.ACTIVE;
            System.out.printf("%s membership created for %s. Fee: ₹%,.2f. Status: Active.%n",
                    plan.getPlanName(), member.getName(), fee);
        }

        public Member getMember() {
            return member;
        }

        public MembershipPlan getPlan() {
            return plan;
        }

        public double getFee() {
            return fee;
        }

        public MembershipStatus getStatus() {
            return status;
        }

        public boolean checkIn() {
            if (this.status == MembershipStatus.ACTIVE) {
                System.out.println(member.getName() + " checked in successfully.");
                return true;
            } else {
                String capitalized = this.status.name().charAt(0) + this.status.name().substring(1).toLowerCase();
                System.out.printf("Check-in denied: %s's membership is %s.%n", member.getName(), capitalized);
                return false;
            }
        }

        public boolean freeze() {
            if (this.status == MembershipStatus.EXPIRED) {
                System.out.println("Cannot freeze an Expired membership.");
                return false;
            }
            if (this.status == MembershipStatus.FROZEN) {
                System.out.println(member.getName() + "'s membership is already Frozen.");
                return false;
            }
            this.status = MembershipStatus.FROZEN;
            System.out.println(member.getName() + "'s membership frozen. Status: Frozen.");
            return true;
        }

        public boolean unfreeze() {
            if (this.status == MembershipStatus.EXPIRED) {
                System.out.println("Cannot unfreeze an Expired membership.");
                return false;
            }
            if (this.status == MembershipStatus.ACTIVE) {
                System.out.println(member.getName() + "'s membership is already Active.");
                return false;
            }
            this.status = MembershipStatus.ACTIVE;
            System.out.println(member.getName() + "'s membership unfrozen. Status: Active.");
            return true;
        }

        public void expire() {
            this.status = MembershipStatus.EXPIRED;
            System.out.println(member.getName() + "'s membership expired. Status: Expired.");
        }
    }

    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        MembershipPlan quarterly = new QuarterlyPlan();
        MembershipPlan monthly = new MonthlyPlan();

        Membership ashaMembership = new Membership(asha, quarterly);
        Membership raviMembership = new Membership(ravi, monthly);

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();

        raviMembership.expire();
        raviMembership.freeze();
    }
}
