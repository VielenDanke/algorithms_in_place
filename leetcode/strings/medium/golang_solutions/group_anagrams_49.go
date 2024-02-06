package golang_solutions

import (
	"fmt"
	"sort"
)

type AnagramKey [26]byte

func groupAnagramsSeparateDs(strs []string) [][]string {
	strGroups := make(map[AnagramKey][]string)
	for _, v := range strs {
		anagramKey := createAnagramKey(v)
		strGroups[anagramKey] = append(strGroups[anagramKey], v)
	}
	result := make([][]string, 0)
	for _, v := range strGroups {
		result = append(result, v)
	}
	return result
}

func createAnagramKey(str string) (anagramKey AnagramKey) {
	for _, v := range str {
		anagramKey[v-'a']++
	}
	return
}

// ----------------------------------------------------------

func groupAnagramsNoSort(strs []string) [][]string {
	m := make(map[string][]string)
	for _, v := range strs {
		alph := make([]int, 26)
		for _, ch := range v {
			alph[ch-'a']++
		}
		str := ""
		for idx, count := range alph {
			if count > 0 {
				str += fmt.Sprintf("%d%s", count, string(rune(idx+'a')))
			}
		}
		m[str] = append(m[str], v)
	}
	result := make([][]string, 0)
	for _, v := range m {
		result = append(result, v)
	}
	return result
}

// ----------------------------------------------------------

func groupAnagrams(anagrams []string) [][]string {
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
