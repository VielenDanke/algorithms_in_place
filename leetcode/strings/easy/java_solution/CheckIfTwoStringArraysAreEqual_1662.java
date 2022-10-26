package leetcode.strings.easy.java_solution;

public class CheckIfTwoStringArraysAreEqual_1662 {

    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String word2) {
            return String.join("", word1).equals(String.join("", word2));
        }
    }

    static class SolutionBruteForce {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();

            for (String str : word1) left.append(str);
            for (String str : word2) right.append(str);

            if (left.length() != right.length()) return false;

            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) return false;
            }
            return true;
        }
    }
}
