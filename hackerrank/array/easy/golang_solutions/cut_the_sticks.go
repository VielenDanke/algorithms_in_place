package golang_solutions

// https://www.hackerrank.com/challenges/cut-the-sticks/problem

func cutTheSticks(arr []int32) []int32 {
	collector := make([]int32, 0)
	for len(arr) > 0 {
		min := int32(1 << 30)
		collector = append(collector, int32(len(arr)))
		newArr := make([]int32, 0)
		for _, v := range arr {
			min = minVal(min, v)
		}
		for _, v := range arr {
			if min < v {
				newArr = append(newArr, v-min)
			}
		}
		arr = newArr
	}
	return collector
}

func minVal(a, b int32) int32 {
	if a > b {
		return b
	}
	return a
}
