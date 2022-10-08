package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;

public class MatrixBlockSum_1314 {

    static class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
                }
            }
            int[][] ans = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int rStart = Math.max(0, r - k), cStart = Math.max(0, c - k);
                    int rEnd = Math.min(m - 1, r + k), cEnd = Math.min(n - 1, c + k);
                    rStart++;
                    cStart++;
                    rEnd++;
                    cEnd++;
                    ans[r][c] = sum[rEnd][cEnd] - sum[rEnd][cStart - 1] - sum[rStart - 1][cEnd] + sum[rStart - 1][cStart - 1];
                }
            }
            return ans;
        }
    }

    static class SolutionBruteForce {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int n = mat.length, m = mat[0].length;
            int[][] result = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sum = 0;
                    int xStart = Math.max((i - k), 0);
                    int xEnd = Math.min((i + k), n - 1);
                    int zStart = Math.max((j - k), 0);
                    int zEnd = Math.min((j + k), m - 1);
                    for (int x = xStart; x <= xEnd; x++) {
                        for (int z = zStart; z <= zEnd; z++) {
                            sum += mat[x][z];
                        }
                    }
                    result[i][j] = sum;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.deepToString(new Solution().matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));
        }
    }
}
