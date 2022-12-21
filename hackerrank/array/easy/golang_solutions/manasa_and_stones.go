package golang_solutions

import "sort"

func stones(n, a, b int32) (result []int32) {
	result = append(result, a*n)
	result = append(result, b*n)

	visited := make(map[int32]interface{})

	for i := int32(1); i <= n/2; i++ {
		aResult := (a * i) + (b * (n - i))
		bResult := (b * i) + (a * (n - i))

		if _, ok := visited[aResult]; !ok {
			visited[aResult] = nil
			result = append(result, aResult)
		}
		if _, ok := visited[bResult]; !ok {
			visited[bResult] = nil
			result = append(result, bResult)
		}
	}
	sort.Slice(result, func(i, j int) bool {
		return result[i] < result[j]
	})
	return
}

// ----------------------------------------------------------------------

func stonesBacktrack(n int32, a int32, b int32) (result []int32) {
	// Write your code here
	permutations := make([][]int32, 0)

	backtrack(&permutations, make([]int32, 0), n, a, b)

	set := make(map[int32]interface{})

	for _, perm := range permutations {
		temp := perm[0] + perm[1]
		if _, ok := set[temp]; !ok {
			result = append(result, temp)
			set[temp] = nil
		}
	}
	return
}

func backtrack(permutations *[][]int32, temp []int32, n, a, b int32) {
	if int32(len(temp)) == n {
		*permutations = append(*permutations, append(make([]int32, 0), temp...))
		return
	}
	for i := a; i <= b; i++ {
		temp = append(temp, i)
		backtrack(permutations, temp, n, a, b)
		temp = temp[:len(temp)-1]
	}
}
