package leetcode.strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar_387 {

    private static class Solution {

        public int firstUniqChar(String s) {
            Map<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (m.containsKey(current)) {
                    m.put(current, m.get(current) + 1);
                } else {
                    m.put(current, 1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (m.get(current) == 1) return i;
            }
            return -1;
        }
    }

    private static class SolutionIndexOf {

        public int firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (s.lastIndexOf(current) == s.indexOf(current)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
