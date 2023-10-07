package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_1420 {

    static class Solution {
        public int numOfArrays(int n, int m, int k) {
            final int mod = 1000000007;

            int[][] dp = new int[m + 1][k + 1];
            int[][] prefix = new int[m + 1][k + 1];
            int[][] prevDp = new int[m + 1][k + 1];
            int[][] prevPrefix = new int[m + 1][k + 1];

            for (int j = 1; j <= m; j++) {
                prevDp[j][1] = 1;
                prevPrefix[j][1] = j;
            }

            for (int i = 2; i <= n; i++) {
                for (int maxNum = 1; maxNum <= m; maxNum++) {
                    for (int cost = 1; cost <= k; cost++) {
                        dp[maxNum][cost] = (int) (((long) maxNum * prevDp[maxNum][cost]) % mod);

                        if (maxNum > 1 && cost > 1) {
                            dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
                        }

                        prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
                    }
                }

                for (int j = 1; j <= m; j++) {
                    System.arraycopy(dp[j], 0, prevDp[j], 0, k + 1);
                    System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k + 1);
                }
            }

            return prefix[m][k];
        }
    }

    static class SolutionMemo {
        private static final int MOD = (int) 1e9 + 7;
        private Integer[][][] memo;
        private int n;
        private int m;

        public int numOfArrays(int n, int m, int k) {
            this.n = n;
            this.m = m;
            memo = new Integer[n][m + 1][k + 1];
            return dp(0, 0, k);
        }

        public int dp(int i, int maxSoFar, int remain) {
            if (i == n) {
                if (remain == 0) {
                    return 1;
                }
                return 0;
            }
            if (remain < 0) {
                return 0;
            }
            if (memo[i][maxSoFar][remain] != null) {
                return memo[i][maxSoFar][remain];
            }
            int ans = 0;
            for (int num = 1; num <= maxSoFar; num++) {
                ans = (ans + dp(i + 1, maxSoFar, remain)) % MOD;
            }
            for (int num = maxSoFar + 1; num <= m; num++) {
                ans = (ans + dp(i + 1, num, remain - 1)) % MOD;
            }
            memo[i][maxSoFar][remain] = ans;
            return ans;
        }
    }

    static class SolutionBruteForce {
        public int numOfArrays(int n, int m, int k) {
            return backtrack(new ArrayList<>(), n, m, k);
        }

        private int backtrack(List<Integer> temp, int n, int m, int k) {
            if (temp.size() == n) {
                if (calculateCost(temp) == k) {
                    return 1;
                }
                return 0;
            }
            int sum = 0;
            for (int i = 1; i <= m; i++) {
                temp.add(i);
                sum += backtrack(temp, n, m, k);
                temp.remove(temp.size() - 1);
            }
            return sum;
        }

        private int calculateCost(List<Integer> numbers) {
            int max = -1, searchCost = 0, n = numbers.size();
            for (Integer num : numbers) {
                if (max < num) {
                    max = num;
                    searchCost++;
                }
            }
            return searchCost;
        }
    }
}
