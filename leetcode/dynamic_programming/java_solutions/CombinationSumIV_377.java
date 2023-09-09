package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;

public class CombinationSumIV_377 {

    static class Solution {
        private Integer[] cache;

        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            cache = new Integer[target + 1];
            return backtrack(nums, target, 0);
        }

        private int backtrack(int[] nums, int target, int sum) {
            if (sum == target) {
                return 1;
            }
            if (cache[sum] != null) return cache[sum];
            int result = 0;
            for (int num : nums) {
                if (sum + num <= target) {
                    result += backtrack(nums, target, sum + num);
                } else {
                    break;
                }
            }
            cache[sum] = result;
            return result;
        }
    }
}
