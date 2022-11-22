package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PerfectSquares_279 {

    private static List<Integer> calculatePowers(int n) {
        List<Integer> powers = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow(i, 2);
            if (power > n) {
                break;
            } else {
                powers.add(power);
            }
        }
        return powers;
    }

    static class SolutionDP {

        public int numSquares(int n) {
            List<Integer> powers = calculatePowers(n);

            int[] dp = new int[n + 1];

            Arrays.fill(dp, -1);

            dp[0] = 0;

            for (Integer power : powers) {
                for (int i = 0; i <= n; i++) {
                    if (i - power >= 0 && dp[i - power] >= 0) {
                        if (dp[i] >= 0) {
                            dp[i] = Math.min(dp[i], dp[i - power] + 1);
                        } else {
                            dp[i] = dp[i - power] + 1;
                        }
                    }
                }
            }
            return dp[n];
        }
    }

    static class SolutionMemo {

        private Integer[] cache;

        public int numSquares(int n) {
            this.cache = new Integer[n + 1];
            int result = backtrack(calculatePowers(n), 0, n);
            return result > 10000 ? -1 : result;
        }

        public int backtrack(List<Integer> powers, int temp, int n) {
            if (temp == n) return 0;
            if (cache[temp] != null) return cache[temp];
            int min = 1 << 30;
            for (int i = 0; i < powers.size(); i++) {
                if (powers.get(i) + temp <= n) {
                    min = Math.min(min, backtrack(powers, temp + powers.get(i), n) + 1);
                }
            }
            cache[temp] = min;
            return min;
        }
    }
}
