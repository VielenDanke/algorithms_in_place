package leetcode.strings.easy.java_solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RepeatedSubstringPattern_459 {

    static class SolutionShort {

        public boolean repeatedSubstringPattern(String s) {
            String str = s + s;
            return str.substring(1, str.length() - 1).contains(s);
        }
    }

    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();

            if (n <= 1) return false;

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                builder.append(s.charAt(i));

                if (n % builder.length() == 0 && builder.toString().repeat(n / builder.length()).equals(s)) {
                    return true;
                }
                if (builder.length() >= n / 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
