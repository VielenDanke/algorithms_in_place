package array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery2D_304 {

    private static class NumMatrix {
        private final int[][] sum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            r1++;
            c1++;
            r2++;
            c2++;
            return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
        }
    }

    // ---------------------------------------------------------

    private final int[][] matrix;
    private final Map<String, Integer> cacheMap = new HashMap<>();

    public RangeSumQuery2D_304(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowStart = Math.min(row1, row2);
        int colStart = Math.min(col1, col2);
        int rowEnd = Math.max(row1, row2);
        int colEnd = Math.max(col1, col2);

        String key = String.format("%d-%d-%d-%d", rowStart, rowEnd, colStart, colEnd);

        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
        int sum = 0;

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                sum += matrix[i][j];
            }
        }
        cacheMap.put(key, sum);
        return sum;
    }
}
