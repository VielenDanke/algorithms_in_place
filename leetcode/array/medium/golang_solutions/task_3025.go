package golang_solutions

import "sort"

func numberOfPairs(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		if points[i][0] == points[j][0] {
			return points[i][1] > points[j][1] // y descending
		}
		return points[i][0] < points[j][0] // x ascending
	})

	n := len(points)
	result := 0

	for i := 0; i < n; i++ {
		top := points[i][1]
		bot := -1 << 31
		for j := i + 1; j < n; j++ {
			y := points[j][1]
			if bot < y && y <= top {
				result++
				bot = y
				if bot == top {
					break
				}
			}
		}
	}
	return result
}
