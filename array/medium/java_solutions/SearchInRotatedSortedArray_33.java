package array.medium.java_solutions;

public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int min = 0;
        int max = length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[min] <= nums[mid]) {
                if (nums[min] <= target && target <= nums[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[max]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }
        return -1;
    }
}
