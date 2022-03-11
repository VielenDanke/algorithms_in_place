package javasolutions.array.medium;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        reverseRows(matrix);
        reverseDiagonals(matrix);
    }

    public void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;

            while (start < end) {
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
                start++;
                end--;
            }
        }
    }

    public void reverseDiagonals(int[][] matrix) {
        for (int j = matrix[0].length - 1; j > 0; j--) {
            int factor = matrix[0].length - j  - 1;
            int startI = 0;
            int endJ = j + factor;

            rotateRight(matrix, startI, j, factor, endJ);
        }

        for (int i = 0; i < matrix.length; i++) {
            int factor = matrix.length - i - 1;
            int startJ = 0;
            int endI = i + factor;

            rotateRight(matrix, i, startJ, endI, factor);
        }
    }

    private void rotateRight(int[][] matrix, int startI, int startJ, int endI, int endJ) {
        while (startI < endI && startJ < endJ) {
            int temp = matrix[endI][endJ];
            matrix[endI][endJ] = matrix[startI][startJ];
            matrix[startI][startJ] = temp;
            startI++;
            startJ++;
            endI--;
            endJ--;
        }
    }

    public void rotate2(int[][] matrix) {
        int len = matrix[0].length;

        int toRotate = 0;
        int pointer = 0;

        int[] rotateTemp = new int[len];
        List<List<Integer>> rotated = new ArrayList<>();

        while (toRotate != len) {
            for (int i = len - 1; i >= 0; i--) {
                int[] arr = matrix[i];
                rotateTemp[pointer] = arr[toRotate];
                pointer++;
            }
            toRotate++;
            pointer = 0;
            rotated.add(convert(rotateTemp));
        }
        for (int i = 0; i < len; i++) {
            matrix[i] = deconvert(rotated.get(i));
        }
    }

    public int[] deconvert(List<Integer> list) {
        int size = list.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public List<Integer> convert(int[] nums) {
        return new ArrayList<>() {{
            for (int i : nums) {
                add(i);
            }
        }};
    }
}
