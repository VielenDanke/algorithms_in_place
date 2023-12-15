package golang_solutions

func destCityBrute(paths [][]string) string {
	m := make(map[string]int)
	for _, path := range paths {
		m[path[0]]++
	}
	for _, path := range paths {
		if m[path[1]] == 0 {
			return path[1]
		}
	}
	return ""
}
