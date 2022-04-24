package golang_solutions

import (
	"fmt"
)

func isValidSudoku(board [][]byte) bool {
	// validate rows
	current := make(map[byte]int)
	for i := range board {
		for j := range board[i] {
			if string(board[i][j]) != "." {
				current[board[i][j]]++
				if current[board[i][j]] > 1 {
					return false
				}
			}
		}
		current = make(map[byte]int)
	}
	// validate columns
	for j := range board[0] {
		for i := range board {
			if string(board[i][j]) != "." {
				current[board[i][j]]++
				if current[board[i][j]] > 1 {
					return false
				}
			}
		}
		current = make(map[byte]int)
	}
	for i := 0; i < len(board); i += 3 {
		for j := 0; j < len(board[0]); j += 3 {
			if !validateSquare(board, i, j, make(map[byte]int)) {
				return false
			}
		}
	}
	return true
}

func validateSquare(board [][]byte, row, column int, current map[byte]int) bool {
	for i := row; i < row+3; i++ {
		for j := column; j < column+3; j++ {
			if string(board[i][j]) != "." {
				current[board[i][j]]++
				if current[board[i][j]] > 1 {
					return false
				}
			}
		}
	}
	return true
}

// ################################

func isValidSudoku2(board [][]byte) bool {
	validMap := make(map[string]interface{})
	for i := range board {
		for j := range board {
			if string(board[i][j]) != "." {
				rowKey := createKey("r", i, board[i][j])
				columnKey := createKey("c", j, board[i][j])
				boardKey := createKey("b", (i/3)*3+j/3, board[i][j])
				if _, ok := validMap[rowKey]; ok {
					return false
				}
				if _, ok := validMap[columnKey]; ok {
					return false
				}
				if _, ok := validMap[boardKey]; ok {
					return false
				}
				validMap[rowKey] = nil
				validMap[columnKey] = nil
				validMap[boardKey] = nil
			}
		}
	}
	return true
}

func createKey(direction string, currentPoint int, currentElement byte) string {
	return fmt.Sprintf("%s-%d-%d", direction, currentPoint, currentElement)
}
