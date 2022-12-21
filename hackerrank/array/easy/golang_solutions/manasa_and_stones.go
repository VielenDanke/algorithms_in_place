package golang_solutions

import "sort"

func stones(n, a, b int32) (result []int32) {
	set := make(map[int32]interface{})
	for i := int32(0); i < n; i++ {
		set[(i*a)+(n-i-1)*b] = nil
	}
	for k := range set {
		result = append(result, k)
	}
	sort.Slice(result, func(i, j int) bool {
		return result[i] < result[j]
	})
	return
}

// ----------------------------------------------------------------------

func stonesBacktrack(n, a, b int32) (result []int32) {
	permutations := make([][]int32, 0)

	backtrack(&permutations, make([]int32, 0), n, a, b)

	set := make(map[int32]interface{})

	for _, perm := range permutations {
		temp := int32(0)

		for _, v := range perm {
			temp += v
		}
		if _, ok := set[temp]; !ok {
			result = append(result, temp)
			set[temp] = nil
		}
	}
	return
}

func backtrack(permutations *[][]int32, temp []int32, n, a, b int32) {
	if int32(len(temp)) == n-1 {
		*permutations = append(*permutations, append(make([]int32, 0), temp...))
		return
	}
	backtrack(permutations, append(temp, a), n, a, b)
	backtrack(permutations, append(temp, b), n, a, b)
}
