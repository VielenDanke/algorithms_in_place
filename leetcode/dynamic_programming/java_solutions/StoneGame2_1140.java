package leetcode.dynamic_programming.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class StoneGame2_1140 {

    static class Solution {

        private Map<String, Integer> cache;

        public int stoneGameII(int[] piles) {
            this.cache = new HashMap<>();
            return backtrack(piles, 1, 0, true);
        }

        private int backtrack(int[] piles, int m, int start, boolean isAliceTurn) {
            if (start >= piles.length) {
                return 0;
            }
            String key = buildKey(start, m, isAliceTurn);
            if (cache.containsKey(key)) return cache.get(key);
            int maxScores;
            if (isAliceTurn) {
                maxScores = 0;
                int temp = 0;
                for (int i = 0; i < 2 * m && start + i < piles.length; i++) {
                    temp += piles[start + i];
                    maxScores = Math.max(maxScores, backtrack(piles, Math.max(m, i + 1), start + i + 1, !isAliceTurn) + temp);
                }
            } else {
                maxScores = Integer.MAX_VALUE;
                for (int i = 0; i < 2 * m && start + i < piles.length; i++) {
                    maxScores = Math.min(maxScores, backtrack(piles, Math.max(m, i + 1), start + i + 1, !isAliceTurn));
                }
            }
            cache.put(key, maxScores);
            return maxScores;
        }

        private String buildKey(int idx, int m, boolean turn) {
            return String.format("%d-%d-%b", idx, m, turn);
        }
    }
}
