package golang_solutions

var directions = [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
var replaceSymbol byte = 126

func exist(board [][]byte, word string) bool {
	if len(word) == 0 {
		return true
	}
	for i := range board {
		for j := range board[i] {
			if explore(board, word, i, j) {
				return true
			}
		}
	}
	return false
}

func explore(board [][]byte, word string, i, j int) bool {
	if len(word) == 1 {
		return word[0] == board[i][j]
	}
	if board[i][j] != word[0] {
		return false
	}
	board[i][j] = replaceSymbol
	for _, dir := range directions {
		nextRow := i + dir[0]
		nextColumn := j + dir[1]

		if nextRow < 0 || nextColumn < 0 || nextRow >= len(board) || nextColumn >= len(board[0]) || board[nextRow][nextColumn] == replaceSymbol {
			continue
		}
		if explore(board, word[1:], nextRow, nextColumn) {
			return true
		}
	}
	board[i][j] = word[0]
	return false
}
