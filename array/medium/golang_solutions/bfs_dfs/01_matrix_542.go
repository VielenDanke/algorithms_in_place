package bfs_dfs

func updateMatrix(mat [][]int) [][]int {
	rows := len(mat)
	cols := len(mat[0])

	queue := make([][]int, 0)

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if mat[i][j] == 0 {
				// add all 0 values from what we are able to expand
				queue = append(queue, []int{i, j})
			} else {
				// mark other values as -1 - means they are not explored yet
				mat[i][j] = -1
			}
		}
	}
	// all directions - left, right, up, down
	dir := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	var curr []int

	// explore all
	for len(queue) > 0 {
		curr, queue = queue[0], queue[1:]

		for i := 0; i < 4; i++ {
			newRow := curr[0] + dir[i][0]
			newCol := curr[1] + dir[i][1]
			// check boarders and next point is not explored
			if newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || mat[newRow][newCol] != -1 {
				continue
			}
			// add current position + 1 to next position
			mat[newRow][newCol] = mat[curr[0]][curr[1]] + 1
			// add next point to explore
			queue = append(queue, []int{newRow, newCol})
		}
	}
	return mat
}
