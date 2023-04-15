package leetcode.dynamic_programming.java_solutions;

import java.util.List;

public class MaximumValueOfKCoinsFromPiles_2218 {

    static class Solution {
        private List<List<Integer>> piles;
        private Integer[][] cache;

        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            this.piles = piles;
            this.cache = new Integer[piles.size() + 1][k + 1];
            return dp(0, k);
        }

        private int dp(int idx, int k) {
            if (k == 0 || idx >= piles.size()) return 0;
            if (cache[idx][k] != null) return cache[idx][k];

            int temp = dp(idx + 1, k);

            int current = 0;

            for (int i = 0; i < Math.min(piles.get(idx).size(), k); i++) {
                current += piles.get(idx).get(i);
                temp = Math.max(temp, current + dp(idx + 1, k - i - 1));
            }
            return cache[idx][k] = temp;
        }
    }
}
