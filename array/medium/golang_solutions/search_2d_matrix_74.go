package golang_solutions

func searchMatrix(matrix [][]int, target int) bool {
	row, col := 0, len(matrix[0])-1
	for row < len(matrix) && col >= 0 {
		if matrix[row][col] > target {
			col--
		} else if matrix[row][col] < target {
			row++
		} else {
			return true
		}
	}
	return false
}
