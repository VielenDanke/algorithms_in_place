package leetcode.array.medium.java_solutions;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyGivenSumCondition_1498 {

    static class Solution {
        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            int result = 0, n = nums.length, left = 0, right = n - 1, mod = (int) 1e9 + 7;
            int[] powers = new int[n];
            powers[0] = 1;
            for (int i = 1; i < n; ++i) {
                powers[i] = powers[i - 1] * 2 % mod;
            }
            while (left <= right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    result = (result + powers[right - left++]) % mod;
                }
            }
            return result;
        }
    }
}
