package golang_solutions

import "math"

func isValid(s string) string {
	// Write your code here
	alph := make([]int, 26)
	min, max := 1<<30, -1<<30

	for _, v := range s {
		alph[v-'a']++
	}
	for _, v := range alph {
		if v == 0 {
			continue
		}
		min = int(math.Min(float64(min), float64(v)))
		max = int(math.Max(float64(max), float64(v)))
	}
	if math.Abs(float64(max-min)) > 1 {
		return "NO"
	}
	if max == min {
		return "YES"
	}
	diffCounter := 0
	for _, v := range alph {
		if v == 0 {
			continue
		}
		if min != v {
			diffCounter++
		}
	}
	if diffCounter <= 1 {
		return "YES"
	}
	return "NO"
}
