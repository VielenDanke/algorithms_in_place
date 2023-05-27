package golang_solutions

func alternatingCharacters(s string) (result int32) {
	// Write your code here
	runes := []rune(s)

	for idx, v := range runes {
		if idx != 0 && v == runes[idx-1] {
			result++
		}
	}
	return
}
