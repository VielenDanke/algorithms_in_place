package main

import "fmt"

func minGrid(grid [][]int) int {
	return travel(0, 0, grid, make(map[string]int))
}

func travel(row int, column int, grid [][]int, memo map[string]int) int {
	if val, ok := memo[createKey(row, column)]; ok {
		return val
	}
	if row >= len(grid) || column >= len(grid[0]) {
		return 1 << 31
	}
	if row == len(grid)-1 && column == len(grid[0])-1 {
		return grid[row][column]
	}
	memoResult := grid[row][column] + min(travel(row+1, column, grid, nil), travel(row, column+1, grid, nil))
	memo[createKey(row, column)] = memoResult
	return memoResult
}

func createKey(f, s int) string {
	return fmt.Sprintf("%d,%d", f, s)
}

func minTravel(f, s int) int {
	if f > s {
		return s
	}
	return f
}
