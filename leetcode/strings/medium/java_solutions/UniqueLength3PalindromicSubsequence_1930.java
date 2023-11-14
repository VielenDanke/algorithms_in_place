package leetcode.strings.medium.java_solutions;

public class UniqueLength3PalindromicSubsequence_1930 {

    static class Solution {
        public int countPalindromicSubsequence(String s) {
            // if we have first letter defined
            // the last letter should be the same
            // in the middle could be any unique letter
            int result = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                int leftIdx = s.indexOf(c);
                int rightIdx = s.lastIndexOf(c);

                if (leftIdx != -1 && rightIdx != -1 && rightIdx > leftIdx) {
                    int[] alph = new int[26];
                    for (int i = leftIdx + 1; i < rightIdx; i++) {
                        char sub = s.charAt(i);
                        if (alph[sub - 'a'] > 0) {
                            continue;
                        }
                        alph[sub - 'a'] = 1;
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
