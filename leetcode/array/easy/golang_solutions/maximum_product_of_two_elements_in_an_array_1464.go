package golang_solutions

import "sort"

// iterative

func maxProduct(nums []int) int {
	firstMax, secondMax := -1<<30, -1<<30

	for _, currentNumber := range nums {
		if currentNumber >= firstMax {
			secondMax = firstMax
			firstMax = currentNumber
		} else if currentNumber > secondMax {
			secondMax = currentNumber
		}
	}
	return (firstMax - 1) * (secondMax - 1)
}

// sort

func maxProductBruteForce(nums []int) int {
	n := len(nums)
	if n < 2 {
		return -1
	}
	sort.Ints(nums)
	return (nums[n-1] - 1) * (nums[n-2] - 1)
}
