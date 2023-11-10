package golang_solutions

func restoreArray(adjacentPairs [][]int) []int {
	m := make(map[int][]int)
	for _, pair := range adjacentPairs {
		m[pair[0]] = append(m[pair[0]], pair[1])
		m[pair[1]] = append(m[pair[1]], pair[0])
	}
	result := make([]int, 0)
	for k, v := range m {
		if len(v) == 1 {
			dfsAdjacent(&result, k, m)
			return result
		}
	}
	return []int{}
}

func dfsAdjacent(result *[]int, key int, m map[int][]int) {
	if _, ok := m[key]; !ok {
		return
	}
	*result = append(*result, key)
	nextPossibleKeys := m[key]
	delete(m, key)
	for _, nextKey := range nextPossibleKeys {
		if nextKey != key {
			dfsAdjacent(result, nextKey, m)
		}
	}
}
