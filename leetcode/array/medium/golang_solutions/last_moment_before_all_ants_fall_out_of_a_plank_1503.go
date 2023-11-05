package golang_solutions

import "math"

func getLastMoment(n int, left []int, right []int) (maxVal int) {
	for idx := range left {
		maxVal = int(math.Max(float64(maxVal), float64(left[idx])))
	}
	for idx := range right {
		maxVal = int(math.Max(float64(maxVal), float64(n-right[idx])))
	}
	return
}
