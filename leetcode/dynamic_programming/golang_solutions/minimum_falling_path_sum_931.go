package golang_solutions

import "math"

var cache [][]int

func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	cache = make([][]int, n)
	for i := range cache {
		cache[i] = make([]int, n)
		for j := range cache[i] {
			cache[i][j] = math.MaxInt
		}
	}
	answer := math.MaxInt
	for i := 0; i < n; i++ {
		answer = min(answer, minSumPath(matrix, 0, i))
	}
	return answer
}

func minSumPath(matrix [][]int, row, col int) int {
	if row == len(matrix) {
		return 0
	}
	if cache[row][col] < math.MaxInt {
		return cache[row][col]
	}
	currentMin := math.MaxInt
	for i := col - 1; i <= col+1; i++ {
		if i < 0 || i >= len(matrix[0]) {
			continue
		}
		currentMin = min(currentMin, minSumPath(matrix, row+1, i)+matrix[row][i])
	}
	cache[row][col] = currentMin
	return currentMin
}
