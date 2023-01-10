package golang_solutions

import (
	"sort"
	"strings"
)

func bigSorting(a []string) []string {
	sort.Slice(a, func(i, j int) bool {
		if len(a[i]) == len(a[j]) {
			return strings.Compare(a[i], a[j]) == -1
		}
		return len(a[i]) < len(a[j])
	})
	return a
}
