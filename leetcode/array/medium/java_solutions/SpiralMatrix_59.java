package leetcode.array.medium.java_solutions;

public class SpiralMatrix_59 {

    static class Solution {

        private int n;
        private int limit;
        private int currentNumber;

        public int[][] generateMatrix(int n) {
            this.n = n;
            this.limit = n * n;
            this.currentNumber = 1;
            int[][] result = new int[n][n];

            fulfill(result, 0);

            return result;
        }

        private void fulfill(int[][] result, int diff) {
            if (currentNumber > limit) {
                return;
            }
            for (int i = diff; i < n - diff; i++) {
                result[diff][i] = currentNumber++;
                if (currentNumber > limit) {
                    return;
                }
            }
            for (int i = 1 + diff; i < n - diff; i++) {
                result[i][n - diff - 1] = currentNumber++;
                if (currentNumber > limit) {
                    return;
                }
            }
            for (int i = n - diff - 2; i >= diff; i--) {
                result[n - diff - 1][i] = currentNumber++;
                if (currentNumber > limit) {
                    return;
                }
            }
            for (int i = n - diff - 2; i >= diff + 1; i--) {
                result[i][diff] = currentNumber++;
                if (currentNumber > limit) {
                    return;
                }
            }
            fulfill(result, diff + 1);
        }
    }
}
