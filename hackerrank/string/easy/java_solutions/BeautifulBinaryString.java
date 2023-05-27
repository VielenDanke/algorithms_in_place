package hackerrank.string.easy.java_solutions;

public class BeautifulBinaryString {

    static class Solution {

        private static int min;

        public static int beautifulBinaryString(String b) {
            // Write your code here
            min = Integer.MAX_VALUE;

            char[] c = b.toCharArray();

            backtrack(c, 0, 0);

            return min;
        }

        private static void backtrack(char[] c, int idx, int replacement) {
            if (idx >= c.length) {
                if (!new String(c).contains("010")) {
                    min = Math.min(min, replacement);
                }
                return;
            }
            if (idx != 0 && idx != c.length - 1 && c[idx - 1] == c[idx + 1] && c[idx - 1] == '0' && c[idx] == '1') {
                c[idx] = '0';
                backtrack(c, idx + 1, replacement + 1);
                c[idx] = '1';
                c[idx + 1] = '1';
                backtrack(c, idx + 1, replacement + 1);
                c[idx + 1] = '0';
            } else {
                backtrack(c, idx + 1, replacement);
            }
        }
    }

    static class SolutionBruteForce {
        private static int min;

        public static int beautifulBinaryString(String b) {
            // Write your code here
            min = Integer.MAX_VALUE;

            char[] c = b.toCharArray();

            backtrack(c, 0, 0);

            return min;
        }

        private static void backtrack(char[] c, int idx, int replacement) {
            if (idx >= c.length) {
                if (!new String(c).contains("010")) {
                    min = Math.min(min, replacement);
                }
                return;
            }
            if (c[idx] == '1') {
                c[idx] = '0';
            } else {
                c[idx] = '1';
            }
            backtrack(c, idx + 1, replacement + 1);
            if (c[idx] == '1') {
                c[idx] = '0';
            } else {
                c[idx] = '1';
            }
            backtrack(c, idx + 1, replacement);
        }
    }
}
