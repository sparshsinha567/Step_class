import java.util.Arrays;

/**
 * Problem 2: The Hackathon Registration Desk (Sorting Algorithms)
 * 
 * TASK:
 * Teams register for the hackathon one by one. Each Team has a name and a size.
 * The organisers want the list ordered by team size, smallest first, but teams
 * of the same size must stay in the order in which they registered.
 * Implement void sortTeams(Team[] teams) that sorts the array in place by shifting
 * larger teams one place to the right and dropping each team into the gap,
 * which keeps equal sizes in order.
 * 
 * COMPLEXITY & CHARACTERISTICS:
 * - Time Complexity:
 *   - Best Case: O(n) when teams are already ordered by size (1 comparison per key).
 *   - Worst Case: O(n^2) when teams are listed in descending order of size.
 *   - Average Case: O(n^2).
 * - Auxiliary Space Complexity: O(1) in-place sorting.
 * - Stability: Stable. We only shift elements while teams[j].size > key.size.
 *   Strict inequality (>) ensures that teams with identical sizes preserve their
 *   original registration sequence.
 */
class Team {
    String name;
    int size;

    public Team(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "(" + size + ")";
    }
}

public class HackathonRegistrationDesk {

    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }
        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;
            // Shift elements of teams[0..i-1] that are strictly greater than key.size
            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Team[] teams = {
            new Team("Pixel", 4),
            new Team("Byte", 2),
            new Team("Nova", 4),
            new Team("Echo", 3),
            new Team("Atom", 2)
        };

        System.out.println("Before Sorting: " + Arrays.toString(teams));
        sortTeams(teams);
        System.out.println("After Sorting:  " + Arrays.toString(teams));
        // Expected: [Byte(2), Atom(2), Echo(3), Pixel(4), Nova(4)]
    }
}
