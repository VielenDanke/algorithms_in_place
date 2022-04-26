package golang_solution

func CharacterReplacement(s string, k int) int {
	runes := []rune(s)
	length := len(runes)
	charCount := make([]int, 26)

	maxCount := 0
	windowStart := 0
	max := 0

	for windowEnd := 0; windowEnd < length; windowEnd++ {
		charCount[runes[windowEnd]-'A']++
		maxCount = maxCharCount(maxCount, charCount[runes[windowEnd]-'A'])

		for windowEnd-windowStart-maxCount+1 > k {
			charCount[runes[windowStart]-'A']--
			windowStart++
		}
		max = maxCharCount(max, windowEnd-windowStart+1)
	}
	return max
}

func maxCharCount(f, s int) int {
	if f > s {
		return f
	}
	return s
}
