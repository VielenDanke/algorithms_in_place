package golang_solutions

func findMaxForm(strs []string, m int, n int) int {
	ones := make([]int, len(strs))
	zeroes := make([]int, len(strs))

	for i, str := range strs {
		for j := range str {
			if str[j] == '0' {
				zeroes[i]++
			} else {
				ones[i]++
			}
		}
	}

	memo := make([][][]int, len(strs))
	for i := range memo {
		memo[i] = make([][]int, m+1)
		for j := range memo[i] {
			memo[i][j] = make([]int, n+1)
			for k := range memo[i][j] {
				memo[i][j][k] = -1
			}
		}
	}

	return dpHelper(strs, ones, zeroes, m, n, 0, memo)
}

func dpHelper(strs []string, ones, zeroes []int, m, n, idx int, memo [][][]int) int {
	if idx == len(strs) {
		return 0
	}
	if memo[idx][m][n] != -1 {
		return memo[idx][m][n]
	}
	maxCount := dpHelper(strs, ones, zeroes, m, n, idx+1, memo)

	if m >= zeroes[idx] && n >= ones[idx] {
		takeOption := 1 + dpHelper(strs, ones, zeroes, m-zeroes[idx], n-ones[idx], idx+1, memo)
		if takeOption > maxCount {
			maxCount = takeOption
		}
	}
	memo[idx][m][n] = maxCount
	return maxCount
}
