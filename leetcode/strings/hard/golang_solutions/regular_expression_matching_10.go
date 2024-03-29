package golang_solutions

func isMatch(s string, p string) bool {
	memo := make([][]bool, len(s)+1)
	visited := make([][]bool, len(s)+1)
	for i := range memo {
		memo[i] = make([]bool, len(p)+1)
		visited[i] = make([]bool, len(p)+1)
	}
	return dp(0, 0, s, p, memo, visited)
}

func dp(i, j int, s, p string, memo, visited [][]bool) bool {
	if visited[i][j] {
		return memo[i][j]
	}
	var result bool

	if j >= len(p) {
		result = i == len(s)
	} else {
		isFirstMatch := i < len(s) && (p[j] == s[i] || p[j] == '.')

		if j+1 < len(p) && p[j+1] == '*' {
			result = dp(i, j+2, s, p, memo, visited) || (isFirstMatch && dp(i+1, j, s, p, memo, visited))
		} else {
			result = isFirstMatch && dp(i+1, j+1, s, p, memo, visited)
		}
	}
	memo[i][j] = result
	visited[i][j] = true
	return memo[i][j]
}
