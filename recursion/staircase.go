package recursion

func NumWays(n int) int {
	if n == 0 || n == 1 {
		return 1
	} else {
		return NumWays(n-1) + NumWays(n-2)
	}
}

func NumWaysDynamic(n int, memo map[int]int) int {
	if val, ok := memo[n]; ok {
		return val
	}
	if n == 0 || n == 1 {
		return 1
	} else {
		val := NumWaysDynamic(n-1, memo) + NumWaysDynamic(n-2, memo)
		memo[n] = val
		return val
	}
}
