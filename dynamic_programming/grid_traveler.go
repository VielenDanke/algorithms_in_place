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

func gridTravelerTabulation(rows, column int) int {
	var tab [][]int

	for i := 0; i < rows+1; i++ {
		tab = append(tab, []int{})
		for j := 0; j < column+1; j++ {
			tab[i] = append(tab[i], 0)
		}
	}
	tab[1][1] = 1
	for i := 0; i < len(tab); i++ {
		for j := 0; j < len(tab[i]); j++ {
			current := tab[i][j]
			if j+1 < len(tab[i]) {
				tab[i][j+1] += current
			}
			if i+1 < len(tab) {
				tab[i+1][j] += current
			}
		}
	}
	return tab[rows][column]
}

func main() {
	rows, column := 18, 18

	fmt.Printf("Result: %v", gridTravelerTabulation(rows, column))
}
