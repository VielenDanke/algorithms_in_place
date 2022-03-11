package javasolutions.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    int currentNumber = 1;
    int n = 0;

    public int[][] generateMatrix(int n) {
        this.n = n;
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                matrix.get(i).add(null);
            }
        }
        fill(matrix, 0, n - 1);
        return transform(matrix);
    }

    private int[][] transform(List<List<Integer>> list) {
        int[][] transformedList = new int[n][n];

        for (int i = 0; i < n; i++) {
            List<Integer> row = list.get(i);
            for (int j = 0; j < n; j++) {
                transformedList[i][j] = row.get(j);
            }
        }
        return transformedList;
    }

    private void fill(List<List<Integer>> matrix, int row, int column) {
        if (currentNumber > n * n) {
            return;
        }
        List<Integer> l = matrix.get(row);
        for (int i = 0; i < n; i++) {
            if (l.get(i) == null) {
                l.set(i, currentNumber);
                currentNumber++;
            }
        }
        for (int i = 0; i < n; i++) {
            l = matrix.get(i);
            if (l.get(column) == null) {
                l.set(column, currentNumber);
                currentNumber++;
            }
        }
        l = matrix.get(n - row - 1);
        for (int i = n - 1; i >= 0; i--) {
            if (l.get(i) == null) {
                l.set(i, currentNumber);
                currentNumber++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            l = matrix.get(i);
            if (l.get(i) == null) {
                l.set(n - column - 1, currentNumber);
                currentNumber++;
            }
        }
        fill(matrix, ++row, --column);
    }
}
