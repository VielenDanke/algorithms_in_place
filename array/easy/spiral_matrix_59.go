package easy

func GenerateMatrix(n int) [][]int {
	// create matrix
	matrix := make([][]int, n)

	for i := range matrix {
		matrix[i] = make([]int, n)

		for j := range matrix[i] {
			matrix[i][j] = -1 << 31
		}
	}
	// fill matrix
	// track next number
	// right -> down -> left from last column - 1 -> up from last row - 1 till start row + 1
	// (till idx where row of right is starts)
	nextNumber := 1

	fill(matrix, n*n, 0, n, 0, n, nextNumber)

	return matrix
}

func fill(matrix [][]int, n, startRow, endRow, startColumn, endColumn, nextNumber int) {
	if nextNumber > n {
		return
	}
	for j := startColumn; j < endColumn; j++ {
		matrix[startRow][j] = nextNumber
		nextNumber++
		if nextNumber > n {
			return
		}
	}
	for i := startRow + 1; i < endRow; i++ {
		matrix[i][endColumn-1] = nextNumber
		nextNumber++
		if nextNumber > n {
			return
		}
	}
	for i := endColumn - 2; i >= startColumn; i-- {
		matrix[endRow-1][i] = nextNumber
		nextNumber++
		if nextNumber > n {
			return
		}
	}
	for i := endRow - 2; i >= startRow+1; i-- {
		matrix[i][startColumn] = nextNumber
		nextNumber++
		if nextNumber > n {
			return
		}
	}
	fill(matrix, n, startRow+1, endRow-1, startColumn+1, endColumn-1, nextNumber)
}
