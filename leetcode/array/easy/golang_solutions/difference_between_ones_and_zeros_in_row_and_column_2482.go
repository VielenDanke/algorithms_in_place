package golang_solutions

func onesMinusZeros(grid [][]int) [][]int {
	// count ones and zeroes per row and column

	n, m := len(grid), len(grid[0])

	rows := make([]int, n+n)
	columns := make([]int, m+m)

	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				rows[i]++
				columns[j]++
			} else {
				rows[i+n]++
				columns[j+m]++
			}
		}
	}
	for i := range grid {
		for j := range grid[i] {
			grid[i][j] = rows[i] + columns[j] - rows[i+n] - columns[j+m]
		}
	}
	return grid
}
