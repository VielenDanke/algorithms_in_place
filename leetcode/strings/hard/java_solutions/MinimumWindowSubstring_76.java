package leetcode.strings.hard.java_solutions;

public class MinimumWindowSubstring_76 {

    static class SolutionTwoPointers {
        private static final int AMOUNT_OF_LETTERS = 126;

        public String minWindow(String s, String t) {
            int[] sAlph = new int[AMOUNT_OF_LETTERS];
            int[] tAlph = new int[AMOUNT_OF_LETTERS];
            int n = s.length();
            int m = t.length();

            for (int i = 0; i < m; i++) {
                tAlph[t.charAt(i) - 'A']++;
            }
            int left = 0, right = 0;

            String min = "";
            int minLength = 1 << 30;

            while (right <= n) {
                while (left < right && isValid(sAlph, tAlph)) {
                    if (minLength > right - left) {
                        min = s.substring(left, right);
                        minLength = min.length();
                    }
                    sAlph[s.charAt(left++) - 'A']--;
                }
                if (right >= n) break;
                sAlph[s.charAt(right++) - 'A']++;
            }
            return min;
        }

        private boolean isValid(int[] sAlph, int[] tAlph) {
            for (int i = 0; i < AMOUNT_OF_LETTERS; i++) {
                if (tAlph[i] != 0 && sAlph[i] < tAlph[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class SolutionBruteForce {
        private static final int AMOUNT_OF_LETTERS = 126;

        public String minWindow(String s, String t) {
            int right = t.length();

            while (right <= s.length()) {
                for (int left = 0; left + right <= s.length(); left++) {
                    if (isIncluded(s, t, left, left + right)) {
                        return s.substring(left, left + right);
                    }
                }
                right++;
            }
            return "";
        }

        // right exclusive
        private boolean isIncluded(String s, String t, int left, int right) {
            int[] sAlph = new int[AMOUNT_OF_LETTERS];
            int[] tAlph = new int[AMOUNT_OF_LETTERS];

            for (int i = left; i < right; i++) {
                sAlph[s.charAt(i) - 'A']++;
            }
            for (int i = 0; i < t.length(); i++) {
                tAlph[t.charAt(i) - 'A']++;
            }
            for (int i = 0; i < AMOUNT_OF_LETTERS; i++) {
                if (tAlph[i] != 0 && tAlph[i] > sAlph[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
