package array.medium.java_solutions;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {

    // [1,3,2,2,2]
    // [1,2,3,4]
    // [2,6,4,8,10,9,15]
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0 || n == 1) return 0;

        int max = nums[0], min = nums[n - 1], start = -1, end = -2;

        for (int i = 0; i < n; i++) {
            // iterate from start, find each time max
            max = Math.max(nums[i], max);
            // iterate from end, find each time min
            min = Math.min(nums[n - 1 - i], min);
            if (max > nums[i]) end = i; // if current max > nums[i] - remember the position
            if (min < nums[n - 1 - i]) start = n - 1 - i; // if current min < nums[n - 1 - i] - remember position
        }
        return end - start + 1;
    }

    public int findUnsortedSubarraySecond(int[] nums) {
        // sort and check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] clonedNums = nums.clone();

        Arrays.sort(clonedNums);

        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (clonedNums[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (clonedNums[i] != nums[i]) {
                right = i;
                break;
            }
        }
        if (left == Integer.MIN_VALUE && right == Integer.MAX_VALUE) {
            return 0;
        }
        return right - left + 1;
    }
}
