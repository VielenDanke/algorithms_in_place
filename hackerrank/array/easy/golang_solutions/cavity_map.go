package golang_solutions

// https://www.hackerrank.com/challenges/cavity-map/problem

func cavityMap(grid []string) []string {
	// Write your code here
	matrix := make([][]rune, 0)

	for idx, v := range grid {
		matrix = append(matrix, make([]rune, 0))
		for _, ch := range v {
			matrix[idx] = append(matrix[idx], ch)
		}
	}
	n := len(matrix)

	for i := range matrix {
		for j := range matrix[i] {
			if i == 0 || i == n-1 || j == 0 || j == n-1 {
				continue
			}
			if isCavity(matrix, i, j) {
				matrix[i][j] = 'X'
			}
		}
	}
	for idx := range grid {
		grid[idx] = string(matrix[idx])
	}
	return grid
}

func isCavity(matrix [][]rune, i, j int) bool {
	current := matrix[i][j]

	return current-'0' > matrix[i-1][j]-'0' && current-'0' > matrix[i][j-1]-'0' && current-'0' > matrix[i+1][j]-'0' && current-'0' > matrix[i][j+1]-'0'
}
