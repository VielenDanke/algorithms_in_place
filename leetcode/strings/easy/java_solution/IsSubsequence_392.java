package leetcode.strings.easy.java_solution;

public class IsSubsequence_392 {

    private static class Solution {

        public boolean isSubsequence(String s, String t) {
            int N = t.length(), M = s.length();
            if (M > N) return false;
            if (M == 0) return true;

            int left = 0;

            for (int i = 0; i < N; i++) {
                if (s.charAt(left) == t.charAt(i)) left++;
                if (left == M) return true;
            }
            return false;
        }
    }
}
