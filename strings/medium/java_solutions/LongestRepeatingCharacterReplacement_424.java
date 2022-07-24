package strings.medium.java_solutions;

public class LongestRepeatingCharacterReplacement_424 {

    private static class Solution {

        public int characterReplacement(String s, int k) {
            int N = s.length();
            int[] alph = new int[26];

            int max = 0, windowStart = 0, maxCount = 0;

            for (int windowEnd = 0; windowEnd < N; windowEnd++) {
                alph[s.charAt(windowEnd) - 'A']++;

                maxCount = Math.max(maxCount, alph[s.charAt(windowEnd) - 'A']);

                while (windowEnd - windowStart - maxCount + 1 > k) {
                    alph[s.charAt(windowStart) - 'A']--;
                    windowStart++;
                }
                max = Math.max(max, windowEnd - windowStart + 1);
            }
            return max;
        }
    }

    private static class SolutionTwo {

        public int characterReplacement(String s, int k) {
            int max = 0;
            int maxCount = 0;
            int[] count = new int[128];

            for (int i = 0; i < s.length(); i++) {
                maxCount = Math.max(maxCount, ++count[s.charAt(i)]);
                if (max - maxCount < k) {
                    max++;
                } else {
                    count[s.charAt(i - max)]--;
                }
            }
            return max;
        }
    }
}
