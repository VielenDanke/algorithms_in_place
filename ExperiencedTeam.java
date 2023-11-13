import java.util.*;

public class ExperiencedTeam {

    private static final Map<String, Integer> TEAM = new TreeMap<>();
    private static final Map<String, Integer> PREVIOUS_EXP = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int timeFrame = Integer.parseInt(sc.next());
            if (!TEAM.containsKey(name)) {
                TEAM.put(name, timeFrame);
            } else {
                Integer incFrame = TEAM.remove(name);
                PREVIOUS_EXP.put(name, Math.max(PREVIOUS_EXP.getOrDefault(name, 0), timeFrame - incFrame));
            }
            int theMostExp = -1 << 30, sumExp = 0;
            String theMostExpName = null;
            for (Map.Entry<String, Integer> entry : TEAM.entrySet()) {
                int currentExperience = timeFrame - entry.getValue() + PREVIOUS_EXP.getOrDefault(entry.getKey(), 0);
                if (theMostExp < currentExperience) {
                    theMostExp = currentExperience;
                    theMostExpName = entry.getKey();
                }
                sumExp += currentExperience;
            }
            System.out.println(theMostExpName + " " + ((sumExp - theMostExp) - (theMostExp)));
        }
    }
}
