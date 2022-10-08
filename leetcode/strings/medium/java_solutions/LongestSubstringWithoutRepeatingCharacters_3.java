package leetcode.strings.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();

        int left = 0, right = 1, max = 0;

        set.add(s.charAt(left));

        while (right < s.length()) {
            char currentRight = s.charAt(right);
            if (set.contains(currentRight)) {
                max = Math.max(set.size(), max);
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(currentRight);
                right++;
            }
        }
        return Math.max(set.size(), max);
    }
}
