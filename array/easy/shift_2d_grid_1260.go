package easy

func ShiftGrid(grid [][]int, k int) [][]int {
	// calculate amount of elements
	// find new place for each grid
	rowLen := len(grid[0])
	matrixLen := len(grid)

	matrix := make([][]int, len(grid))

	for idx := range matrix {
		matrix[idx] = make([]int, rowLen)
	}

	for i := range grid {
		for j := range grid[i] {
			num := grid[i][j]

			tempIdx := j + k

			if tempIdx >= rowLen {
				nextRow := tempIdx/rowLen + i
				if nextRow >= matrixLen {
					nextRow = nextRow % matrixLen
				}
				tempIdx = tempIdx % rowLen
				matrix[nextRow][tempIdx] = num
			} else {
				matrix[i][tempIdx] = num
			}
		}
	}
	return matrix
}
