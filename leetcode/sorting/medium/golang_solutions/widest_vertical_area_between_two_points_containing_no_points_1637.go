package golang_solutions

import (
	"math"
	"sort"
)

func maxWidthOfVerticalArea(points [][]int) (maxDiff int) {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})
	for i := 1; i < len(points); i++ {
		maxDiff = int(math.Max(float64(maxDiff), float64(points[i][0]-points[i-1][0])))
	}
	return
}
