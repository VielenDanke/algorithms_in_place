package main

import "fmt"

func gridTraveler(rows, column int) int {
	if rows == 0 || column == 0 {
		return 0
	}
	if rows == 1 && column == 1 {
		return 1
	}
	return gridTraveler(rows-1, column) + gridTraveler(rows, column-1)
}

// are the args in the memo
func gridTravelerMemo(rows, column int, memo map[string]int) int {
	uniqueKey := fmt.Sprintf("%d,%d", rows, column)
	if rows == 0 || column == 0 {
		return 0
	} else if rows == 1 && column == 1 {
		return 1
	} else if val, ok := memo[uniqueKey]; ok {
		return val
	} else {
		memo[uniqueKey] = gridTravelerMemo(rows-1, column, memo) + gridTravelerMemo(rows, column-1, memo)
		return memo[uniqueKey]
	}
}

func main() {
	fmt.Printf("Result: %d\n", gridTraveler(3, 7))
}
