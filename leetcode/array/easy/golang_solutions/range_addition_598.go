package golang_solutions

func maxCount(m int, n int, ops [][]int) int {
	minRow, minCol := m, n

	for _, v := range ops {
		minRow = minVal(minRow, v[0])
		minCol = minVal(minCol, v[1])
	}
	return minRow * minCol
}

func minVal(a, b int) int {
	if a > b {
		return b
	}
	return a
}
