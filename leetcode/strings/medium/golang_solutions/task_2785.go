package golang_solutions

import (
	"sort"
	"strings"
)

func sortVowels(str string) string {
	vowels := "aeiouAEIOU"
	isVowel := func(ch byte) bool {
		return strings.ContainsRune(vowels, rune(ch))
	}

	// Extract vowels
	var extracted []byte
	for i := 0; i < len(str); i++ {
		if isVowel(str[i]) {
			extracted = append(extracted, str[i])
		}
	}

	// Sort vowels
	sort.Slice(extracted, func(i, j int) bool {
		return extracted[i] < extracted[j]
	})

	// Rebuild string
	result := []byte(str)
	vowelIndex := 0
	for i := 0; i < len(result); i++ {
		if isVowel(result[i]) {
			result[i] = extracted[vowelIndex]
			vowelIndex++
		}
	}

	return string(result)
}
