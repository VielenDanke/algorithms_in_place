package main

func NumberOfWaysToMakeChange2(n int, denoms []int) int {
	// Write your code here.
	ways := make([]int, n+1)
	ways[0] = 1
	for _, denom := range denoms {
		for amount := 1; amount < n+1; amount++ {
			if denom <= amount {
				ways[amount] += ways[amount-denom]
			}
		}
	}
	return ways[n]
}

func NumberOfWaysToMakeChange(n int, denoms []int) int {
	// Write your code here.
	memo := make(map[int]int)
	return changeCoin(n, denoms, memo)
}

func changeCoin(n int, denoms []int, memo map[int]int) (sum int) {
	if n == 0 {
		return 1
	}
	if n < 0 {
		return 0
	}
	for idx, v := range denoms {
		remainder := n - v
		sum += changeCoin(remainder, denoms[idx:], memo)
		memo[n] = sum
	}
	memo[n] = sum
	return sum
}
