package golang_solutions

var inverseMemo [][]int

func kInversePairs(n int, k int) int {
	inverseMemo = make([][]int, n+1)
	for i := range inverseMemo {
		inverseMemo[i] = make([]int, k+1)
		for j := range inverseMemo[i] {
			inverseMemo[i][j] = -1
		}
	}
	return calculate(n, k)
}

func calculate(n, k int) int {
	if k == 0 {
		return 1
	}
	if k < 0 || n <= 0 {
		return 0
	}
	if inverseMemo[n][k] != -1 {
		return inverseMemo[n][k]
	}
	inverseMemo[n][k] = (calculate(n-1, k) + calculate(n, k-1) - calculate(n-1, k-n) + mod) % mod
	return inverseMemo[n][k]
}
