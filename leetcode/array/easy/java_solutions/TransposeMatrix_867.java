package leetcode.array.easy.java_solutions;

public class TransposeMatrix_867 {

    public int[][] transpose(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] copyMatrix = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMatrix[j][i] = matrix[i][j];
            }
        }
        return copyMatrix;
    }
}
