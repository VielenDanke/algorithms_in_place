package golang_solutions

func minOperations(nums []int) (result int) {
	counter := make(map[int]int)
	for _, v := range nums {
		counter[v]++
	}
	for _, v := range counter {
		for v > 0 {
			if v == 3 || v > 4 {
				v -= 3
			} else if v >= 2 {
				v -= 2
			} else {
				return -1
			}
			result++
		}
	}
	return
}
