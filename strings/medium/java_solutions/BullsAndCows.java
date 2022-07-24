package strings.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    /*
    Python:

    def getHint(self, secret: str, guess: str) -> str:
        bulls = sum(map(operator.eq, secret, guess))
        both = sum(min(secret.count(x), guess.count(x)) for x in set(guess))
        return f"{bulls}A{both - bulls}B"
     */

    private static class Solution {

        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;
            int[] numbers = new int[10];
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls++;
                } else {
                    if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                    if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

    private static class SolutionClear {

        public String getHint(String s, String g) {
            Map<Character, Integer> left = new HashMap<>();
            Map<Character, Integer> right = new HashMap<>();

            int bulls = 0, both = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == g.charAt(i)) bulls++;
                if (left.containsKey(s.charAt(i))) {
                    left.put(s.charAt(i), left.get(s.charAt(i)) + 1);
                } else {
                    left.put(s.charAt(i), 1);
                }
                if (right.containsKey(g.charAt(i))) {
                    right.put(g.charAt(i), right.get(g.charAt(i)) + 1);
                } else {
                    right.put(g.charAt(i), 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : right.entrySet()) {
                if (left.containsKey(entry.getKey())) {
                    both += Math.min(left.get(entry.getKey()), entry.getValue());
                }
            }
            return bulls + "A" + (both - bulls) + "B";
        }
    }
}
