package golang_solutions

func MaxProduct(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	max := -1 << 31
	for i := 0; i < len(nums); i++ {
		temp := nums[i]
		for j := i + 1; j < len(nums); j++ {
			if max < temp {
				max = temp
			} else {
				break
			}
			temp *= nums[j]
		}
		if max < temp {
			max = temp
		}
	}
	return max
}

func maxProduct(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	max := nums[0]
	min := nums[0]
	result := nums[0]
	for i := 1; i < len(nums); i++ {
		num := nums[i]
		oldMax := max
		oldMin := min
		max = maxOfThree(num, num*oldMax, num*oldMin)
		min = minOfThree(num, num*oldMax, num*oldMin)
		result = maxOfTwo(result, max)
	}
	return result
}

func maxOfTwo(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxOfThree(a, b, c int) int {
	return maxOfTwo(maxOfTwo(a, b), c)
}

func minOfTwo(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minOfThree(a, b, c int) int {
	return minOfTwo(minOfTwo(a, b), c)
}
