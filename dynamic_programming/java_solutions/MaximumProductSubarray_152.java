package dynamic_programming.java_solutions;

public class MaximumProductSubarray_152 {

    private static class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 1) return nums[0];
            int dpMax = nums[0];
            int dpMin = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int k = dpMax * nums[i];
                int m = dpMin * nums[i];
                dpMax = Math.max(nums[i], Math.max(k, m));
                dpMin = Math.min(nums[i], Math.min(k, m));

                max = Math.max(dpMax, max);
            }
            return max;
        }
    }

    private static class SolutionShorter {

        public int maxProduct(int[] nums) {
            int n = nums.length, res = nums[0], left = 0, right = 0;
            for (int i = 0; i < n; i++) {
                left = (left == 0 ? 1 : left) * nums[i];
                right = (right == 0 ? 1 : right) * nums[n - 1 - i];
                res = Math.max(res, Math.max(left, right));
            }
            return res;
        }
    }
}
