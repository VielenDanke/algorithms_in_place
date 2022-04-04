package medium

// O(N) time | O(N) space

func rotate(nums []int, k int) {
	temp := make([]int, len(nums))
	for idx := range nums {
		newIdx := idx + k
		if newIdx >= len(nums) {
			newIdx = (idx + k) % len(nums)
		}
		temp[newIdx] = nums[idx]
	}
	for idx := range nums {
		nums[idx] = temp[idx]
	}
}

// ---------------------------------------------------

// O(N) time | O(1) space

func rotateConstantSpaceThreeReverse(nums []int, k int) {
	k = k % len(nums)
	reverseRotate(nums, 0, len(nums)-1)
	reverseRotate(nums, 0, k-1)
	reverseRotate(nums, k, len(nums)-1)
}

func reverseRotate(nums []int, left, right int) {
	for left < right {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right--
	}
}

// ---------------------------------------------------

// O(N * K) time | O(1) space

func rotateConstantSpace(nums []int, k int) {
	for k > 0 {
		prev := nums[0]
		nums[0] = nums[len(nums)-1]
		for i := 1; i < len(nums); i++ {
			temp := nums[i]
			nums[i] = prev
			prev = temp
		}
		k--
	}
}
