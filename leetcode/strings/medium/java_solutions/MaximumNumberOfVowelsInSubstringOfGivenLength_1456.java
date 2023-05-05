package leetcode.strings.medium.java_solutions;

public class MaximumNumberOfVowelsInSubstringOfGivenLength_1456 {

    static class Solution {

        public int maxVowels(String s, int k) {
            boolean[] vowels = new boolean[26];

            vowels[0] = true;
            vowels['e' - 'a'] = true;
            vowels['i' - 'a'] = true;
            vowels['o' - 'a'] = true;
            vowels['u' - 'a'] = true;

            int vowelsCounter = 0;
            int max = 0;

            for (int i = 0; i < k; i++) {
                if (vowels[s.charAt(i) - 'a']) {
                    vowelsCounter++;
                }
            }
            max = Math.max(max, vowelsCounter);

            for (int i = k; i < s.length(); i++) {
                if (vowels[s.charAt(i - k) - 'a']) {
                    vowelsCounter--;
                }
                if (vowels[s.charAt(i) - 'a']) {
                    vowelsCounter++;
                }
                max = Math.max(max, vowelsCounter);
            }
            return max;
        }
    }
}
