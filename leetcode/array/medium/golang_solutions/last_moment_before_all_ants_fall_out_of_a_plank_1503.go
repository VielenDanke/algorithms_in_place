package golang_solutions

func getLastMoment(n int, left []int, right []int) (maxVal int) {
	for idx := range left {
		maxVal = max(maxVal, left[idx])
	}
	for idx := range right {
		maxVal = max(maxVal, n-right[idx])
	}
	return
}
