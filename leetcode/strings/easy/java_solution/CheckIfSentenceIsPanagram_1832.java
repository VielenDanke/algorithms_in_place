package leetcode.strings.easy.java_solution;

public class CheckIfSentenceIsPanagram_1832 {

    static class SolutionBitwise {
        public boolean checkIfPangram(String sentence) {
            int seen = 0;
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                int ci = c - 'a';
                seen = seen | (1 << ci);
            }
            return seen == ((1 << 26) - 1);
        }
    }

    static class Solution {
        public boolean checkIfPangram(String sentence) {
            int[] letterCounter = new int[26];

            for (int i = 0; i < sentence.length(); i++)
                letterCounter[sentence.charAt(i) - 'a']++;
            for (int currentCount : letterCounter)
                if (currentCount == 0) return false;
            return true;
        }
    }
}
