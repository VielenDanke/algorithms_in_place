package golang_solutions

func numSquares(n int) int {
	powers := calculatePowers(n)

	dp := prepareDP(n)

	for _, power := range powers {
		for i := 0; i <= n; i++ {
			if i-power >= 0 && dp[i-power] != -1 {
				if dp[i] == -1 {
					dp[i] = dp[i-power] + 1
				} else {
					dp[i] = minVal(dp[i], dp[i-power]+1)
				}
			}
		}
	}
	return dp[n]
}

func prepareDP(n int) []int {
	dp := make([]int, n+1, n+1)

	for i := range dp {
		dp[i] = -1
	}
	dp[0] = 0
	return dp
}

func minVal(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func calculatePowers(n int) []int {
	powers := make([]int, 0)

	for i := 1; i <= n; i++ {
		if i*i > n {
			break
		} else {
			powers = append(powers, i*i)
		}
	}
	return powers
}
