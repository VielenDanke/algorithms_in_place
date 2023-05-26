package golang_solutions

func gemstones(arr []string) (result int32) {
	// Write your code here
	m := make(map[rune]map[int]interface{})

	for idx, v := range arr {
		for _, r := range v {
			if _, ok := m[r]; !ok {
				m[r] = make(map[int]interface{})
			}
			m[r][idx] = nil
		}
	}
	for _, v := range m {
		if len(v) == len(arr) {
			result++
		}
	}
	return
}
