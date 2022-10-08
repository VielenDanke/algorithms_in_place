package golang_solutions

func minPathSum(grid [][]int) int {
	return step(grid, 0, 0, make(map[string]int))
}

func step(grid [][]int, row, column int, memo map[string]int) int {
	key := createKey(row, column)

	if val, ok := memo[key]; ok {
		return val
	}
	if row >= len(grid) || column >= len(grid[0]) || row < 0 || column < 0 {
		return 1 << 31
	}
	if row == len(grid)-1 && column == len(grid[0])-1 {
		return grid[row][column]
	}
	left := step(grid, row+1, column, memo)
	right := step(grid, row, column+1, memo)

	memo[key] = grid[row][column] + min(left, right)

	return memo[key]
}

func minPathSumTabulation(grid [][]int) int {
	row := len(grid)
	column := len(grid[0])

	dp := make([][]int, row)
	for i := range dp {
		dp[i] = make([]int, column)
	}

	for i := row - 1; i >= 0; i-- {
		for j := column - 1; j >= 0; j-- {
			currElem := grid[i][j]

			if i == row-1 && j == column-1 {
				dp[i][j] = currElem
			} else if i == row-1 {
				dp[i][j] = dp[i][j+1] + currElem
			} else if j == column-1 {
				dp[i][j] = dp[i+1][j] + currElem
			} else {
				dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + currElem
			}
		}
	}
	return dp[0][0]
}
