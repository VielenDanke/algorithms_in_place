package leetcode.array.medium.java_solutions;

public class FindFirstLastPosition_34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                left = middle - 1;
                right = middle + 1;
                while (left >= 0 && nums[middle] == nums[left]) {
                    left--;
                }
                while (right < nums.length && nums[middle] == nums[right]) {
                    right++;
                }
                return new int[]{left + 1, right - 1};
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
