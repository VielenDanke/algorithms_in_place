package leetcode.dynamic_programming.java_solutions;

public class ArithmeticSlices_413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        for (int i = 2, prev = 0; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev++;
                result += prev;
            } else {
                prev = 0;
            }
        }
        return result;
    }

    // ---------------------------------------------------------------------

    public int numberOfArithmeticSlicesBruteForce(int[] nums) {
        int length = 3;
        int result = 0;

        while (length <= nums.length) {
            for (int i = 0; i + length <= nums.length; i++) {
                if (isArithmetic(nums, i, i + length)) {
                    result++;
                }
            }
            length++;
        }
        return result;
    }

    private boolean isArithmetic(int[] nums, int left, int right) {
        int diff = -1 << 30;
        for (int i = left + 1; i < right; i++) {
            if (diff == -1 << 30) {
                diff = nums[i] - nums[i - 1];
            } else {
                if (nums[i] - nums[i - 1] != diff) {
                    return false;
                }
            }
        }
        return true;
    }
}
