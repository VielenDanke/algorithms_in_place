package graph.medium.java_solutions;

import java.util.*;

public class PathWithMinimumEffort_1631 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int rowLength = heights.length;
        int columnLength = heights[0].length;
        int[][] weightPath = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            Arrays.fill(weightPath[i], Integer.MAX_VALUE);
        }
        weightPath[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(left -> left[2]));

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int row = pair[0], column = pair[1];
            if (row == rowLength - 1 && column == columnLength - 1) {
                break;
            }
            for (int[] direction : DIR) {
                int nextRow = row + direction[0];
                int nextColumn = column + direction[1];

                if (nextRow < 0 || nextColumn < 0 || nextRow >= rowLength || nextColumn >= columnLength) {
                    continue;
                }
                int alt = Math.max(pair[2], Math.abs(heights[row][column] - heights[nextRow][nextColumn]));
                if (alt < weightPath[nextRow][nextColumn]) {
                    pq.add(new int[]{nextRow, nextColumn, weightPath[nextRow][nextColumn] = alt});
                }
            }
        }
        return weightPath[rowLength - 1][columnLength - 1];
    }

    // -------------------------------------------------------------------------------------------------------

    public int minimumEffortPathDFS(int[][] heights) {
        int left = 0, right = 1000000;
        while (left < right) {
            int m = left + ((right - left) >> 1);
            if (dfs(heights, 0, 0, heights[0][0], m, new boolean[heights.length][heights[0].length])) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] h, int i, int j, int prev, int limit, boolean[][] visited) {
        if (i < 0 || i >= h.length || j < 0 || j >= h[0].length || visited[i][j] || Math.abs(h[i][j] - prev) > limit) {
            return false;
        }
        visited[i][j] = true;
        return (i == h.length - 1 && j == h[0].length - 1) ||
                dfs(h, i - 1, j, h[i][j], limit, visited) ||
                dfs(h, i + 1, j, h[i][j], limit, visited) ||
                dfs(h, i, j - 1, h[i][j], limit, visited) ||
                dfs(h, i, j + 1, h[i][j], limit, visited);
    }
}
