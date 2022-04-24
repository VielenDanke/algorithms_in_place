package golang_solutions

// link https://leetcode.com/problems/product-of-array-except-self/

func productExceptSelf(nums []int) []int {
	zeroCounter := 0
	lastZeroIdx := 0
	commonProduct := 1

	for idx, v := range nums {
		if v == 0 {
			zeroCounter++
			lastZeroIdx = idx
		} else {
			commonProduct *= v
		}
	}
	if zeroCounter >= 2 {
		nums = make([]int, len(nums))
	} else if zeroCounter == 1 {
		nums = make([]int, len(nums))
		nums[lastZeroIdx] = commonProduct
	} else {
		for i := range nums {
			nums[i] = commonProduct / nums[i]
		}
	}
	return nums
}
