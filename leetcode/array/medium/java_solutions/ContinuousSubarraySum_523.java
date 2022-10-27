package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {

    static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sum %= k;
                if (sum == 0 && i > 0) {
                    return true;
                }
                if (map.containsKey(sum) && i - map.get(sum) > 1) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return false;
        }
    }

    static class SolutionPrefixSum {
        /*
        1. Assume that if sum % k == 0 means we have a number
        2. We need to pre-calculate sums and apply for each sum -> sum % k == 0
         */
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;

            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];

            for (int i = 1; i < n; i++) {
                prefixSum[i] += prefixSum[i - 1] + nums[i];
            }
            for (int i = 1; i < n; i++) {
                if (prefixSum[i] % k == 0) {
                    return true;
                }
                for (int j = 0; j < i - 1; j++) {
                    if ((prefixSum[i] - prefixSum[j]) % k == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class SolutionBruteForce {
        /*
        1. iterate over an elements
        2. inner cycle with condition such as sum % n == k
        */

        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                int sum = nums[i];
                for (int j = i + 1; j < n; j++) {
                    sum += nums[j];
                    if (sum % k == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
