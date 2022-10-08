package golang_solutions

func MinSubArrayLen(target int, nums []int) int {
	start, end, currentSum, minLength := 0, 0, 0, 1<<31

	for end < len(nums) {
		currentSum += nums[end]
		end++
		for start < end && currentSum >= target {
			difference := end - start
			if minLength > difference {
				minLength = difference
			}
			currentSum -= nums[start]
			start++
		}
	}
	if minLength == 1<<31 {
		return 0
	}
	return minLength
}
