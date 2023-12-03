package golang_solutions

import "math"

// iteration

func minTimeToVisitAllPointsIteration(points [][]int) (seconds int) {
	for i := 1; i < len(points); i++ {
		seconds += calculateMaxDiffBetweenPoints(i, i-1, points)
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
	return move(idx+1, points) + calculateMaxDiffBetweenPoints(idx+1, idx, points)
}

// common func

func calculateMaxDiffBetweenPoints(nextIdx, previousIdx int, points [][]int) int {
	return int(math.Max(math.Abs(float64(points[nextIdx][0]-points[previousIdx][0])), math.Abs(float64(points[nextIdx][1]-points[previousIdx][1]))))
}
