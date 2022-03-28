package medium

func search(nums []int, target int) int {
	min, max := 0, len(nums)-1

	for min <= max {
		middle := (min + max) / 2

		if nums[middle] == target {
			return middle
		} else if nums[middle] >= nums[min] {
			if nums[min] <= target && target <= nums[middle] {
				max = middle - 1
			} else {
				min = middle + 1
			}
		} else {
			if nums[middle] <= target && target <= nums[max] {
				min = middle + 1
			} else {
				max = middle - 1
			}
		}
	}
	return -1
}
