package golang_solutions

import "math"

// fastest
func minimumOneBitOperationsFastest(n int) int {
	multiplier, result := 1, 0
	for n > 0 {
		result += n ^ (n-1)*multiplier
		multiplier = -1 * multiplier
		n &= n - 1
	}
	return int(math.Abs(float64(result)))
}

// memoization

var cache = make(map[int]int)

func minimumOneBitOperationsMemoization(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}
	if val, ok := cache[n]; ok {
		return val
	}
	s := int(math.Log2(float64(n)))
	mask, xorMask := 1<<s-1, 1<<(s-1)
	res := minimumOneBitOperationsMemoization(n&mask^xorMask) + minimumOneBitOperationsMemoization(xorMask) + 1
	cache[n] = res
	return res
}

// optimal

func minimumOneBitOperations(n int) int {
	if n <= 1 {
		return n
	}
	count := 0
	for 1<<count <= n {
		count++
	}
	return 1<<count - 1 - minimumOneBitOperations(n-(1<<(count-1)))
}
