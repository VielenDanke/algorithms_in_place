package leetcode.array.medium.java_solutions;

public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int peak = -1 << 30;

        int left = 0, right = 2;

        while (right < nums.length) {
            int middle = (right + left) / 2;
            if (nums[left] < nums[middle] && nums[middle] > nums[right]) {
                peak = middle;
            }
            left++;
            right++;
        }
        if (peak < 0) {
            if (nums[0] > nums[1]) {
                return 0;
            } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
        }
        return peak;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0, right = n - 1;
        while (right - left > 1) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == n - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
