package bfs_dfs

import "github.com/vielendanke/algorithms_in_place/array"

func updateMatrix(mat [][]int) [][]int {
	rows := len(mat)

	if rows == 0 {
		return mat
	}
	cols := len(mat[0])

	result := make([][]int, rows)

	queue := make([]*array.Pair, 0)

	for i := 0; i < rows; i++ {
		result[i] = make([]int, cols)
		for j := 0; j < cols; j++ {
			if mat[i][j] == 0 {
				result[i][j] = 0
				queue = append(queue, &array.Pair{Row: i, Col: j})
			} else {
				result[i][j] = 1 << 61
			}
		}
	}
	dir := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	var curr *array.Pair

	for len(queue) > 0 {
		curr, queue = queue[0], queue[1:]

		for i := 0; i < 4; i++ {
			newRow := curr.Row + dir[i][0]
			newCol := curr.Col + dir[i][1]
			if newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols {
				if result[newRow][newCol] > result[curr.Row][curr.Col]+1 {
					result[newRow][newCol] = result[curr.Row][curr.Col] + 1
					queue = append(queue, &array.Pair{Row: newRow, Col: newCol})
				}
			}
		}
	}
	return result
}
