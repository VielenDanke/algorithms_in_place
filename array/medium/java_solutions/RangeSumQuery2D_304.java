package array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery2D_304 {

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
