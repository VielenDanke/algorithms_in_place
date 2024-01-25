package golang_solutions

func longestCommonSubsequence(text1 string, text2 string) int {
	dp := make([][]int, len(text1)+1)

	for i := range dp {
		dp[i] = make([]int, len(text2))
	}
	for i := 0; i < len(text1); i++ {
		for j := 0; j < len(text2); j++ {
			if text1[i] == text2[j] {
				dp[i+1][j+1] = 1 + dp[i][j]
			} else {
				dp[i+1][j+1] = maxVal(dp[i][j+1], dp[i+1][j])
			}
		}
	}
	return dp[len(text1)][len(text2)]
}

// ------------------------------------------------------------------------------------------------

func longestCommonSubsequenceMemo(text1 string, text2 string) int {
	memo := make([][]int, len(text1)+1)
	for i := range memo {
		memo[i] = make([]int, len(text2)+1)
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}
	return lcsMemo(text1, text2, len(text1), len(text2), memo)
}

func lcsMemo(text1, text2 string, n, m int, memo [][]int) int {
	if n == 0 || m == 0 {
		return 0
	}
	if memo[n][m] != -1 {
		return memo[n][m]
	}
	if text1[n-1] == text2[m-1] {
		memo[n][m] = 1 + lcsMemo(text1, text2, n-1, m-1, memo)
	} else {
		memo[n][m] = maxVal(lcsMemo(text1, text2, n-1, m, memo), lcsMemo(text1, text2, n, m-1, memo))
	}
	return memo[n][m]
}
