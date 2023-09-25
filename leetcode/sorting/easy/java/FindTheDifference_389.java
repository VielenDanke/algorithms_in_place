package leetcode.sorting.easy.java;

import java.util.Arrays;

public class FindTheDifference_389 {

    static class Solution {
        public char findTheDifference(String s, String t) {
            // if we reach the end - t[t.length() - 1]
            // if letters are not equal - letter t
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            Arrays.sort(ss);
            Arrays.sort(tt);

            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != tt[i]) {
                    return tt[i];
                }
            }
            return tt[tt.length - 1];
        }
    }
}
