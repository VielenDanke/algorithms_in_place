package leetcode.array.medium.java_solutions;

public class CheckIfItIsAStraightLine_1232 {

    static class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates == null) {
                return true;
            }
            int n = coordinates.length;

            if (n <= 1) {
                return true;
            }
            for (int i = 2; i < n; i++) {
                if (!isOneLineCoordinates(coordinates[i], coordinates[0], coordinates[1])) {
                    return false;
                }
            }
            return true;
        }

        private boolean isOneLineCoordinates(int[] first, int[] second, int[] third) {
            int x = first[0];
            int y = first[1];
            int x1 = second[0];
            int y1 = second[1];
            int x2 = third[0];
            int y2 = third[1];

            return (y - y1) * (x2 - x1) == (y2 - y1) * (x - x1);
        }
    }
}
