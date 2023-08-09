package leetcode.binary_search.medium;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs_2616 {

    static class Solution {
        public int minimizeMax(int[] nums, int p) {
            int n = nums.length;

            Arrays.sort(nums);

            int left = 0, right = nums[n - 1] - nums[0];

            while (left < right) {
                int middle = left + (right - left) / 2;
                if (isAbleToFormPairs(nums, middle, p)) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }

        private boolean isAbleToFormPairs(int[] nums, int middle, int p) {
            int count = 0;
            int idx = 0;

            while (idx < nums.length - 1 && count < p) {
                if (nums[idx + 1] - nums[idx] <= middle) {
                    count++;
                    idx += 2;
                } else {
                    idx++;
                }
            }
            return count >= p;
        }
    }
}
