package golang_solutions

// https://www.hackerrank.com/challenges/string-construction/problem?isFullScreen=true

func stringConstruction(s string) (cost int32) {
	letters := make([]int, 26)

	for i := 0; i < len(s); i++ {
		current := s[i] - 'a'
		if letters[current] == 0 {
			cost++
			letters[current]++
		}
	}
	return cost
}
