package strings.easy.java_solution;

public class LongestCommonPrefix_14 {

    private static class Solution {

        public String longestCommonPrefix(String[] strs) {
            String lowest = null;

            for (String s : strs) {
                if (lowest == null || lowest.length() > s.length()) {
                    lowest = s;
                }
            }
            for (String s : strs) {
                if (!s.startsWith(lowest)) {
                    for (int i = 0; i < lowest.length(); i++) {
                        if (s.charAt(i) != lowest.charAt(i)) {
                            lowest = s.substring(0, i);
                        }
                    }
                }
            }
            return lowest;
        }
    }
}
