package golang_solutions

func numOfWays(n int) int {
	const MOD = 1_000_000_007

	var backtrack func(i, n, prev1, prev2, prev3 int, memo [][][][]int64) int64

	backtrack = func(i, n, prev1, prev2, prev3 int, memo [][][][]int64) int64 {
		if i >= n {
			return 1
		}
		if memo[i][prev1][prev2][prev3] != -1 {
			return memo[i][prev1][prev2][prev3]
		}

		result := int64(0)

		for col1 := 1; col1 <= 3; col1++ {
			if col1 == prev1 {
				continue
			}
			for col2 := 1; col2 <= 3; col2++ {
				if col2 == col1 || col2 == prev2 {
					continue
				}
				for col3 := 1; col3 <= 3; col3++ {
					if col3 == col2 || col3 == prev3 {
						continue
					}
					result = (result + backtrack(i+1, n, col1, col2, col3, memo)) % MOD
				}
			}
		}
		memo[i][prev1][prev2][prev3] = result
		return result % MOD
	}

	memo := make([][][][]int64, n)

	for i := range memo {
		memo[i] = make([][][]int64, 4)
		for j := range memo[i] {
			memo[i][j] = make([][]int64, 4)
			for k := range memo[i][j] {
				memo[i][j][k] = make([]int64, 4)
				for p := range memo[i][j][k] {
					memo[i][j][k][p] = int64(-1)
				}
			}
		}
	}

	return int(backtrack(0, n, 0, 0, 0, memo))
}
