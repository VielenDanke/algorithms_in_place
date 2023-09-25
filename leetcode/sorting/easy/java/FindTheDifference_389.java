package leetcode.sorting.easy.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    static class SolutionNoSort {
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> counterS = new HashMap<>();
            Map<Character, Integer> counterT = new HashMap<>();

            for (char c : s.toCharArray()) counterS.merge(c, 1, Integer::sum);
            for (char c : t.toCharArray()) counterT.merge(c, 1, Integer::sum);
            for (char c : s.toCharArray()) {
                if (!counterT.containsKey(c) || !counterS.get(c).equals(counterT.get(c))) {
                    return c;
                }
            }
            return t.charAt(t.length() - 1);
        }
    }
}
