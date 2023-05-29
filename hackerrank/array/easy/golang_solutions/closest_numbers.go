package golang_solutions

import (
	"math"
	"sort"
)

func closestNumbers(arr []int32) []int32 {
	// Write your code here
	sort.Slice(arr, func(x, y int) bool {
		return arr[x] < arr[y]
	})
	minDiff := int32(1 << 30)

	for idx, v := range arr {
		if idx != 0 {
			minDiff = int32(math.Min(float64(minDiff), float64(v-arr[idx-1])))
		}
	}
	result := make([]int32, 0)

	for idx, v := range arr {
		if idx != 0 && (v-arr[idx-1] == minDiff) {
			result = append(result, arr[idx-1], v)
		}
	}
	return result
}
