package golang_solutions

func SearchInSortedMatrix(matrix [][]int, target int) []int {
	// Write your code here.
	row, col := 0, len(matrix[0])-1
	for row < len(matrix) && col >= 0 {
		if matrix[row][col] > target {
			col--
		} else if matrix[row][col] < target {
			row++
		} else {
			return []int{row, col}
		}
	}
	return []int{-1, -1}
}
