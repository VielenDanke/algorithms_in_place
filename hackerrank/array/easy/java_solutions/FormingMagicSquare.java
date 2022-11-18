package hackerrank.array.easy.java_solutions;

import java.util.List;

public class FormingMagicSquare {

    // https://www.hackerrank.com/challenges/magic-square-forming/problem

    static class Solution {
        private static final int[][][] MAGIC_SQUARES = new int[][][]{
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {2, 9, 4}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };

        public static int formingMagicSquare(List<List<Integer>> s) {
            // Write your code here
            int minCost = Integer.MAX_VALUE;

            for (int[][] matrix : MAGIC_SQUARES) {
                int currentCost = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        currentCost += Math.abs(s.get(i).get(j) - matrix[i][j]);
                    }
                }
                minCost = Math.min(minCost, currentCost);
            }
            return minCost;
        }
    }
}
