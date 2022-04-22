package golang_solutions

func MinCostClimbingStairs(cost []int) (result int) {
	memo := make(map[int]int)
	return min(topDown(0, cost, memo), topDown(1, cost, memo))
}

func MinCostClimbingStairs2(cost []int) (result int) {
	n := len(cost) + 1
	dp := make([]int, n)
	dp[0] = cost[0]
	dp[1] = cost[1]
	for i := 2; i < n; i++ {
		t := min(dp[i-1], dp[i-2])
		if i < len(cost) {
			t += cost[i]
		}
		dp[i] = t
	}
	return dp[n-1]
}

func topDown(p int, cost []int, memo map[int]int) (result int) {
	if val, ok := memo[p]; ok {
		return val
	}
	if p >= len(cost) {
		return 0
	}
	tempRes := min(topDown(p+1, cost, memo), topDown(p+2, cost, memo)) + cost[p]
	memo[p] = tempRes
	return tempRes
}
