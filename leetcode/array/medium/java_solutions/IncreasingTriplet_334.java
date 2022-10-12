package leetcode.array.medium.java_solutions;

public class IncreasingTriplet_334 {

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            int smallest = Integer.MAX_VALUE, biggest = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= smallest) {
                    smallest = num;
                } else if (num <= biggest) {
                    biggest = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    static class SolutionBruteForce {
        public boolean increasingTriplet(int[] nums) {
            for (int i = 1; i < nums.length - 1; i++) {
                int leftIdx = -1 << 30, rightIdx = -1 << 30;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        leftIdx = j;
                        break;
                    }
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        rightIdx = j;
                        break;
                    }
                }
                if (leftIdx != -1 << 30 && rightIdx != -1 << 30) {
                    return true;
                }
            }
            return false;
        }
    }
}
