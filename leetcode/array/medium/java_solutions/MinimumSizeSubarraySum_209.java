package leetcode.array.medium.java_solutions;

public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = 1 << 30;
        int left = 0, right = 0, tempSum = 0;

        while (right < nums.length) {
            tempSum += nums[right];
            right++;
            while (left < right && tempSum >= target) {
                if (minLength > right - left) {
                    minLength = right - left;
                }
                tempSum -= nums[left++];
            }
        }
        return minLength == 1 << 30 ? 0 : minLength;
    }
}
