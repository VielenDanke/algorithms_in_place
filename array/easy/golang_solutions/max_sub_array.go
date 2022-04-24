package golang_solutions

func MaxSubArray(nums []int) int {
	max, maxSub := -1<<63, 0

	for _, v := range nums {
		maxSub += v
		if maxSub > max {
			max = maxSub
		}
		if maxSub < 0 {
			maxSub = 0
		}
	}
	return max
}
