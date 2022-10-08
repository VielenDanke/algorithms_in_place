package leetcode.array.medium.java_solutions;

public class MaxAreaOfIsland_695 {

    public int maxAreaOfIsland(int[][] grid) {
        var max = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                var currentMax = exploreIsland(grid, i, j);
                if (max < currentMax) {
                    max = currentMax;
                }
            }
        }
        return max;
    }

    private int exploreIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return exploreIsland(grid, i + 1, j) +
                exploreIsland(grid, i - 1, j) +
                exploreIsland(grid, i, j + 1) +
                exploreIsland(grid, i, j - 1) + 1;
    }

}
