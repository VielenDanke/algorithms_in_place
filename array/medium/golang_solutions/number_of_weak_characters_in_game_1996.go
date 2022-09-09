package golang_solutions

import "sort"

func numberOfWeakCharacters(properties [][]int) int {
	sort.Slice(properties, func(i, j int) bool {
		left, right := properties[i], properties[j]
		if left[0] == right[0] {
			return left[1] < right[1]
		} else {
			return right[0] < left[0]
		}
	})
	max, weak := 0, 0
	for _, ch := range properties {
		if ch[1] < max {
			weak++
		}
		max = findMax(max, ch[1])
	}
	return weak
}

func findMax(left, right int) int {
	if left > right {
		return left
	}
	return right
}
