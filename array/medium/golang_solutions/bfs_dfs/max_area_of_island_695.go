package bfs_dfs

func maxAreaOfIsland(grid [][]int) (max int) {
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				if currentMax := findMaxIsland(grid, i, j); currentMax > max {
					max = currentMax
				}
			}
		}
	}
	return
}

func findMaxIsland(grid [][]int, x, y int) int {
	if x < 0 || x >= len(grid) {
		return 0
	}
	if y < 0 || y >= len(grid[0]) {
		return 0
	}
	if grid[x][y] == 0 {
		return 0
	}
	grid[x][y] = 0
	return findMaxIsland(grid, x+1, y) +
		findMaxIsland(grid, x-1, y) +
		findMaxIsland(grid, x, y+1) +
		findMaxIsland(grid, x, y-1) + 1
}
