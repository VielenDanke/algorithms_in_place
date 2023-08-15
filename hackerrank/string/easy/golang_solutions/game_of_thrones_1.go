package golang_solutions

func gameOfThrones(s string) string {
	// Write your code here
	alph := make([]int, 26)

	for _, v := range s {
		alph[v-'a']++
	}
	odd := 0
	for _, v := range alph {
		if v%2 != 0 {
			odd++
		}
	}
	if odd > 1 {
		return "NO"
	}
	return "YES"
}
