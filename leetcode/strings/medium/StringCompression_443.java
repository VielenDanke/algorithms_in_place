package leetcode.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class StringCompression_443 {

    static class Solution {

        public int compress(char[] chars) {
            int idx = 0, n = chars.length, resultIdx = 0;

            while (idx < n) {
                char current = chars[idx];
                int counter = 0;
                while (idx < n && chars[idx] == current) {
                    idx++;
                    counter++;
                }
                chars[resultIdx++] = current;
                if (counter != 1) {
                    for (char c : Integer.toString(counter).toCharArray()) {
                        chars[resultIdx++] = c;
                    }
                }
            }
            return resultIdx;
        }
    }

    static class SolutionBruteForce {
        private List<Character> list;
        private char[] chars;

        public int compress(char[] chars) {
            this.list = new ArrayList<>();
            this.chars = chars;

            int n = chars.length, counter = 1;

            for (int i = 0; i + 1 < n; i++) {
                if (chars[i] != chars[i + 1]) {
                    process(counter, i);
                    counter = 1;
                } else {
                    counter++;
                }
            }
            process(counter, n - 1);
            for (int i = 0; i < list.size(); i++) {
                chars[i] = list.get(i);
            }
            return list.size();
        }

        private void process(int counter, int i) {
            list.add(chars[i]);
            if (counter > 1) {
                String parsedCounter = String.valueOf(counter);

                for (char c : parsedCounter.toCharArray()) {
                    list.add(c);
                }
            }
        }
    }
}
