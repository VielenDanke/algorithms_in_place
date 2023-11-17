package leetcode.sorting.medium.java_solutions;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray_1877 {

    static class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);

            int left = 0, right = nums.length - 1, max = 0;

            while (left < right) {
                max = Math.max(max, nums[left++] + nums[right--]);
            }
            return max;
        }
    }
}
