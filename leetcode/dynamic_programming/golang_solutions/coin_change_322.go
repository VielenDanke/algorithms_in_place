package golang_solutions

var globalMin int

// Time limit

func coinChange(coins []int, amount int) int {
	globalMin = 1 << 31
	recursive(coins, amount, 0)
	if globalMin == 1<<31 {
		return -1
	}
	return globalMin
}

func recursive(coins []int, amount int, counter int) {
	if amount == 0 {
		if counter < globalMin {
			globalMin = counter
		}
		return
	}
	if amount < 0 {
		return
	}
	for i := 0; i < len(coins); i++ {
		amount -= coins[i]
		if amount < 0 {
			continue
		}
		recursive(coins, amount, counter+1)
		amount += coins[i]
	}
}

// -------------------------------------------------------------------------

// 78.28 Time | 98.41 Space

func coinChangeTabulation(coins []int, amount int) int {
	if amount < 0 {
		return -1
	}
	dp := make([]int, amount+1)
	dp[0] = 0
	for i := 1; i < amount+1; i++ {
		dp[i] = -1
	}
	for _, coin := range coins {
		for i := 1; i <= amount; i++ {
			if i-coin >= 0 && dp[i-coin] != -1 {
				if dp[i] == -1 {
					dp[i] = dp[i-coin] + 1
				} else {
					dp[i] = min(dp[i], dp[i-coin]+1)
				}
			}
		}

	}
	return dp[amount]
}
