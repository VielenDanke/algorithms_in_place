package leetcode.dynamic_programming.java_solutions;

public class RestoreTheArray_1416 {

    static class Solution {
        private static final long MOD = (long) 1e9 + 7;

        private int k;
        private Integer[] cache;

        public int numberOfArrays(String s, int k) {
            this.k = k;
            this.cache = new Integer[s.length()];
            return backtrack(s, 0);
        }

        private int backtrack(String s, int start) {
            if (start >= s.length()) return 1;
            if (s.charAt(start) == '0') return 0;
            if (cache[start] != null) return cache[start];
            long num = 0;
            int answer = 0;
            for (int i = start; i < s.length(); i++) {
                num = num * 10 + s.charAt(i) - '0';
                if (num > k) break;
                answer += backtrack(s, i + 1);
                answer %= MOD;
            }
            return cache[start] = answer;
        }
    }
}
