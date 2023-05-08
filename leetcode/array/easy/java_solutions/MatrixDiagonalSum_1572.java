package leetcode.array.easy.java_solutions;

public class MatrixDiagonalSum_1572 {

    static class SolutionOneIteration {
        public int diagonalSum(int[][] mat) {
            int n = mat.length, m = mat[0].length;

            int x1 = 0, y1 = 0, x2 = 0, y2 = m - 1;
            int sum = 0;

            while (x1 < n && y1 < m && x2 < n && y2 >= 0) {
                if (x1 != x2 || y1 != y2) {
                    sum += mat[x1][y1] + mat[x2][y2];
                } else {
                    sum += mat[x1][y1];
                }
                x1++; y1++; x2++; y2--;
            }
            return sum;
        }
    }

    static class Solution {
        public int diagonalSum(int[][] mat) {
            int n = mat.length, m = mat[0].length;

            int x = 0, y = 0, sum = 0;

            while (x < n && y < m) {
                sum += mat[x++][y++];
            }
            x = n - 1;
            y = 0;
            while (x >= 0 && y < m) {
                if (x != n / 2 || y != m / 2) {
                    sum += mat[x][y];
                }
                x--;
                y++;
            }
            return sum;
        }
    }

    static class SolutionBruteForce {
        public int diagonalSum(int[][] mat) {
            int n = mat.length, m = mat[0].length;

            boolean[][] visited = new boolean[n][m];

            int x = 0, y = 0, sum = 0;

            while (x < n && y < m) {
                sum += mat[x][y];
                visited[x++][y++] = true;
            }
            x = n - 1;
            y = 0;
            while (x >= 0 && y < m) {
                if (!visited[x][y]) {
                    sum += mat[x][y];
                }
                x--;
                y++;
            }
            return sum;
        }
    }
}
