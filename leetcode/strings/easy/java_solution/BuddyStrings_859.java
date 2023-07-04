package leetcode.strings.easy.java_solution;

import java.util.*;

public class BuddyStrings_859 {

    static class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) return false;
            if (s.equals(goal)) {
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
                return set.size() < s.length();
            }
            List<Integer> difference = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    difference.add(i);
                }
            }
            return difference.size() == 2 && s.charAt(difference.get(0)) == goal.charAt(difference.get(1)) && s.charAt(difference.get(1)) == goal.charAt(difference.get(0));
        }
    }

    static class SolutionNoList {

        public boolean buddyStrings(String s, String goal) {
            int n = s.length();
            if (n != goal.length()) return false;
            if (s.equals(goal)) {
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) set.add(c);
                return set.size() < n;
            }
            int i = 0, j = n - 1;

            while (i < j && s.charAt(i) == goal.charAt(i)) {
                i++;
            }
            while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
                j--;
            }
            if (i < j) {
                char[] sArr = s.toCharArray();
                char temp = sArr[i];
                sArr[i] = sArr[j];
                sArr[j] = temp;
                s = new String(sArr);
            }
            return s.equals(goal);
        }
    }
}
