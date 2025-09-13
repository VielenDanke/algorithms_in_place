package golang_solutions

import "strings"

func doesAliceWin(s string) bool {
	// alice - odd
	// bob - even
	vowels := "aeiouAEIOU"

	for _, b := range s {
		if strings.ContainsRune(vowels, b) {
			return true
		}
	}
	return false
}
