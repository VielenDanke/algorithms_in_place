package medium

import (
	"math"
	"sort"
)

func kClosest(points [][]int, k int) [][]int {
	sort.Slice(points, func(i, j int) bool {
		firstPoint := sqrt(float64(points[i][0]), float64(points[i][1]))
		secondPoint := sqrt(float64(points[j][0]), float64(points[j][1]))
		return firstPoint < secondPoint
	})
	return points[:k]
}

func sqrt(x, y float64) float64 {
	xSquare, ySquare := (0-x)*(0-x), (0-y)*(0-y)
	return math.Sqrt(xSquare + ySquare)
}
