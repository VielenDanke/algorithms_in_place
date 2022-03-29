package medium

// O(N^2) time | O(1) space
func findDuplicateBruteForce(nums []int) int {
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[j] == nums[i] {
				return nums[i]
			}
		}
	}
	return -1
}

// O(N) time | O(N) space
func findDuplicateWithSet(nums []int) int {
	// using map as set with nil values
	set := make(map[int]interface{})

	for _, v := range nums {
		if _, ok := set[v]; ok {
			return v
		}
		set[v] = nil
	}
	return -1
}

// O(N) time | O(1) space
func findDuplicate(nums []int) int {
	for nums[0] != nums[nums[0]] {
		nums[0], nums[nums[0]] = nums[nums[0]], nums[0]
	}
	return nums[0]
}
