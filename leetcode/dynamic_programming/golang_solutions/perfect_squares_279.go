package golang_solutions

func numSquares(n int) int {
	powers := calculatePowers(n)

	powersDP := make([]int, n+1)

	for i := range powersDP {
		powersDP[i] = -1
	}
	powersDP[0] = 0

	for _, power := range powers {
		for i := 0; i < n+1; i++ {
			if i-power >= 0 && powersDP[i-power] != -1 {
				if powersDP[i] == -1 {
					powersDP[i] = powersDP[i-power] + 1
				} else {
					powersDP[i] = minVal(powersDP[i], powersDP[i-power]+1)
				}
			}
		}
	}
	return powersDP[n]
}

// ------------------------------------------------------------------------------------

var cachePerfectSquares []int

func numSquaresMemo(n int) int {
	powers := calculatePowers(n)

	cachePerfectSquares = make([]int, n+1)

	for i := range cache {
		cachePerfectSquares[i] = -1
	}
	return backtrackPerfectSquares(powers, 0, n)
}

func backtrackPerfectSquares(powers []int, temp, n int) int {
	if temp == n {
		return 0
	}
	if cachePerfectSquares[temp] != -1 {
		return cachePerfectSquares[temp]
	}
	squaresMin := 1 << 30
	for _, v := range powers {
		if temp+v <= n {
			squaresMin = minVal(backtrackPerfectSquares(powers, temp+v, n)+1, squaresMin)
		}
	}
	cachePerfectSquares[temp] = squaresMin
	return squaresMin
}

func calculatePowers(n int) []int {
	powers := make([]int, 0)
	for i := 1; i*i <= n; i++ {
		powers = append(powers, i*i)
	}
	return powers
}

func minVal(a, b int) int {
	if a > b {
		return b
	}
	return a
}
