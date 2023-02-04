package leetcode.strings.medium.java_solutions;

public class PermutationInString_567 {

    static class Solution {

        private static final int ALPH_NUMBER = 26;

        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            if (n > m) return false;

            int[] alph = new int[ALPH_NUMBER];
            int[] sub = new int[ALPH_NUMBER];

            for (char c : s1.toCharArray()) sub[c - 'a']++;

            for (int i = 0; i < n; i++) alph[s2.charAt(i) - 'a']++;

            if (isPermutationsEqual(sub, alph)) return true;

            for (int i = n; i < m; i++) {
                alph[s2.charAt(i - n) - 'a']--;
                alph[s2.charAt(i) - 'a']++;
                if (isPermutationsEqual(sub, alph)) return true;
            }
            return false;
        }

        private boolean isPermutationsEqual(int[] left, int[] right) {
            for (int i = 0; i < ALPH_NUMBER; i++) {
                if (left[i] != right[i]) return false;
            }
            return true;
        }
    }
}
