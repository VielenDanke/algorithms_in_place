package golang_solutions

import "fmt"

func CountIslands(grid [][]string) (countIslands int) {
	visited := make(map[string]interface{})
	for i := range grid {
		for j := range grid[i] {
			if exploreGrid(grid, visited, i, j) {
				countIslands++
			}
		}
	}
	return
}

func exploreGrid(grid [][]string, visited map[string]interface{}, row, column int) bool {
	rowInbounds := 0 <= row && row < len(grid)
	columnInbounds := 0 <= column && column < len(grid[0])

	if !rowInbounds || !columnInbounds {
		return false
	}
	if grid[row][column] == "W" {
		return false
	}
	visitKey := createVisitedKey(row, column)
	if _, ok := visited[visitKey]; ok {
		return false
	}
	visited[visitKey] = nil

	exploreGrid(grid, visited, row-1, column)
	exploreGrid(grid, visited, row+1, column)
	exploreGrid(grid, visited, row, column-1)
	exploreGrid(grid, visited, row, column+1)

	return true
}

func createVisitedKey(row, column int) string {
	return fmt.Sprintf("%d-%d", row, column)
}
