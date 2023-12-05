package golang_solutions

// optimal
// n teams, only 1 should stay, n - 1 matches should be played

func numberOfMatchesOptimal(n int) int {
	return n - 1
}

// brute force

func numberOfMatches(n int) int {
	if n == 2 {
		return 1
	}
	var matches int
	for n > 1 {
		matches += n / 2
		if n%2 == 0 {
			n /= 2
		} else {
			n = (n-1)/2 + 1
		}
	}
	return matches
}
