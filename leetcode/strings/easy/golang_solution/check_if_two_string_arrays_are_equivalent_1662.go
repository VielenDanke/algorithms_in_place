package golang_solution

import (
	"strings"
)

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	return strings.Join(word1, "") == strings.Join(word2, "")
}

func arrayStringsAreEqualNoExtraSpace(word1 []string, word2 []string) bool {
	leftIndex, rightIndex, leftLetterIndex, rightLetterIndex := 0, 0, 0, 0

	for leftIndex < len(word1) && rightIndex < len(word2) {
		if word1[leftIndex][leftLetterIndex] != word2[rightIndex][rightLetterIndex] {
			return false
		}
		leftLetterIndex++
		rightLetterIndex++
		if leftLetterIndex >= len(word1[leftIndex]) {
			leftIndex++
			leftLetterIndex = 0
		}
		if rightLetterIndex >= len(word2[rightIndex]) {
			rightIndex++
			rightLetterIndex = 0
		}
	}
	return leftIndex == len(word1) && rightIndex == len(word2)
}
