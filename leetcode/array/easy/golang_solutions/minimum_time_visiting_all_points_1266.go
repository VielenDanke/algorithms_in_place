package golang_solutions

import "math"

// iteration

func minTimeToVisitAllPointsIteration(points [][]int) (seconds int) {
	for i := 1; i < len(points); i++ {
		seconds += int(math.Max(math.Abs(float64(points[i][0]-points[i-1][0])), math.Abs(float64(points[i][1]-points[i-1][1]))))
	}
	return
}

// recursion

func minTimeToVisitAllPoints(points [][]int) int {
	return move(0, points)
}

func move(idx int, points [][]int) int {
	if idx >= len(points)-1 {
		return 0
	}
	return move(idx+1, points) + int(math.Max(math.Abs(float64(points[idx+1][0]-points[idx][0])), math.Abs(float64(points[idx+1][1]-points[idx][1]))))
}
