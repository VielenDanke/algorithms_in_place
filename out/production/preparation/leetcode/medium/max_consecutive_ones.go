package medium

func LongestOnes(nums []int, k int) int {
	// k - flipping tries
	// iterate over array and count flip times, when live is over take a length and move the pointer
	maxLength := -1 << 31
	temp := k
	for idx := range nums {
		var i int
		for i = idx; i < len(nums); i++ {
			if nums[i] == 1 {
				continue
			}
			if temp == 0 {
				break
			}
			if nums[i] != 1 {
				temp--
			}
		}
		temp = k
		if maxLength < i-idx {
			maxLength = i - idx
		}
	}
	return maxLength
}
