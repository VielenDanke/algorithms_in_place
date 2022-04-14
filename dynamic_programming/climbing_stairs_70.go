package dynamic_programming

func climbStairs(n int) int {
	return climbStairsMemo(n, make(map[int]int))
}

func climbStairsMemo(n int, memo map[int]int) int {
	if val, ok := memo[n]; ok {
		return val
	}
	if n <= 1 {
		return 1
	}
	result := climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo)
	memo[n] = result
	return result
}
