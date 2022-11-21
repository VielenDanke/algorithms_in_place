package leetcode.graph.medium.java_solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestExitFromEntranceInMaze_1926 {

    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class SolutionBFS {
        public int nearestExit(char[][] maze, int[] entrance) {
            Queue<int[]> coordinates = new LinkedList<>();
            int n = maze.length, m = maze[0].length, steps = 0;
            char symbol = '!';

            maze[entrance[0]][entrance[1]] = symbol;
            coordinates.add(entrance);

            while (!coordinates.isEmpty()) {
                int currentSize = coordinates.size();
                steps++;

                for (int i = 0; i < currentSize; i++) {
                    int[] current = coordinates.poll();
                    for (int[] dir : DIRECTIONS) {
                        int newRow = current[0] + dir[0];
                        int newCol = current[1] + dir[1];

                        if (isBoardersViolated(n, m, newRow, newCol) || maze[newRow][newCol] == '+' || maze[newRow][newCol] == symbol) {
                            continue;
                        }
                        if (isExitFound(n, m, newRow, newCol)) {
                            return steps;
                        }
                        coordinates.offer(new int[]{newRow, newCol});
                        maze[newRow][newCol] = symbol;
                    }
                }
            }
            return -1;
        }
    }

    static class SolutionDFS {

        private int n;
        private int m;
        private char symbol;
        private int[] entrance;

        public int nearestExit(char[][] maze, int[] entrance) {
            if (maze == null) return -1;
            this.symbol = '!';
            this.entrance = entrance;
            this.n = maze.length;
            this.m = maze[0].length;
            Integer result = traverse(maze, entrance[0], entrance[1]);
            return result == null ? -1 : result;
        }

        private Integer traverse(char[][] maze, int row, int col) {
            if (isBoardersViolated(n, m, row, col)) {
                return null;
            }
            char current = maze[row][col];
            if (current == '+' || current == '!') {
                return null;
            }
            if (isExitFound(n, m, row, col) && (row != entrance[0] || col != entrance[1])) {
                return 0;
            }
            maze[row][col] = symbol;
            List<Integer> list = new LinkedList<>();
            list.add(traverse(maze, row + 1, col));
            list.add(traverse(maze, row - 1, col));
            list.add(traverse(maze, row, col + 1));
            list.add(traverse(maze, row, col - 1));
            Integer min = findMin(list);
            maze[row][col] = current;
            return min == null ? null : min + 1;
        }

        private Integer findMin(List<Integer> list) {
            Integer min = null;

            for (Integer current : list) {
                if (current != null && (min == null || min.compareTo(current) > 0)) {
                    min = current;
                }
            }
            return min;
        }
    }

    private static boolean isBoardersViolated(int n, int m, int row, int col) {
        return row < 0 || row >= n || col < 0 || col >= m;
    }

    private static boolean isExitFound(int n, int m, int row, int col) {
        return row == 0 || col == 0 || row == n - 1 || col == m - 1;
    }
}
