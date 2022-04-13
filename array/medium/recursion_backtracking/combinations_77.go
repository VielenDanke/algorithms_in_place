package recursion_backtracking

func combine(n int, k int) [][]int {
	result := make([][]int, 0)
	backtrack(&result, make([]int, 0), k, n, 1)
	return result
}

func backtrack(result *[][]int, temp []int, k, n, start int) {
	if len(temp) == k {
		copyOf := make([]int, k)
		copy(copyOf, temp)
		*result = append(*result, copyOf)
		return
	}
	for i := start; i <= n; i++ {
		temp = append(temp, i)
		backtrack(result, temp, k, n, i+1)
		temp = temp[:len(temp)-1]
	}
}
