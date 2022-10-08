package golang_solution

import (
	"strings"
)

func WordPattern(pattern string, s string) bool {
	array := strings.Split(s, " ")

	if len(pattern) != len(array) {
		return false
	}
	association := make(map[rune]string)
	reverseAssociation := make(map[string]rune)

	runes := []rune(pattern)

	for i := 0; i < len(runes) && i < len(array); i++ {
		r := runes[i]
		if val, ok := association[r]; ok {
			if val != array[i] {
				return false
			}
		} else {
			if _, ok := reverseAssociation[array[i]]; ok {
				return false
			} else {
				association[r] = array[i]
				reverseAssociation[array[i]] = r
			}
		}
	}
	return true
}
