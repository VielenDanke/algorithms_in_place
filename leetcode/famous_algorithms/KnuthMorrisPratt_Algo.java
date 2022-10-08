package leetcode.famous_algorithms;

import java.util.Arrays;

public class KnuthMorrisPratt_Algo {

    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        // Write your code here.
        int[] pattern = buildPattern(substring);
        return isMatch(string, substring, pattern);
    }

    private static boolean isMatch(String string, String substring, int[] pattern) {
        int i = 0, j = 0;
        while (i + substring.length() - j <= string.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                if (j == substring.length() - 1) {
                    return true;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return false;
    }

    private static int[] buildPattern(String substring) {
        int N = substring.length();
        int[] pattern = new int[N];
        Arrays.fill(pattern, -1);
        int j = 0, i = 1;
        while (i < N) {
            if (substring.charAt(i) == substring.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }
}
