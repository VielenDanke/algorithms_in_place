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
	if len(nums) < 2 {
		return -1
	}
	sort.Ints(nums)
	return (nums[len(nums)-1] - 1) * (nums[len(nums)-2] - 1)
}
