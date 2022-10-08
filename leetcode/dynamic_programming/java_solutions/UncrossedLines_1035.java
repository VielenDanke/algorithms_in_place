package leetcode.dynamic_programming.java_solutions;

public class UncrossedLines_1035 {

    static class SolutionDP {
        /*
        Idea is the same as for memoization, but with DP[][] matrix
        1. If nums1[i - 1] == nums2[j - 1] - add to previously calculated result 1 + dp[i - 1][j - 1]
        2. If nums1[i - 1] != nums2[j - 1] - put Math.max(dp[i - 1][j], dp[i][j - 1])
         */

        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n = nums1.length + 1;
            int m = nums2.length + 1;

            int[][] dp = new int[n][m];

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[n - 1][m - 1];
        }
    }

    static class SolutionMemo {

        /*
        Idea:
        1. Move each recursion level either with left + 1 or right + 1
        2. if nums1[left] == nums2[left] - means we have one connection and next recursion call
           should be with left + 1 AND right + 1
        3. if we reach the condition when left >= nums1.length or right >= nums2.length - return 0
        4. Each recursion call where nums1[left] == nums2[right] add 1 e.g. it is connection, and we need to count it
        5. Each recursion call where nums1[left] != nums2[right] - simply return Math.max of 2 recursion calls
        6. Using cache to reduce computation of sub-problems (Compute the same sub-problem several times)
         */

        private Integer[][] cache;

        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            this.cache = new Integer[nums1.length][nums2.length];
            return calculate(nums1, nums2, 0, 0);
        }

        private int calculate(int[] nums1, int[] nums2, int left, int right) {
            if (left >= nums1.length || right >= nums2.length) {
                return 0;
            }
            if (cache[left][right] != null) return cache[left][right];
            if (nums1[left] == nums2[right]) {
                cache[left][right] = 1 + calculate(nums1, nums2, left + 1, right + 1);
            } else {
                cache[left][right] = Math.max(calculate(nums1, nums2, left + 1, right), calculate(nums1, nums2, left, right + 1));
            }
            return cache[left][right];
        }
    }
}
