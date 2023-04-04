package leetcode.strings.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString_2405 {

    static class Solution {
        public int partitionString(String s) {
            Set<Character> set = new HashSet<>();

            int n = s.length(), result = 0;

            for (int i = 0; i < n; i++) {
                if (set.contains(s.charAt(i))) {
                    set.clear();
                    result++;
                }
                set.add(s.charAt(i));
            }
            return set.isEmpty() ? result : result + 1;
        }
    }

    static class SolutionWithArray {
        public int partitionString(String s) {
            boolean[] letters = new boolean[26];

            int result = 0;

            for (char c : s.toCharArray()) {
                if (letters[c - 'a']) {
                    letters = new boolean[26];
                    result++;
                }
                letters[c - 'a'] = true;
            }
            for (boolean isExists : letters) {
                if (isExists) return result + 1;
            }
            return result;
        }
    }
}
