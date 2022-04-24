package bfs_dfs

var counter int

func maxAreaOfIsland(grid [][]int) (max int) {
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				findMaxIsland(grid, i, j)
				if max < counter {
					max = counter
				}
				counter = 0
			}
		}
	}
	return
}

func findMaxIsland(grid [][]int, x, y int) {
	if x < 0 || x >= len(grid) {
		return
	}
	if y < 0 || y >= len(grid[0]) {
		return
	}
	if grid[x][y] == 0 {
		return
	}
	grid[x][y] = 0
	counter++
	findMaxIsland(grid, x+1, y)
	findMaxIsland(grid, x-1, y)
	findMaxIsland(grid, x, y+1)
	findMaxIsland(grid, x, y-1)
}
