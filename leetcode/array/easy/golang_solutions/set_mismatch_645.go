package golang_solutions

import "sort"

func findErrorNumsSort(nums []int) []int {
	sort.Ints(nums)
	n, left, right, missing, twice, minNum, maxNum := len(nums), 0, 1, 0, 0, min(nums[0], nums[1]), max(nums[0], nums[1])

	for right < n {
		minNum = min(minNum, nums[right])
		maxNum = max(maxNum, nums[right])

		if nums[left] == nums[right] {
			twice = nums[left]
		} else if nums[right]-nums[left] > 1 {
			missing = (nums[left] + nums[right]) / 2
		}
		right++
		left++
	}
	second := missing
	if second == 0 {
		if minNum == 1 {
			second = maxNum + 1
		} else {
			second = 1
		}
	}
	return []int{twice, second}
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// ----------------------------------------------------------------------

func findErrorNums(nums []int) []int {
	arr := make([]int, len(nums)+1)

	for _, v := range nums {
		arr[v]++
	}
	result := make([]int, 2)
	for i := 1; i <= len(nums); i++ {
		if arr[i] > 1 {
			result[0] = i
		} else if arr[i] == 0 {
			result[1] = i
		}
	}
	return result
}
