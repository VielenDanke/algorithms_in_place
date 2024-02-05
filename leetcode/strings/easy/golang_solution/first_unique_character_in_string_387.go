package golang_solution

func firstUniqChar(s string) int {
	alph := make([]int, 26)
	for _, v := range s {
		alph[v-'a']++
	}
	for i, v := range s {
		if alph[v-'a'] == 1 {
			return i
		}
	}
	return -1
}
