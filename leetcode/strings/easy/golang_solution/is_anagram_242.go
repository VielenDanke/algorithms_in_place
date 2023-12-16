package golang_solution

func isAnagram(s string, t string) bool {
	alph := make([]int, 26)
	for _, ch := range s {
		alph[ch-'a']++
	}
	for _, ch := range t {
		alph[ch-'a']--
	}
	for _, letterCount := range alph {
		if letterCount != 0 {
			return false
		}
	}
	return true
}
