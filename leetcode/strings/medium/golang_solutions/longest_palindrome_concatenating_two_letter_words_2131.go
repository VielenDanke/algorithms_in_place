package golang_solutions

func longestPalindrome(words []string) (result int) {
	storage := make(map[string]int)

	for _, v := range words {
		storage[v]++
	}
	var isFound bool
	for _, v := range words {
		if v[0] == v[1] {
			wordAmount := storage[v]
			if wordAmount%2 != 0 {
				wordAmount--
				isFound = true
			}
			result += wordAmount * 2
			storage[v] -= wordAmount
		} else {
			newStr := string([]byte{v[1], v[0]})
			if _, ok := storage[v]; ok {
				min := minVal(storage[v], storage[newStr])
				result += (min * 2) * 2
				storage[v] -= min
				storage[newStr] -= min
			}
		}
	}
	if isFound {
		result += 2
	}
	return
}

func minVal(a, b int) int {
	if a > b {
		return b
	}
	return a
}
