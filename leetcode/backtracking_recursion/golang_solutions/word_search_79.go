package golang_solutions

var n int
var m int
var symbol = byte('*')

func exist(board [][]byte, word string) bool {
	n, m = len(board), len(board[0])

	for i := range board {
		for j := range board[i] {
			if board[i][j] == word[0] && isWordExists(board, i, j, 0, word) {
				return true
			}
		}
	}
	return false
}

func isWordExists(board [][]byte, row, col, idx int, word string) bool {
	if idx >= len(word) {
		return true
	}
	if areBoardersViolated(row, col) {
		return false
	}
	current := board[row][col]
	if current == symbol || current != word[idx] {
		return false
	}
	board[row][col] = symbol

	isExists := isWordExists(board, row+1, col, idx+1, word) ||
		isWordExists(board, row-1, col, idx+1, word) ||
		isWordExists(board, row, col+1, idx+1, word) ||
		isWordExists(board, row, col-1, idx+1, word)

	board[row][col] = current
	return isExists
}

func areBoardersViolated(row, col int) bool {
	return row < 0 || row >= n || col < 0 || col >= m
}
