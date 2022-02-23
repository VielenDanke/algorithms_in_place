package medium

func findPairs(arr []int, k int) (result int) {
	m := make(map[int]int)

	for _, v := range arr {
		m[v]++
	}
	for x := range m {
		_, ok := m[x+k]
		val := m[x]
		if k > 0 && ok || k == 0 && val > 1 {
			result++
		}
	}
	return result
}
