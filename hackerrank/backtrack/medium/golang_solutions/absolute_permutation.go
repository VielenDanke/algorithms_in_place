package golang_solutions

import "math"

func absolutePermutationBruteForce(n int32, k int32) []int32 {
	// Write your code here
	result := make([]int32, n, n)
	for i := range result {
		result[i] = 1 << 30
	}
	backtrackAbsolutePermutation(result, make([]int32, 0), n, k, make([]bool, n+1, n+1))
	if result[0] == 1<<30 {
		return []int32{-1}
	}
	return result
}

func backtrackAbsolutePermutation(result []int32, temp []int32, n, k int32, visited []bool) {
	if int32(len(temp)) == n {
		if isValidPermutation(temp, k) && (len(result) == 0 || isLexicographicallySmaller(result, temp)) {
			for i := range result {
				result[i] = temp[i]
			}
		}
		return
	}
	for i := int32(1); i <= n; i++ {
		if len(result) > 0 && len(temp) > 0 && temp[len(temp)-1] > result[len(temp)-1] {
			continue
		}
		if visited[i] {
			continue
		}
		visited[i] = true
		temp = append(temp, i)
		backtrackAbsolutePermutation(result, temp, n, k, visited)
		temp = temp[:len(temp)-1]
		visited[i] = false
	}
}

func isLexicographicallySmaller(result, temp []int32) bool {
	for i := range result {
		if result[i] > temp[i] {
			return true
		}
	}
	return false
}

func isValidPermutation(temp []int32, k int32) bool {
	for i, v := range temp {
		if int32(math.Abs(float64(v-int32(i+1)))) != k {
			return false
		}
	}
	return true
}
