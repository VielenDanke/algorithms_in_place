package medium

func MinIslandSize(grid [][]string) (min int) {
	visited := make(map[string]interface{})

	min = 1 << 31

	for i := range grid {
		for j := range grid[i] {
			islandLength := findMinIsland(grid, visited, i, j)
			if islandLength < min && islandLength > 0 {
				min = islandLength
			}
		}
	}
	return
}

func findMinIsland(grid [][]string, visited map[string]interface{}, row, column int) (length int) {
	rowInbounds := 0 <= row && row < len(grid)
	columnInbounds := 0 <= column && column < len(grid[0])

	if !rowInbounds || !columnInbounds {
		return 0
	}
	if grid[row][column] == "W" {
		return 0
	}
	key := createVisitedKey(row, column)
	if _, ok := visited[key]; ok {
		return 0
	}
	visited[key] = nil
	length = 1
	length += findMinIsland(grid, visited, row-1, column)
	length += findMinIsland(grid, visited, row+1, column)
	length += findMinIsland(grid, visited, row, column+1)
	length += findMinIsland(grid, visited, row, column-1)
	return length
}
