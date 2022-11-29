package golang_solutions

// https://www.hackerrank.com/challenges/queens-attack-2/problem

var directions = [][]int32{{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}

func queensAttack(n int32, k int32, r_q int32, c_q int32, obstacles [][]int32) (result int32) {
	// Write your code here
	obstaclesMap := make(map[int32]map[int32]interface{})
	for _, v := range obstacles {
		if _, ok := obstaclesMap[v[0]]; !ok {
			obstaclesMap[v[0]] = make(map[int32]interface{})
		}
		obstaclesMap[v[0]][v[1]] = nil
	}
	for _, v := range directions {
		result += collectPossibleMoves(n, r_q, c_q, v, obstaclesMap)
	}
	return
}

func collectPossibleMoves(n, row, col int32, direction []int32, obstacles map[int32]map[int32]interface{}) int32 {
	result := int32(-1)
	for !isBoarderViolated(row, col, n) && !isObstacleFound(row, col, obstacles) {
		row += direction[0]
		col += direction[1]
		result++
	}
	return result
}

func isObstacleFound(row, col int32, obstacles map[int32]map[int32]interface{}) (isFound bool) {
	_, isFound = obstacles[row][col]
	return
}

func isBoarderViolated(row, col, n int32) bool {
	return row < 1 || col < 1 || row > n || col > n
}
