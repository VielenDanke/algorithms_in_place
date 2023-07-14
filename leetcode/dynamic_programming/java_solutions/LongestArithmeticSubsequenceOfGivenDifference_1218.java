package leetcode.dynamic_programming.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference_1218 {

    static class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            Map<Integer, Integer> dp = new HashMap<>();

            int ans = 1;

            for (int num : arr) {
                if (dp.containsKey(num - difference)) {
                    dp.put(num, dp.get(num - difference) + 1);
                } else {
                    dp.put(num, 1);
                }
                ans = Math.max(ans, dp.get(num));
            }
            return ans;
        }
    }

    static class SolutionBruteForce {
        public int longestSubsequence(int[] arr, int difference) {
            int max = Integer.MIN_VALUE;
            Integer[] cache = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, backtrack(arr, i + 1, difference, arr[i], cache));
            }
            return max;
        }

        private int backtrack(int[] arr, int start, int difference, int prev, Integer[] cache) {
            if (start >= arr.length) {
                return 1;
            }
            if (cache[start] != null) {
                return cache[start];
            }
            for (int i = start; i < arr.length; i++) {
                if (prev + difference == arr[i]) {
                    return cache[start] = backtrack(arr, i + 1, difference, arr[i], cache) + 1;
                }
            }
            return cache[start] = 1;
        }
    }
}
