package golang_solutions

import (
	"sort"
)

func checkArithmeticSubarraysBruteForce(nums []int, l []int, r []int) []bool {
	// every 2 consecutive elements with the same difference
	// range query [l[i], r[i]]
	result := make([]bool, len(l))
	for i := range l {
		leftIdx, rightIdx := l[i], r[i]
		subNums := make([]int, rightIdx-leftIdx+1)
		copy(subNums, nums[leftIdx:rightIdx+1])
		sort.Ints(subNums)
		result[i] = checkIfMatched(subNums)
	}
	return result
}

func checkIfMatched(subNums []int) bool {
	expectedDifference := -1 << 30
	isMatched := true
	for i := 0; i+1 < len(subNums); i++ {
		difference := subNums[i+1] - subNums[i]
		if expectedDifference == -1<<30 {
			expectedDifference = difference
		} else {
			if expectedDifference != difference {
				isMatched = false
				break
			}
		}
	}
	return isMatched
}
