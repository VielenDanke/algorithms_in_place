package golang_solutions

func maximumProfit(prices []int, k int) int64 {
	n := len(prices)
	memo := make(map[[2]int]int64)

	var dfs func(i, t int) int64
	dfs = func(i, t int) int64 {
		if t == 0 || i >= n-1 {
			return 0
		}

		key := [2]int{i, t}
		if v, ok := memo[key]; ok {
			return v
		}

		// Option 1: skip day i
		best := dfs(i+1, t)

		pi := int64(prices[i])

		// Option 2: start a transaction at day i
		for j := i + 1; j < n; j++ {
			pj := int64(prices[j])
			profit := abs(pj-pi) + dfs(j+1, t-1)
			best = max(best, profit)
		}

		memo[key] = best
		return best
	}

	return dfs(0, k)
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

func abs(x int64) int64 {
	if x < 0 {
		return -x
	}
	return x
}
