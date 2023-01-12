package golang_solutions

import "unicode"

func camelcase(s string) (words int32) {
	if len(s) == 0 {
		return
	}
	letters := []rune(s)
	for _, v := range letters {
		if unicode.IsUpper(v) {
			if words == 0 {
				words += 2
			} else {
				words += 1
			}
		}
	}
	if words == 0 {
		return 1
	}
	return
}
