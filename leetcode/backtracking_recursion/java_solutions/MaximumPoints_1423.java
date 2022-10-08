package leetcode.backtracking_recursion.java_solutions;

import java.util.Arrays;

public class MaximumPoints_1423 {

    // Sliding window
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, lSum = 0;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        int max = lSum, rSum = 0;
        for (int i = 0; i < k; i++) {
            rSum += cardPoints[n - 1 - i];
            lSum -= cardPoints[k - 1 - i];
            max = Math.max(max, lSum + rSum);
        }
        return max;
    }

    // Prefix Suffix sum

    public int maxScorePrefixSum(int[] cardPoints, int k) {
        int N = cardPoints.length;
        int[] prefixSums = new int[N];
        int[] suffixSums = new int[N];
        prefixSums[0] = cardPoints[0];
        suffixSums[0] = cardPoints[N - 1];
        for (int i = 1; i < N; i++) {
            prefixSums[i] = prefixSums[i - 1] + cardPoints[i];
            suffixSums[i] = suffixSums[i - 1] + cardPoints[N - i - 1];
        }
        int left = 0, right = 0, max = 0;
        for (int i = k - 1; i >= 0; i--) {
            max = Math.max(max, prefixSums[i] + left);
            max = Math.max(max, suffixSums[i] + right);
            left = suffixSums[k - 1 - i];
            right = prefixSums[k - 1 - i];
        }
        return max;
    }

    // DP

    public int maxScoreDP(int[] cardPoints, int k) {
        int[] dp = new int[k + 1];
        int N = cardPoints.length;

        for (int i = 0; i < k; i++) {
            dp[0] += cardPoints[i];
        }
        int max = dp[0];
        for (int i = 1; i <= k; i++) {
            dp[i] = dp[i - 1] + cardPoints[N - i] - cardPoints[k - i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // ----------------------------------------------------------------------------------------------------------
    // Brute Force

    public int maxScoreBruteForce(int[] cardPoints, int k) {
        int N = cardPoints.length;
        if (N == 0 || k == 0) {
            return 0;
        }
        int[] left = Arrays.copyOfRange(cardPoints, 1, N);
        int[] right = Arrays.copyOfRange(cardPoints, 0, N - 1);
        return Math.max(maxScore(left, k - 1) + cardPoints[0], maxScore(right, k - 1) + cardPoints[N - 1]);
    }
}
