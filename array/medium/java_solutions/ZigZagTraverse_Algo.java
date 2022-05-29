package array.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse_Algo {

    public static List<Integer> zigzagTraverse(List<List<Integer>> matrix) {
        int N = matrix.size();
        int M = matrix.get(0).size();
        int row = 0, col = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N * M; i++) {
            result.add(matrix.get(row).get(col));
            if ((row + col) % 2 == 0) {
                if (col == 0 && row != N - 1) {
                    row++;
                } else if (row == N - 1) {
                    col++;
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 && col != M - 1) {
                    col++;
                } else if (col == M - 1) {
                    row++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        return result;
    }
}
