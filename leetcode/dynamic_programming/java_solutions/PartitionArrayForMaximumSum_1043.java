package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayForMaximumSum_1043 {

    static class SolutionMemo {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            Integer[] dp = new Integer[n + 1];
            return memo(arr, k, n, dp);
        }

        private int memo(int[] arr, int k, int start, Integer[] dp) {
            if (start == 0) return 0;
            if (dp[start] != null) return dp[start];

            int currentMax = 0, max = 0;

            for (int j = 1; j <= k && j <= start; j++) {
                currentMax = Math.max(currentMax, arr[start - j]);
                max = Math.max(max, memo(arr, k, start - j, dp) + currentMax * j);
            }
            return dp[start] = max;
        }
    }

    static class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int copyK = k + 1;

            int[] dp = new int[k + 1];
            Arrays.fill(dp, 0);

            for (int i = n - 1; i >= 0; i--) {
                int currMax = 0;
                int end = Math.min(n, i + k);

                for (int j = i; j < end; j++) {
                    currMax = Math.max(currMax, arr[j]);
                    dp[i % copyK] = Math.max(dp[i % copyK], dp[(j + 1) % copyK] + currMax * (j - i + 1));
                }
            }
            return dp[0];
        }
    }

    static class SolutionBruteForce {

        public int maxSumAfterPartitioning(int[] arr, int k) {
            List<Integer> l = new ArrayList<>();
            for (int n : arr) {
                l.add(n);
            }
            return backtrack(l, k, new ArrayList<>());
        }

        private int backtrack(List<Integer> arr, int k, List<List<Integer>> temp) {
            if (arr.isEmpty()) {
                int tempMax = 0;
                for (List<Integer> l : temp) {
                    tempMax += calculate(l);
                }
                return tempMax;
            }
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 1; j <= k && i + j <= arr.size(); j++) {
                    List<Integer> subArray = arr.subList(i, i+j);
                    temp.add(new ArrayList<>(subArray));
                    currentMax = Math.max(currentMax, backtrack(arr.subList(i+j, arr.size()), k, temp));
                    temp.remove(temp.size() - 1);
                }
            }
            return currentMax;
        }

        private int calculate(List<Integer> list) {
            int tempMax = Integer.MIN_VALUE;
            for (Integer l : list) {
                tempMax = Math.max(tempMax, l);
            }
            return tempMax * list.size();
        }
    }
}
