package golang_solutions

func GameOfLife(board [][]int) {
	nextState := make([][]int, 0)

	for range board {
		nextState = append(nextState, make([]int, len(board[0])))
	}
	for i := range board {
		for j := range board[i] {
			_, liveCell := walk(board, i, j)
			if isLiveCell(board[i][j]) {
				if liveCell < 2 {
					nextState[i][j] = 0
				} else if liveCell <= 3 {
					nextState[i][j] = 1
				} else {
					nextState[i][j] = 0
				}
			} else {
				if liveCell == 3 {
					nextState[i][j] = 1
				}
			}
		}
	}
	for i := range board {
		for j := range board[i] {
			board[i][j] = nextState[i][j]
		}
	}
}

func walk(board [][]int, i, j int) (deadCell, liveCell int) {
	if i-1 >= 0 && j-1 >= 0 {
		addCell(board[i-1][j-1], &deadCell, &liveCell)
	}
	if i-1 >= 0 && j+1 < len(board[i]) {
		addCell(board[i-1][j+1], &deadCell, &liveCell)
	}
	if i-1 >= 0 {
		addCell(board[i-1][j], &deadCell, &liveCell)
	}
	if j+1 < len(board[i]) {
		addCell(board[i][j+1], &deadCell, &liveCell)
	}
	if j-1 >= 0 {
		addCell(board[i][j-1], &deadCell, &liveCell)
	}
	if i+1 < len(board) && j-1 >= 0 {
		addCell(board[i+1][j-1], &deadCell, &liveCell)
	}
	if i+1 < len(board) {
		addCell(board[i+1][j], &deadCell, &liveCell)
	}
	if i+1 < len(board) && j+1 < len(board[0]) {
		addCell(board[i+1][j+1], &deadCell, &liveCell)
	}
	return
}

func addCell(cell int, deadCell, liveCell *int) {
	if isLiveCell(cell) {
		*liveCell++
	} else {
		*deadCell++
	}
}

func isLiveCell(cell int) bool {
	return cell == 1
}
