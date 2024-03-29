package leetcode.array.medium.java_solutions;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {

    static class Solution {
        public long countSubarrays(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = nums[0];

            for (int num : nums) {
                max = Math.max(max, num);
            }
            int left = 0, maxElementsInWindow = 0;
            long result = 0;

            for (int num : nums) {
                if (num == max) {
                    maxElementsInWindow++;
                }
                while (maxElementsInWindow == k) {
                    if (nums[left] == max) {
                        maxElementsInWindow--;
                    }
                    left++;
                }
                result += left;
            }
            return result;
        }
    }
}
