package golang_solutions

func funnyString(s string) string {
	// Write your code here
	first := createAbsoluteDiffArray(createAsciiArray(s, false))
	second := createAbsoluteDiffArray(createAsciiArray(s, true))
	for idx := range first {
		if first[idx] != second[idx] {
			return "Not Funny"
		}
	}
	return "Funny"
}

func createAsciiArray(s string, isReverse bool) []int {
	alph := make([]int, 0)
	runes := []rune(s)
	if isReverse {
		for i := len(runes) - 1; i >= 0; i-- {
			alph = append(alph, int(runes[i]))
		}
		return alph
	}
	for _, v := range runes {
		alph = append(alph, int(v))
	}
	return alph
}

func createAbsoluteDiffArray(alph []int) []int {
	absDiffArray := make([]int, 0)

	for i, v := range alph {
		if i != 0 {
			absDiffArray = append(absDiffArray, absoluteDiff(v, alph[i-1]))
		}
	}
	return absDiffArray
}

func absoluteDiff(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}
