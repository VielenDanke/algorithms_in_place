package hard

func splitArray(nums []int, m int) int {
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	left, right := 0, sum
	for left <= right {
		mid := left + (right-left)/2
		if splitArrayHelper(nums, m-1, mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return left
}

func splitArrayHelper(nums []int, cut int, limit int) bool {
	temp := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] > limit {
			return false
		}
		if temp+nums[i] > limit {
			cut--
			if cut < 0 {
				return false
			}
			temp = nums[i]
		} else {
			temp += nums[i]
		}
	}
	return true
}
