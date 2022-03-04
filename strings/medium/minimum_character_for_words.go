package medium

import "strings"

func MinimumCharactersForWords(words []string) []string {
	main := make(map[string]int)
	for _, word := range words {
		for _, character := range word {
			calculateAndUpdateAmount(main, word, character)
		}
	}
	result := make([]string, 0)
	for k, v := range main {
		for i := 0; i < v; i++ {
			result = append(result, k)
		}
	}
	return result
}

func calculateAndUpdateAmount(main map[string]int, word string, character rune) {
	chStr := string(character)
	amount := strings.Count(word, chStr)
	if prevAmount, ok := main[chStr]; ok {
		main[chStr] = max(amount, prevAmount)
	} else {
		main[chStr] = amount
	}
}

func max(f, s int) int {
	if f > s {
		return f
	}
	return s
}
