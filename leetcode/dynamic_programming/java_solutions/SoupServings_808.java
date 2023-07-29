package leetcode.dynamic_programming.java_solutions;

public class SoupServings_808 {

    static class Solution {
        private Double[][] memo;

        public double soupServings(int n) {
            memo = new Double[200][200];
            // to handle out of memory - skip N more than 4000
            // probability of numbers > 4000 going to 1
            return n > 4000 ? 1.0 : dfs((n + 24) / 25, (n + 24) / 25);
        }

        /*
        serving first all left
        serving 75 left 25 right
        serving 50 left 50 right
        serving 25 left 75 right
        multiply by 0.25 because of probability
        use memo to cache result to reuse it in the future
         */
        private double dfs(int left, int right) {
            if (left <= 0 && right <= 0) return 0.5;
            if (left <= 0) return 1.0;
            if (right <= 0) return 0.0;
            if (memo[left][right] != null) return memo[left][right];
            return memo[left][right] = 0.25 * (dfs(left - 4, right) + dfs(left - 3, right - 1) + dfs(left - 2, right - 2) + dfs(left - 1, right - 3));
        }
    }
}
