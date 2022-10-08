package leetcode.strings.medium.java_solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CheckIfStringCanBreakAnotherString_1433 {

    static class SolutionSort {

        // Time complexity O(N * logN) where N - length of string
        public boolean checkIfCanBreak(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

            char[] left = s1.toCharArray();
            char[] right = s2.toCharArray();

            int n = s1.length();

            Arrays.sort(left);
            Arrays.sort(right);

            int idx = 0;

            while (left[idx] == right[idx]) {
                idx++;
            }
            boolean direction = left[idx] > right[idx];

            while (idx < n) {
                if (left[idx] != right[idx] && (left[idx] > right[idx]) != direction) {
                    return false;
                }
                idx++;
            }
            return true;
        }
    }

    static class SolutionBruteForce {
        // Time complexity O(N^2 + K) where N - length of permutations (Quite big), K - amount of permutations for string length
        public boolean checkIfCanBreak(String left, String right) {
        /*
        Idea (Brute Force):
        1. Find all permutations of left
        2. Find all permutations of right
        3. Run throug each permutation of left[j] and compare one by one with right[i]
        */
            List<String> permutationLeft = new LinkedList<>();
            List<String> permutationRight = new LinkedList<>();

            permute(permutationLeft, left.toCharArray(), 0);
            permute(permutationRight, right.toCharArray(), 0);

            for (String s1 : permutationLeft) {
                for (String s2 : permutationRight) {
                    boolean isFound = true;
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) < s2.charAt(i)) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) return true;
                }
            }
            return false;
        }

        public void permute(List<String> collector, char[] chars, int start) {
            if (start >= chars.length) {
                collector.add(String.valueOf(chars));
                return;
            }
            for (int i = start; i < chars.length; i++) {
                swap(chars, i, start);
                permute(collector, chars, start + 1);
                swap(chars, i, start);
            }
        }

        private void swap(char[] chars, int x, int y) {
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
    }
}
