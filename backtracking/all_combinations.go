package backtracking

func Combine(n int, k int) [][]int {
	// 1 to n combinations with k
	// meaning using backtracking
	result := make([][]int, 0)
	backtrack(&result, make([]int, 0), 1, n, k)
	return result
}

func backtrack(result *[][]int, combination []int, start, n, k int) {
	if len(combination) == k {
		copiedArr := make([]int, 0)
		for _, v := range combination {
			copiedArr = append(copiedArr, v)
		}
		*result = append(*result, copiedArr)
		return
	}
	for i := start; i < n+1; i++ {
		combination = append(combination, i)
		backtrack(result, combination, start+1, n, k)
		combination = combination[:len(combination)-1]
	}
}
