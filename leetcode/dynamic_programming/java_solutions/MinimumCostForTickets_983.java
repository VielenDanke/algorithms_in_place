package leetcode.dynamic_programming.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets_983 {

    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;
            int lastDay = days[n - 1];

            int[] dp = new int[lastDay + 1];

            boolean[] isTravelDay = new boolean[lastDay + 1];

            for (int day : days) isTravelDay[day] = true; // count only for travel days

            for (int i = 1; i <= lastDay; i++) {
                if (!isTravelDay[i]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                dp[i] = costs[0] + dp[i - 1]; // for 1 day pass
                dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // for 7 day pass
                dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // for 30 day pass
            }
            return dp[lastDay];
        }
    }

    static class SolutionRecursive {

        private final int[] passDays = new int[]{1, 7, 30};
        private int[] costs;
        private Set<Integer> visitedDays;
        private Integer[] cache;

        public int mincostTickets(int[] days, int[] costs) {
            this.visitedDays = new HashSet<>();
            this.costs = costs;
            this.cache = new Integer[400];
            for (int day : days) visitedDays.add(day);
            return backtrack(0, days[days.length - 1]);
        }

        private int backtrack(int day, int end) {
            if (cache[day] != null) return cache[day];
            if (day > end) {
                return cache[day] = 0;
            }
            if (!visitedDays.contains(day)) {
                return cache[day] = backtrack(day + 1, end);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, backtrack(day + passDays[i], end) + costs[i]);
            }
            return cache[day] = min;
        }
    }
}
