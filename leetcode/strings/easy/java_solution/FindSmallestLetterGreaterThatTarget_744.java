package leetcode.strings.easy.java_solution;

public class FindSmallestLetterGreaterThatTarget_744 {

    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int[] alph = new int[26];

            for (char c : letters) {
                alph[c - 'a']++;
            }
            for (int i = (target - 'a') + 1; i < 26; i++) {
                if (alph[i] > 0) {
                    return (char) (i + 'a');
                }
            }
            return letters[0];
        }
    }
}
