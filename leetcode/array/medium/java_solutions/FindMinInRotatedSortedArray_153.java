package leetcode.array.medium.java_solutions;

public class FindMinInRotatedSortedArray_153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            }
            if (nums[left] <= nums[middle] && nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return nums[left];
    }

    /*
    O(N) time | O(1) space
     */
    public int findMinIterative(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int val : nums) {
            if (min > val) {
                min = val;
            }
        }
        return min;
    }
}
