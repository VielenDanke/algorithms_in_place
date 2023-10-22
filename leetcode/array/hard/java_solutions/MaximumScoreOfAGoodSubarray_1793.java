package leetcode.array.hard.java_solutions;

public class MaximumScoreOfAGoodSubarray_1793 {

    static class Solution {
        public int maximumScore(int[] nums, int k) {
            int left = k, right = k;
            int min = nums[k];
            int max = min;

            while (left > 0 || right < nums.length - 1) {
                if (left == 0 || (right < nums.length - 1 && nums[right + 1] > nums[left - 1])) {
                    right++;
                } else {
                    left--;
                }
                min = Math.min(min, Math.min(nums[left], nums[right]));
                max = Math.max(max, min * (right - left + 1));
            }
            return max;
        }
    }
}
