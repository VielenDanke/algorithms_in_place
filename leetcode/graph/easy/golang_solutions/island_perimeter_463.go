package golang_solutions

func islandPerimeter(grid [][]int) int {
	result := 0
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				result += 4
				if i > 0 && grid[i-1][j] == 1 {
					result -= 2
				}
				if j > 0 && grid[i][j-1] == 1 {
					result -= 2
				}
			}
		}
	}
	return result
}
