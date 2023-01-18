package leetcode.array.medium.java_solutions;

public class MaximumSumCircularSubarray_918 {

    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
            for (int num : nums) {
                curMax = Math.max(curMax + num, num);
                maxSum = Math.max(maxSum, curMax);
                curMin = Math.min(curMin + num, num);
                minSum = Math.min(minSum, curMin);
                total += num;
            }
            return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
        }
    }

    static class SolutionKadane {
        public int maxSubarraySumCircular(int[] nums) {
            int nonCircularSum = kadaneMaxSum(nums), total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
                nums[i] = -nums[i];
            }
            int circularSum = total + kadaneMaxSum(nums);
            if (circularSum == 0) return nonCircularSum;
            return Math.max(nonCircularSum, circularSum);
        }

        private int kadaneMaxSum(int[] nums) {
            int maxSum = nums[0], tempSum = nums[0];

            for (int num : nums) {
                if (tempSum < 0) {
                    tempSum = 0;
                }
                tempSum += num;
                maxSum = Math.max(maxSum, tempSum);
            }
            return maxSum;
        }
    }
}
