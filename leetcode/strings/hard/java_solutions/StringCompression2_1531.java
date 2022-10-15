package leetcode.strings.hard.java_solutions;

public class StringCompression2_1531 {

    static class Solution {
        public int getLengthOfOptimalCompression(String s, int k) {
        /*
        1. delete letters and stop delete when k == 0
        2. when we deleted k characters - do encoding and extract length of encoded string
        3. check if length is less than current min, if yes - replace min with current length
        */
            return backtrack(s.toCharArray(), 0, k);
        }

        private int backtrack(char[] s, int start, int k) {
            if (k == 0) {
                return encode(s).length();
            }
            int min = 1 << 30;
            for (int i = start; i < s.length; i++) {
                char toReturn = s[i];
                s[i] = '$';
                min = Math.min(min, backtrack(s, i + 1, k - 1));
                s[i] = toReturn;
            }
            return min;
        }

        private StringBuilder encode(char[] source) {
            StringBuilder dest = new StringBuilder();
            StringBuilder filter = new StringBuilder();

            for (char c : source) {
                if (c != '$') {
                    filter.append(c);
                }
            }
            for (int i = 0; i < filter.length(); i++) {
                int runLength = 1;
                while (i + 1 < filter.length() && filter.charAt(i) == filter.charAt(i + 1)) {
                    runLength++;
                    i++;
                }
                dest.append(filter.charAt(i));
                if (runLength > 1) dest.append(runLength);
            }
            return dest;
        }
    }
}
