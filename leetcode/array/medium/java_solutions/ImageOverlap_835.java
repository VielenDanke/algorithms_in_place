package leetcode.array.medium.java_solutions;

import java.util.*;

public class ImageOverlap_835 {

    static class SolutionMap {
        private record Pair<KEY, VALUE>(KEY key, VALUE value) {

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair<?, ?> pair = (Pair<?, ?>) o;
                return key.equals(pair.key) && value.equals(pair.value);
            }
        }

        private List<Pair<Integer, Integer>> nonZeroCells(int[][] array) {
            List<Pair<Integer, Integer>> ret = new LinkedList<>();
            for (int row = 0; row < array.length; row++)
                for (int col = 0; col < array.length; col++)
                    if (array[row][col] == 1)
                        ret.add(new Pair<>(row, col));
            return ret;
        }

        public int largestOverlap(int[][] left, int[][] right) {

            List<Pair<Integer, Integer>> leftOnes = nonZeroCells(left);
            List<Pair<Integer, Integer>> rightOnes = nonZeroCells(right);

            int maxOverlaps = 0;
            Map<Pair<Integer, Integer>, Integer> groupCount = new HashMap<>();

            for (Pair<Integer, Integer> a : leftOnes)
                for (Pair<Integer, Integer> b : rightOnes) {
                    Pair<Integer, Integer> vec = new Pair<>(b.key() - a.key(), b.value() - a.value());

                    groupCount.put(vec, groupCount.getOrDefault(vec, 0) + 1);

                    maxOverlaps = Math.max(maxOverlaps, groupCount.get(vec));
                }

            return maxOverlaps;
        }
    }

    static class Solution {
        public int largestOverlap(int[][] left, int[][] right) {
            int ans = 0;
            for (int row = -left.length; row < left.length; row++) {
                for (int col = -left[0].length; col < left[0].length; col++) {
                    ans = Math.max(ans, overlap(left, right, row, col));
                }
            }
            return ans;
        }

        public int overlap(int[][] left, int[][] right, int rowOffset, int colOffset) {
            int ans = 0;
            for (int row = 0; row < left.length; row++) {
                for (int col = 0; col < left[0].length; col++) {
                    if ((row + rowOffset < 0 || row + rowOffset >= left.length) || (col + colOffset < 0 || col + colOffset >= left.length)) {
                        continue;
                    }
                    if (left[row][col] == 1 && right[row + rowOffset][col + colOffset] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
