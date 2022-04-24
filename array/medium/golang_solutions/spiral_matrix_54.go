package golang_solutions

func spiralOrder(matrix [][]int) (result []int) {
	resultLength := len(matrix) * len(matrix[0])
	collectInMatrix(matrix, &result, 0, 0, len(matrix), len(matrix[0]), resultLength)
	return
}

func collectInMatrix(matrix [][]int, result *[]int, row, column, endRow, endColumn, resultLength int) {
	for i := column; i < endColumn; i++ {
		*result = append(*result, matrix[row][i])
		if len(*result) == resultLength {
			return
		}
	}
	for i := row + 1; i < endRow; i++ {
		*result = append(*result, matrix[i][endColumn-1])
		if len(*result) == resultLength {
			return
		}
	}
	for i := endColumn - 2; i >= column; i-- {
		*result = append(*result, matrix[endRow-1][i])
		if len(*result) == resultLength {
			return
		}
	}
	for i := endRow - 2; i >= row+1; i-- {
		*result = append(*result, matrix[i][column])
		if len(*result) == resultLength {
			return
		}
	}
	collectInMatrix(matrix, result, row+1, column+1, endRow-1, endColumn-1, resultLength)
}
