package leetcode.strings.medium.java_solutions;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountNumberOfHomogenousSubstrings_1759 {

    static class Solution {

        private static final int MOD = (int) (1e9 + 7);

        public int countHomogenous(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            var result = 0L;
            var prev = s.charAt(0);
            var prevIdx = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != prev) {
                    prev = s.charAt(i);
                    var n = i - prevIdx;
                    prevIdx = i;
                    result += ((long) n * (n + 1)) / 2;
                }
            }
            var n = s.length() - prevIdx;
            result += ((long) n * (n + 1)) / 2;
            return (int) (result % MOD);
        }
    }
}
