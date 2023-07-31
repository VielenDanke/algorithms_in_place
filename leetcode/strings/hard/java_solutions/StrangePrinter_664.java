package leetcode.strings.hard.java_solutions;

public class StrangePrinter_664 {

    static class Solution {
        private Integer[][] cache;
        private String toSearch;

        public int strangePrinter(String s) {
            StringBuilder builder = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (builder.isEmpty() || builder.charAt(builder.length() - 1) != c) {
                    builder.append(c);
                }
            }
            this.cache = new Integer[builder.length()][builder.length()];
            this.toSearch = builder.toString();
            return backtrack(0, toSearch.length() - 1);
        }

        private int backtrack(int left, int right) {
            if (left < 0 || right < 0 || left > right) {
                return 0;
            }
            if (cache[left][right] != null) {
                return cache[left][right];
            }
            int temp = backtrack(left, right - 1) + 1;

            for (int i = left; i < right; i++) {
                if (toSearch.charAt(i) == toSearch.charAt(right)) {
                    temp = Math.min(temp, backtrack(left, i - 1) + backtrack(i, right - 1));
                }
            }
            return cache[left][right] = temp;
        }
    }
}
