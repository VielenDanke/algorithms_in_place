package array.medium.java_solutions;

import java.util.Arrays;

public class Sum3_16 {

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Integer closest = null;
            Integer minDif = null;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int diff = Math.abs(sum - target);

                    if (minDif == null || diff < minDif) {
                        closest = sum;
                        minDif = diff;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return closest;
        }
    }
}
