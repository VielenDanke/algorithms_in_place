package leetcode.array.medium.java_solutions;

public class LongestSubarrayOfOnesAfterDeletingOneElement_1493 {

    static class Solution {
        public int longestSubarray(int[] nums) {
            int left = 0, right = 0, n = nums.length, max = Integer.MIN_VALUE, deletions = 0;

            while (right < n) {
                if (nums[right] == 0) {
                    deletions++;
                    if (deletions >= 2) {
                        max = Math.max(max, right - left - 1);
                        while (deletions >= 2 && left < right) {
                            if (nums[left] == 0) {
                                deletions--;
                            }
                            left++;
                        }
                    }
                }
                right++;
            }
            return Math.max(max, right - left - 1);
        }
    }
}
