package golang_solutions

import "math"

/*
Input: leetcode.array of leetcode.numbers
Output: maxVal sum of non-adjacent leetcode.numbers
*/

func MaxSubsetSumNoAdjacent(array []int) int {
	// Write your code here.
	arrLen := len(array)
	if arrLen == 0 {
		return 0
	} else if len(array) == 1 {
		return array[0]
	}
	maxSums := make([]int, len(array))
	maxSums[0], maxSums[1] = array[0], maxVal(array[0], array[1])
	for i := 2; i < len(array); i++ {
		maxSums[i] = maxVal(maxSums[i-1], maxSums[i-2]+array[i])
	}
	return maxSums[len(array)-1]
}

func maxVal(vals ...int) int {
	maxVal := math.MinInt

	for _, v := range vals {
		if maxVal < v {
			maxVal = v
		}
	}
	return maxVal
}

// ---------------------------------------------------------------

// Backtracking solution (find all possible sums)
var globalMax int

func MaxSubsetSumNoAdjacentBacktracking(array []int) (max int) {
	globalMax = 0

	defer func() {
		globalMax = 0
	}()
	for i := 0; i < len(array); i++ {
		backtrackMaxSubsetSumNonAdjacent(array, i, 0)
	}
	max = globalMax

	return max
}

func backtrackMaxSubsetSumNonAdjacent(array []int, start int, sum int) {
	for i := start; i < len(array); i++ {
		backtrackMaxSubsetSumNonAdjacent(array, i+2, sum+array[i])
	}
	if sum > globalMax {
		globalMax = sum
	}
}

// --------------------------------------------------------------

// Backtracking without global variable

func MaxSubsetSumNoAdjacentBacktrackingWithoutGlobal(array []int) (max int) {
	for i := 0; i < len(array); i++ {
		tempMax := backtrackingWithoutGlobal(array, i)
		if max < tempMax {
			max = tempMax
		}
	}
	return
}

func backtrackingWithoutGlobal(array []int, start int) int {
	if start >= len(array) {
		return 0
	}
	maxSum := 0
	for i := start; i < len(array); i++ {
		maxSum = maxVal(maxSum, backtrackingWithoutGlobal(array, i+2)+array[i])
	}
	return maxSum
}
