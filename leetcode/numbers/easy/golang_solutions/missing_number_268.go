package golang_solutions

import "sort"

func missingNumber(nums []int) int {
	min, max := 1<<31, -1<<31
	set := make(map[int]interface{})

	for _, v := range nums {
		set[v] = nil
		if min > v {
			min = v
		}
		if max < v {
			max = v
		}
	}
	for i := min; i <= max; i++ {
		if _, ok := set[i]; !ok {
			return i
		}
	}
	if min > 0 {
		return min - 1
	}
	return max + 1
}

func missingNumberBest(nums []int) int {
	sum := len(nums)
	for i := 0; i < len(nums); i++ {
		sum += i - nums[i]
	}
	return sum
}

func missingNumberConstantSpace(nums []int) (sum int) {
	length := len(nums)
	for _, v := range nums {
		sum += v
	}
	return length*(length+1)/2 - sum
}

func missingNumberWithSort(nums []int) int {
	sort.Ints(nums)

	for i := 0; i+1 < len(nums); i++ {
		if nums[i+1]-nums[i] != 1 {
			return i + 1
		}
	}
	if nums[0] != 0 {
		return nums[0] - 1
	}
	return nums[len(nums)-1] + 1
}
