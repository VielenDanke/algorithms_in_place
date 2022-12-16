package golang_solutions

func serviceLane(n int32, width []int32, cases [][]int32) []int32 {
	// Write your code here
	l := len(cases)
	result := make([]int32, l, l)

	for idx, v := range cases {
		left, right, minNum := min(v[0], v[1]), max(v[0], v[1]), int32(1<<30)
		for i := left; i <= right; i++ {
			minNum = min(minNum, width[i])
		}
		result[idx] = minNum
	}
	return result
}

func max(a, b int32) int32 {
	if a > b {
		return a
	}
	return b
}

func min(a, b int32) int32 {
	if a < b {
		return a
	}
	return b
}
