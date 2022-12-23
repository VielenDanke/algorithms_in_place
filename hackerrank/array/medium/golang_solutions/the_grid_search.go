package golang_solutions

func gridSearch(matrix []string, pattern []string) string {
	// Write your code here
	for i := range matrix {
		for j := range matrix[i] {
			if matrix[i][j] == pattern[0][0] {
				if isPatternFound(matrix, pattern, i, j) {
					return "YES"
				}
			}
		}
	}
	return "NO"
}

func isPatternFound(matrix []string, pattern []string, row, col int) bool {
	for i := range pattern {
		tempCol := col
		for j := range pattern[i] {
			if row >= len(matrix) || tempCol >= len(matrix[0]) || pattern[i][j] != matrix[row][tempCol] {
				return false
			}
			tempCol++
		}
		row++
	}
	return true
}
