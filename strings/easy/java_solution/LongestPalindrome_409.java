package strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

    private static class Solution {

        public int longestPalindrome(String s) {
            Map<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (m.containsKey(current)) {
                    m.put(current, m.get(current) + 1);
                } else {
                    m.put(current, 1);
                }
            }
            int result = 0, add = 0;
            for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                if (entry.getValue() % 2 == 0) {
                    result += entry.getValue();
                } else {
                    add = 1;
                    result += entry.getValue() - 1;
                }
            }
            return result + add;
        }
    }
}
