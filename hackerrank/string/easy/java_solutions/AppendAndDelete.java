package hackerrank.string.easy.java_solutions;

public class AppendAndDelete {

    // https://www.hackerrank.com/challenges/append-and-delete/problem

    static class Solution {
        public static String appendAndDelete(String s, String t, int k) {
            int n = s.length(), m = t.length();
            if (n + m <= k) return "Yes";
            int idx = 0;
            while (idx < Math.min(n, m) && s.charAt(idx) == t.charAt(idx)) {
                idx++;
            }
            int res = (n - idx) + (m - idx);
            if (res < k) {
                while (res < k) {
                    res += 2;
                }
                return res == k ? "Yes" : "No";
            } else if (res == k) {
                return "Yes";
            } else {
                return "No";
            }
        }
    }
}
