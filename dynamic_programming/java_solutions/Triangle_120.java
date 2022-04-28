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
        int n = triangle.size();
        int[] results = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> current = triangle.get(i);

            for (int j = 0; j < current.size(); j++) {
                results[j] = Math.min(results[j], results[j + 1]) + current.get(j);
            }
        }
        return results[0];
    }
}
