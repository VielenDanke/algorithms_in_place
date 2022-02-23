package sberbank

func RemoveSymbols(s string, k int, stringGoal string) int {
	// Write your code here...
	textRunes, goalRunes := []rune(s), []rune(stringGoal)

	textPointer, goalPointer := 0, 0

	for textPointer < len(textRunes) && goalPointer < len(goalRunes) {
		if textRunes[textPointer] != goalRunes[goalPointer] && k > 0 {
			k--
			textPointer++
			continue
		}
		textPointer++
		goalPointer++
	}
	return abs(goalPointer, len(goalRunes))
}

func abs(i, j int) int {
	if i < j {
		return i
	}
	return j
}
