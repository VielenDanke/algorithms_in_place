package easy

func InsertionSort(nums []int) {
	for j := 1; j < len(nums); j++ {
		current := nums[j]

		i := j - 1

		for i >= 0 && nums[i] > current {
			nums[i], nums[i+1] = nums[i+1], nums[i]
			i--
		}
	}
}
