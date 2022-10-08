package golang_solutions

func searchTwo(nums []int, target int) bool {
	min, max := 0, len(nums)-1

	for min <= max {
		middle := (min + max) / 2

		if target == nums[middle] {
			return true
		} else if nums[middle] > nums[min] {
			if nums[min] <= target && target < nums[middle] {
				max = middle - 1
			} else {
				min = middle + 1
			}
		} else if nums[middle] < nums[min] {
			if nums[middle] < target && target < nums[min] {
				min = middle + 1
			} else {
				max = middle - 1
			}
		} else {
			min++
		}
	}
	return false
}
