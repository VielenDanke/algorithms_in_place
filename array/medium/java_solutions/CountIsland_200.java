package array.medium.java_solutions;

public class CountIsland_200 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int rowLength = 0;
    private int colLength = 0;

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        this.rowLength = grid.length;
        this.colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void explore(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for (int[] direction : DIR) {
            explore(grid, row + direction[0], col + direction[1]);
        }
    }
}
