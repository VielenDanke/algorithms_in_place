package leetcode.strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern_290 {

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] listToMatch = s.split(" ");

            int n = listToMatch.length;

            if (n != pattern.length()) return false;

            Map<Object, Object> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if (!Objects.equals(map.putIfAbsent(pattern.charAt(i), i), map.putIfAbsent(listToMatch[i], i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
