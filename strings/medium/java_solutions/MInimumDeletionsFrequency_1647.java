package strings.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class MInimumDeletionsFrequency_1647 {

    // Time O(N) | Space O(1)

    public int minDeletions(String s) {
        int alphLowerLength = 26;
        int[] alph = new int[alphLowerLength];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < alphLowerLength; i++) {
            while (alph[i] > 0 && !set.add(alph[i])) {
                alph[i]--;
                counter++;
            }
        }
        return counter;
    }
}
