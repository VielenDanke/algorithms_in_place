package golang_solutions

// optimal
// n teams, only 1 should stay, n - 1 matches should be played

func numberOfMatchesOptimal(n int) int {
	return n - 1
}

// brute force

func numberOfMatches(n int) (matches int) {
	for n >= 2 {
		matches += n / 2
		if n%2 == 0 {
			n /= 2
		} else {
			n = (n-1)/2 + 1
		}
	}
	return
}
