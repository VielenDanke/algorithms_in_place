package golang_solutions

func uniqueOccurrences(arr []int) bool {
	m := make(map[int]int)
	s := make(map[int]interface{})
	for _, v := range arr {
		m[v]++
	}
	for _, v := range m {
		if _, ok := s[v]; ok {
			return false
		}
		s[v] = nil
	}
	return true
}
