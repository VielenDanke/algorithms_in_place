package dynamic_programming.java_solutions;

import java.util.*;

public class Triangle_120 {

    private static class Pair {
        private int row;
        private int idx;

        public Pair(int row, int idx) {
            this.row = row;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && idx == pair.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, idx);
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return traverseTriangle(triangle, 0, 0, new HashMap<>());
    }

    private int traverseTriangle(List<List<Integer>> l, int nextRow, int idx, Map<Pair, Integer> memo) {
        Pair key = new Pair(nextRow, idx);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (l.size() == nextRow) {
            return 0;
        }
        List<Integer> integers = l.get(nextRow);

        int min = Math.min(
                traverseTriangle(l, nextRow + 1, idx, memo),
                traverseTriangle(l, nextRow + 1, idx + 1, memo)
        ) + integers.get(idx);

        memo.put(key, min);

        return min;
    }

    // ----------------------------------------------------------------------------------------------------------------

    public int minimumTotalDP(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int pos = 0; pos < triangle.get(row).size(); pos++) {
                dp[row][pos] = triangle.get(row).get(pos) + Math.min(dp[row + 1][pos + 1], dp[row + 1][pos]);
            }
        }

        return dp[0][0];
    }
}
