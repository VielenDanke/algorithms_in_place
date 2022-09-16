package dynamic_programming.java_solutions;

public class MaximumScoreFromPerformingMultiplicationOperations_1770 {

    static class Solution {
        public int maximumScore(int[] nums, int[] multipliers) {
            int[][] dp = new int[nums.length + 1][multipliers.length + 1];
            int n = nums.length, m = multipliers.length;

            for (int i = m - 1; i >=0; i--) {
                for (int left = i; left >= 0; left--) {
                    int right = n - 1 - i + left;
                    dp[i][left] = Math.max(multipliers[i] * nums[left] + dp[i + 1][left + 1],
                            multipliers[i] * nums[right] + dp[i + 1][left]);
                }
            }
            return dp[0][0];
        }

        public static void main(String[] args) {
            System.out.println(new Solution().maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
        }
    }

    static class SolutionMemo {

        private Integer[][] cache;

        public int maximumScore(int[] nums, int[] multipliers) {
            /*
            1. for i in range(0, m)
            2. choose from left or right from nums
            3. multipliers[i] * nums[left or right]
            4. remove nums[i] (make tombstone)
            */

            cache = new Integer[nums.length][multipliers.length];

            return findMaximumRecursive(nums, multipliers, 0, 0);
        }

        private int findMaximumRecursive(int[] nums, int[] multipliers, int operation, int left) {
            if (operation >= multipliers.length) {
                return 0;
            }
            int right = nums.length - 1 - (operation - left);
            if (cache[left][operation] != null) return cache[left][operation];
            int leftSum = multipliers[operation] * nums[left] + findMaximumRecursive(nums, multipliers, operation + 1, left + 1);
            int rightSum = multipliers[operation] * nums[right] + findMaximumRecursive(nums, multipliers, operation + 1, left);
            return cache[left][operation] = Math.max(leftSum, rightSum);
        }
    }
}
