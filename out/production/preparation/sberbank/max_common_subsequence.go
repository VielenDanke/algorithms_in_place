package sberbank

func MaxCommonSubsequence(s string, k int, stringGoal string) int {
	textPointer, goalPointer := 0, 0

	textRunes, goalRunes := []rune(s), []rune(stringGoal)

	max := 0

	for i := 0; i < len(textRunes); i++ {
		textPointer = i
		maxCommon := 0
		for textPointer < len(textRunes) && goalPointer < len(goalRunes) {
			if k < 0 {
				break
			}
			if textRunes[textPointer] == goalRunes[goalPointer] {
				maxCommon++
				textPointer++
				goalPointer++
			} else if textRunes[textPointer] != goalRunes[goalPointer] {
				textPointer++
				k--
			}
		}
		if maxCommon > max {
			max = maxCommon
		}
	}
	return max + k
}
