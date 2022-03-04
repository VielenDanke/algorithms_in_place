package medium

import "sort"

func GroupAnagrams(anagrams []string) [][]string {
	anagramTable := make(map[string][]string)

	for _, word := range anagrams {
		sortedWord := sortWord(word)
		anagramTable[sortedWord] = append(anagramTable[sortedWord], word)
	}
	var result [][]string

	for _, word := range anagramTable {
		result = append(result, word)
	}
	return result
}

func sortWord(word string) string {
	wordToSort := []byte(word)

	sort.Slice(wordToSort, func(i, j int) bool {
		return wordToSort[i] < wordToSort[j]
	})
	return string(wordToSort)
}
