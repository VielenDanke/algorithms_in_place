package golang_solutions

import "sort"

func sortedSquares(nums []int) []int {
	start, end := 0, len(nums)-1
	output := make([]int, len(nums))
	for i := end; i >= 0; i-- {
		startNum := nums[start] * nums[start]
		endNum := nums[end] * nums[end]
		if startNum > endNum {
			output[i] = startNum
			start++
		} else {
			output[i] = endNum
			end--
		}
	}
	return output
}

func sortedSquaresSort(nums []int) []int {
	for i, v := range nums {
		nums[i] = v * v
	}
	sort.Ints(nums)
	return nums
}
