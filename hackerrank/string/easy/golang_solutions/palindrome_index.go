package golang_solutions

func palindromeIndex(s string) int32 {
	// Write your code here
	idx := tryRemove(s, true)
	if idx < 0 {
		return tryRemove(s, false)
	}
	return idx
}

func tryRemove(s string, isLeftSide bool) int32 {
	left, right := 0, len(s)-1

	runes := []rune(s)

	toRemove := 1
	idxToFind := -1

	for left < right {
		if runes[left] != runes[right] && toRemove == 0 {
			return -1
		} else if runes[left] != runes[right] {
			toRemove--
			if isLeftSide && runes[left+1] == runes[right] {
				idxToFind = left
				left++
			} else if !isLeftSide && runes[right-1] == runes[left] {
				idxToFind = right
				right--
			}
		}
		left++
		right--
	}
	return int32(idxToFind)
}
