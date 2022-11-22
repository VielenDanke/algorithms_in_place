package golang_solutions

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)

	childIdx, result := 0, 0

	for i := 0; i < len(s); i++ {
		if g[childIdx] <= s[i] {
			result++
			childIdx++
		}
	}
	return result
}
