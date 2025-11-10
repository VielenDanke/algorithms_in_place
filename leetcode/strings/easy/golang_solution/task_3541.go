package golang_solution

import "math"

func maxFreqSum(s string) int {
	counter := make(map[rune]int)
	for _, v := range s {
		counter[v]++
	}
	left, right := 0, 0
	for k, v := range counter {
		if isVowelRune(k) {
			left = int(math.Max(float64(left), float64(v)))
		} else {
			right = int(math.Max(float64(right), float64(v)))
		}
	}
	return left + right
}

func isVowelRune(c rune) bool {
	return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U'
}
