package hackerrank.array.easy.java_solutions;

import java.util.*;

public class QueensAttack {

    static class SolutionMatrix {
        private static final int[][] DIRECTIONS = new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
            // Write your code here
            // check if boarders are not violated
            // queen is going (r + 1, c + 1), (r - 1, c - 1), (r + 1, c - 1), (r - 1, c + 1)
            Map<Integer, Set<Integer>> obstacleMatrix = convertToMatrix(obstacles, n);
            int result = 0;
            for (int[] direction : DIRECTIONS) {
                result += calculateAvailableCells(obstacleMatrix, direction, r_q, c_q, n);
            }
            return result;
        }

        private static int calculateAvailableCells(Map<Integer, Set<Integer>> obstacleMatrix, int[] direction, int row, int col, int n) {
            int result = -1;
            while (!areBoardersViolated(n, row, col) && !isObstacleFound(obstacleMatrix, row, col)) {
                result++;
                row += direction[0];
                col += direction[1];
            }
            return result;
        }

        private static Map<Integer, Set<Integer>> convertToMatrix(List<List<Integer>> obstacles, int n) {
            Map<Integer, Set<Integer>> storage = new HashMap<>();
            for (List<Integer> obstacle : obstacles) {
                storage.putIfAbsent(obstacle.get(0), new HashSet<>());
                storage.get(obstacle.get(0)).add(obstacle.get(1));
            }
            return storage;
        }

        private static boolean isObstacleFound(Map<Integer, Set<Integer>> obstacles, int row, int col) {
            if (obstacles.containsKey(row)) {
                return obstacles.get(row).contains(col);
            }
            return false;
        }

        private static boolean areBoardersViolated(int n, int row, int col) {
            return row < 1 || col < 1 || row > n || col > n;
        }
    }
}
