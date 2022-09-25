package dynamic_programming.java_solutions;

public class MinimumFailingPathSum_931 {

    static class SolutionDP {

        /*
        Idea is to add to DP all last numbers and do bottom-up approach to calculate on each level all possible min values

        2 1 3
        6 5 4
        7 8 9

        Step 1:
        0 0 0
        13 12 12
        7 8 9

        Step 2:
        14 13 15
        13 12 12
        7 8 9
         */

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            int[][] dp = new int[n][m];
            System.arraycopy(matrix[n - 1], 0, dp[n - 1], 0, m);
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Math.min(
                            Math.min(dp[i + 1][Math.max(j - 1, 0)], dp[i + 1][j]),
                            dp[i + 1][Math.min(j + 1, m - 1)]) + matrix[i][j];
                }
            }
            int min = dp[0][0];
            for (int i = 1; i < m; i++) {
                min = Math.min(min, dp[0][i]);
            }
            return min;
        }
    }

    static class SolutionBruteForce {
        private int min;
        private int m;
        private int n;

        public int minFallingPathSum(int[][] matrix) {
            min = 1 << 30;
            n = matrix.length;
            m = matrix[0].length;
            for (int i = 0; i < m; i++) {
                findMin(matrix, 0, 0, i);
            }
            return min;
        }

        private void findMin(int[][] matrix, int row, int sum, int current) {
            if (row == n) {
                min = Math.min(min, sum);
                return;
            }
            for (int i = current - 1; i <= current + 1; i++) {
                if (i < 0 || i >= m) continue;
                findMin(matrix, row + 1, sum + matrix[row][i], i);
            }
        }
    }

    static class SolutionWithoutClassMinVariable {

        static class Solution {
            private Integer[][] cache;
            private int n;
            private int m;

            public int minFallingPathSum(int[][] matrix) {
                n = matrix.length;
                m = matrix[0].length;
                this.cache = new Integer[n][m];
                int min = 1 << 30;
                for (int i = 0; i < m; i++) {
                    min = Math.min(findMin(matrix, 0, i), min);
                }
                return min;
            }

            private int findMin(int[][] matrix, int row, int current) {
                if (row == n) {
                    return 0;
                }
                if (cache[row][current] != null) return cache[row][current];
                int min = 1 << 30;
                for (int i = current - 1; i <= current + 1; i++) {
                    if (i < 0 || i >= m) continue;
                    min = Math.min(min, findMin(matrix, row + 1, i) + matrix[row][i]);
                }
                cache[row][current] = min;
                return min;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDP().minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}}));
    }
}
