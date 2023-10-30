package golang_solutions

import (
	"sort"
	"math/bits"
)

func sortByBits(arr []int) []int {
	sort.Slice(arr, func(i, j int) bool {
		left, right, leftCount, rightCount := arr[i], arr[j], 0, 0
		for left > 0 {
			leftCount += left & 1
			left >>= 1
		}
		for right > 0 {
			rightCount += right & 1
			right >>= 1
		}
		if leftCount == rightCount {
			return arr[i] < arr[j]
		}
		return leftCount < rightCount
	})
	return arr
}

func sortByBitsUsingInternalFunction(arr []int) []int {
	sort.Slice(arr, func(i, j int) bool {
		countI, countJ := bits.OnesCount(uint(arr[i])), bits.OnesCount(uint(arr[j]))
		if countI == countJ {
			return arr[i] < arr[j]
		}
		return countI < countJ
	})
	return arr
}
