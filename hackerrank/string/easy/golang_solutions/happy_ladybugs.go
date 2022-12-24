package golang_solutions

func happyLadybugs(b string) string {
	// Write your code here
	m := make(map[rune]int)
	game := []rune(b)
	n := len(game)
	for _, v := range b {
		m[v]++
	}
	if _, ok := m['_']; ok {
		for k, v := range m {
			if k != '_' && v == 1 {
				return "NO"
			}
		}
	} else {
		if n == 1 || game[0] != game[1] || game[n-1] != game[n-2] {
			return "NO"
		}
		for i := 1; i < n-1; i++ {
			if game[i-1] != game[i] && game[i] != game[i+1] {
				return "NO"
			}
		}
	}
	return "YES"
}
