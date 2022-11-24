package leetcode.graph.easy.java_solutions;

public class IslandPerimeter_463 {

    static class Solution {
        public int islandPerimeter(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        result += 4;
                        if (i > 0 && grid[i - 1][j] == 1) result -= 2;
                        if (j > 0 && grid[i][j - 1] == 1) result -= 2;
                    }
                }
            }
            return result;
        }
    }
}
