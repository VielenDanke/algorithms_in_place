package golang_solutions

import "strings"

func twoStringsSimpleAnswer(s1 string, s2 string) string {
	// Write your code here
	left, right := make([]int, 26, 26), make([]int, 26, 26)

	for _, v := range []rune(s1) {
		left[v-'a']++
	}
	for _, v := range []rune(s2) {
		right[v-'a']++
	}
	for i := 0; i < 26; i++ {
		if left[i] > 0 && right[i] > 0 {
			return "YES"
		}
	}
	return "NO"
}

func twoStringsBruteForce(s1 string, s2 string) string {
	// Write your code here
	if isContainSubstring(s1, s2) || isContainSubstring(s2, s1) {
		return "YES"
	}
	return "NO"
}

func isContainSubstring(s1, s2 string) bool {
	step := 1

	for step < len(s1) {
		for i := 0; i+step <= len(s1); i++ {
			if strings.Contains(s2, s1[i:(i+step)]) {
				return true
			}
		}
		step++
	}
	return false
}
