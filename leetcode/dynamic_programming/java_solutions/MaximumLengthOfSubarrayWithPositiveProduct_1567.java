package leetcode.dynamic_programming.java_solutions;

public class MaximumLengthOfSubarrayWithPositiveProduct_1567 {

    static class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length;
            int[] pos = new int[n];
            int[] neg = new int[n];
            if (nums[0] > 0) pos[0] = 1;
            if (nums[0] < 0) neg[0] = 1;
            int ans = pos[0];
            for (int i = 1; i < n; i++) {
                int num = neg[i - 1] > 0 ? 1 + neg[i - 1] : 0;
                if (nums[i] > 0) {
                    pos[i] = 1 + pos[i - 1];
                    neg[i] = num;
                } else if (nums[i] < 0) {
                    pos[i] = num;
                    neg[i] = 1 + pos[i - 1];
                }
                ans = Math.max(ans, pos[i]);
            }
            return ans;
        }
    }

    static class SolutionNoMemoryUsed {
        public int getMaxLen(int[] nums) {
            int positive = 0, negative = 0;
            int ans = 0;
            for (int x : nums) {
                if (x == 0) {
                    positive = 0;
                    negative = 0;
                } else if (x > 0) {
                    positive++;
                    negative = negative == 0 ? 0 : negative + 1;
                } else {
                    int temp = positive;
                    positive = negative == 0 ? 0 : negative + 1;
                    negative = temp + 1;
                }
                ans = Math.max(ans, positive);
            }
            return ans;
        }
    }

    static class SolutionBruteForce {
        public int getMaxLen(int[] nums) {
            int max = 1;
            boolean isPositivePresent = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                if (nums[i] > 0) isPositivePresent = true;
                int negativeAmount = nums[i] < 0 ? 1 : 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        if (negativeAmount % 2 == 0) {
                            max = Math.max(max, j - i);
                        }
                        break;
                    }
                    if (nums[j] < 0) {
                        negativeAmount++;
                    }
                    if (negativeAmount % 2 == 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            return max == 1 ? isPositivePresent ? max : 0 : max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct_1567.SolutionNoMemoryUsed().getMaxLen(new int[]{9, 5, 8, 2, -6, 4, 3}));
    }
}
