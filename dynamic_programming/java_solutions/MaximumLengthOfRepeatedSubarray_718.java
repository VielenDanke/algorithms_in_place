package dynamic_programming.java_solutions;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MaximumLengthOfRepeatedSubarray_718 {

    static class SolutionDP {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length, max = 0;

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else {
                        if (nums1[i - 1] == nums2[j - 1]) {
                            dp[i][j] = 1 + dp[i - 1][j - 1];
                            max = Math.max(max, dp[i][j]);
                        }
                    }
                }
            }
            return max;
        }


    }

    static class SolutionBruteForce {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length, max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int incr = 0, tempI = i, tempJ = j;
                    while (tempI < n && tempJ < m && nums1[tempI++] == nums2[tempJ++]) {
                        incr++;
                    }
                    max = Math.max(max, incr);
                }
            }
            return max;
        }
    }
}
