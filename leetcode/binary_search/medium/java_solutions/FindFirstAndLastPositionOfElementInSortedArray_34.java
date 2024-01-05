package leetcode.binary_search.medium.java_solutions;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1, -1};

            int idx = Arrays.binarySearch(nums, target);

            if (idx < 0) {
                return result;
            }
            int left = idx, right = idx;

            while (true) {
                if (left >= 0 && nums[left] == nums[idx]) {
                    result[0] = left--;
                } else if (right < nums.length && nums[right] == nums[idx]) {
                    result[1] = right++;
                } else {
                    break;
                }
            }
            return result;
        }
    }
}
